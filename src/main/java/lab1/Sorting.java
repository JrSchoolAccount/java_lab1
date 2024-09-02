package lab1;

import java.util.Arrays;
import java.util.Comparator;

public class Sorting {
    public static void sortArr(Price[] prices) {
        if (prices.length == 0) {
            System.out.println("Priser saknas! Vänligen kör \"1. Inmatning\" eller \"5. Inmatning från elpriser.csv\" först.");
            return;
        }

        Price[] sortedPrices = Arrays.copyOf(prices, prices.length);

        Arrays.sort(sortedPrices, Comparator.comparingDouble(Price::price));

        for (Price price : sortedPrices) {
            System.out.println(price.hour() + ": " + price.price() + " öre");
        }
    }
}