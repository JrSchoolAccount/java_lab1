package lab1;

import java.util.Arrays;
import java.util.Comparator;

public class Sorting {
    public static void sortArr(Price[] prices) {

        Price[] sortedPrices = Arrays.copyOf(prices, prices.length);

        Arrays.sort(sortedPrices, Comparator.comparingDouble(Price::price));

        for (Price price : sortedPrices) {
            System.out.println(price.hour() + ": " + price.price() + " öre");
        }
    }
}