package lab1;


public class ChargingOptimizer {
    public static void OptimalChargingTime(Price[] prices) {

        int minTotal = Integer.MAX_VALUE;
        int bestStartHour = 0;

        for (int i = 0; i <= prices.length - 4 ; i++) {
            int total = 0;

            for (int j = i; j < i + 4; j++) {
                total += prices[j].price();
            }

            if (total < minTotal) {
                minTotal = total;
                bestStartHour = i;
            }
        }

        int averagePrice = minTotal / 4;

        System.out.println("Bästa tid att börja ladda: " + prices[bestStartHour].hour());
        System.out.println("Total kostnad: " + minTotal + " öre/kWh");
        System.out.println("Medelpris: " + averagePrice + " öre/kWh");
    }
}
