package Oct4Th2022.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sidharth Das
 * created on  10/02/23
 */
public class Leetcode25MainClass {
}

class Cashier {

    int n;
    int discount;
    List<Integer> products;
    List<Integer> prices;
    int i = 0;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.products = Arrays.stream(products).boxed().toList();
        this.prices = Arrays.stream(prices).boxed().toList();
    }

    public double getBill(int[] product, int[] amount) {
        double sum = 0.0;
        i += 1;
        int len = product.length;
        for (int i = 0; i < len; i++) {
            sum += amount[i] * prices.get(products.indexOf(product[i]));
        }

        if (i == 3) {
            sum = sum * ((100 - discount) / 100);
            i = 0;
        }

        return sum;
    }
}
