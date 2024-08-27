package lab1;

import java.util.Arrays;

public class ChargingOptimizer {
    public static void OptimalChargingTime(Price[] prices) {
        if (prices == null || prices.length == 0) {
            System.out.println("No prices found! Please run \"1. Inmatning\" first.");
            return;
        }

        int minTotal = Integer.MAX_VALUE;
        int bestStartHour = 0;

        for (int i = 0; i <= prices.length - 4 ; i++) {
            int total = 0;

            for (int j = i; j < i + 4; j++) {
                total += prices[j].getPrice();
            }

            if (total < minTotal) {
                minTotal = total;
                bestStartHour = i;
            }
        }

        int averagePrice = minTotal / 4;

        System.out.println("Best time to start charging: " + prices[bestStartHour].getHour());
        System.out.println("Total cost: " + minTotal + " öre/kWh");
        System.out.println("Average price: " + averagePrice + " öre/kWh");
    }
}
