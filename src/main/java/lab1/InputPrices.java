package lab1;

import java.util.Scanner;

public class InputPrices {
    public Price[] getHourlyPrices(Scanner sc) {
        Price[] prices = new Price[24];

        for (int i = 0; i < 24; i++) {
            String hour = String.format("%02d-%02d", i, (i + 1) % 24);
            int price = Integer.MIN_VALUE;

            while (true) {
                System.out.print("Ange pris för " + hour + " i ören: ");
                try {
                    price = Integer.parseInt(sc.nextLine());

                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Felaktig inmatning, vänligen ange ett heltal.");
                }
            }

            prices[i] = new Price(price, hour);
        }

        return prices;
    }
}
