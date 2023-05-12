import java.util.List;
import java.util.stream.Collectors;

import com.makkajai.cart.Cart;
import com.makkajai.receipts.ReadReceipts;
import com.makkajai.receipts.WriteReceipts;
import com.makkajai.tax.TaxCalculator;

public class App {
    // Directory for receipts of products with data
    private static final String DIRECTORY_PATH = "assets";

    public static void main(String[] args) throws Exception {
        // Reading all the receipts from the directory

        ReadReceipts readReceipts = new ReadReceipts(DIRECTORY_PATH);

        // Getting all the carts at once after reading the receipts
        List<Cart> carts = readReceipts.getCarts();

        // getting the list of tax calculator instances with results
        List<TaxCalculator> taxCalculators = carts.stream()
                .map(cart -> new TaxCalculator(cart.getCartProducts()))
                .collect(Collectors.toList());

        // Generating the outputs with results in the output directory.
        new WriteReceipts(DIRECTORY_PATH, taxCalculators, carts).writeReceipts();

        System.out.println("Output generated in directory " + DIRECTORY_PATH + "/output");
    }
}
