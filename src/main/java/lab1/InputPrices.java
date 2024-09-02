package lab1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class InputPrices {

    public Price[] getHourlyPrices(Scanner sc) {
        Price[] prices = new Price[24];

        for (int i = 0; i < 24; i++) {
            String hour = String.format("%02d-%02d", i, (i + 1) % 24);
            int price;

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

    public Price[] getPricesFromCsv() {
        String filePath = "elpriser.csv";
        File file = new File(filePath);

        if (!file.exists() || !file.canRead()) {
            System.out.println("Fel: Filen finns inte eller kan inte läsas: " + filePath);
            return new Price[0];
        }

        Price[] prices = new Price[24];
        int index = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Läser filen: " + filePath);
            String line;

            br.readLine();

            while ((line = br.readLine()) != null && index < prices.length) {
                System.out.println("Processing line: " + line);
                Price price = parseCSVLine(line);
                if (price != null) {
                    prices[index++] = price;
                }
            }

        } catch (IOException e) {
            System.out.println("Fel vid läsning av CSV-fil: " + e.getMessage());
        }

        return prices;
    }

    private Price parseCSVLine(String line) {
        String[] values = line.split(",");
        if (values.length == 2) {
            String hour = values[0].trim();
            try {
                int price = Integer.parseInt(values[1].trim());
                return new Price(price, hour);
            } catch (NumberFormatException e) {
                System.out.println("Felaktigt prisformat i raden: " + line);
            }
        } else {
            System.out.println("Felaktigt format i raden: " + line);
        }
        return null;
    }
}