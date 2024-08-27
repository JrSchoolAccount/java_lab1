package lab1;

import java.util.Arrays;
import java.util.Comparator;

public class Sorting {
    public static void sortArr(Price[] prices) {
        if (prices == null || prices.length == 0) {
            System.out.println("No prices found! Please run \"1. Inmatning\" first.");
            return;
        }
        Price[] sortedPrices = Arrays.copyOf(prices, prices.length);

        Arrays.sort(sortedPrices, Comparator.comparingDouble(Price::getPrice));

        for (Price price : sortedPrices) {
            System.out.println(price.getHour() + ": " + price.getPrice() + " öre");
        }
    }
}