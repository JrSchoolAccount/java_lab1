package lab1;

public class MinMaxAverage {

    public static void analyzePrices(Price[] prices) {
        if (prices.length == 0) {
            System.out.println("Priser saknas! Vänligen kör \"1. Inmatning\" eller \"5. Inmatning från elpriser.csv\" först.");
            return;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int total = 0;

        String minHour = "";
        String maxHour = "";


        for (Price price : prices) {
            int currentPrice = price.price();
            String currentHour = price.hour();

            if (currentPrice < min) {
                min = currentPrice;
                minHour = currentHour;
            }

            if (currentPrice > max) {
                max = currentPrice;
                maxHour = currentHour;
            }

            total += currentPrice;

        }

        int average = total / prices.length;

        System.out.println("Lägstapris : " + minHour + "h, " + min + " öre/kWh");
        System.out.println("Högstapris : " + maxHour + "h, " + max + " öre/kWh");
        System.out.println("Medelpriset  : " + average + " öre/kWh");
    }
}
