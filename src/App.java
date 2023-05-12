import java.util.List;
import java.util.stream.Collectors;

import com.makkajai.receipts.ReadReceipts;
import com.makkajai.receipts.WriteReceipts;
import com.makkajai.tax.TaxCalculator;

public class App {
    private static final String DIRECTORY_PATH = "assets";

    public static void main(String[] args) throws Exception {
        ReadReceipts readReceipts = new ReadReceipts(DIRECTORY_PATH);
        List<TaxCalculator> taxCalculators = readReceipts.getCarts().stream()
                .map(cart -> new TaxCalculator(cart.getCartProducts()))
                .collect(Collectors.toList());
        new WriteReceipts(DIRECTORY_PATH, taxCalculators).writeReceipts();
        System.out.println("Output generated in directory " + DIRECTORY_PATH + "/output");
    }
}
