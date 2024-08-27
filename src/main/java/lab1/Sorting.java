package lab1;

import java.util.Arrays;
import java.util.Comparator;

public class Sorting {
    public static void sortArr(Price[] prices) {
        if (prices == null || prices.length == 0) {
            System.out.println("No prices found! Please run \"1. Inmatning\" first.");
            return;
        }

        Arrays.sort(prices, Comparator.comparingDouble(Price::getPrice));

        for (Price price : prices) {
            System.out.println(price.getHour() + ": " + price.getPrice() + " öre");
        }
    }
}
