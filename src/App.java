import java.util.List;

import com.makkajai.console.ReadConsole;
import com.makkajai.products.Cart;
import com.makkajai.tax.TaxCalculator;

/**
 * App
 */
public class App {

    public static void main(String[] args) throws Exception {
        ReadConsole readConsole = new ReadConsole();
        List<String> inputs = readConsole.getInput();
        for (String input : inputs) {
            Cart cart = new Cart(input);
            TaxCalculator taxCalculator = new TaxCalculator();
            taxCalculator.calculateTax(cart);
            System.out.println(cart);
            System.out.println(taxCalculator);
        }
    }
}