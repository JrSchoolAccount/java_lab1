package lab1;

public class MinMaxAverage {

    public static void analyzePrices(Price[] prices) {
        if (prices == null || prices.length == 0) {
            System.out.println("No prices found! Please run \"1. Inmatning\" first.");
            return;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int total = 0;

        String minHour = "";
        String maxHour = "";


        for (Price price : prices) {
            int currentPrice = price.getPrice();
            String currentHour = price.getHour();

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

        System.out.println("Lägsta priset : " + minHour + "h, " + min + " öre/kWh");
        System.out.println("Högsta priset : " + maxHour + "h, " + max + " öre/kWh");
        System.out.println("Medel priset  : " + average + " öre/kWh");
    }
}
