package lab1;

import java.util.Arrays;
import java.util.Comparator;

public class Sorting {
    public static void sortArr(Price[] prices) {
        if (prices == null || prices.length == 0) {
            System.out.println("Priser saknas! Vänligen kör \"1. Inmatning\" först.");
            return;
        }

        Price[] sortedPrices = Arrays.copyOf(prices, prices.length);

        Arrays.sort(sortedPrices, Comparator.comparingDouble(Price::price));

        for (Price price : sortedPrices) {
            System.out.println(price.hour() + ": " + price.price() + " öre");
        }
    }
}