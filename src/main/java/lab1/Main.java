package lab1;

import java.util.Scanner;
import java.util.Set;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final Set<String> VALID_INPUTS = Set.of("1", "2", "3", "4", "5", "e");
    private static Price[] prices = new Price[0];

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        InputPrices inputPrices = new InputPrices();

        while (true) {
            displayMenu();
            String input = sc.nextLine().toLowerCase();

            if (!isValidInput(input)) {
                System.out.println("Invalid Input. Try again.");
            } else {
                handleInput(input, inputPrices);
            }
        }
    }

    private static void displayMenu() {
        System.out.println("""
                    
                    Elpriser
                    ========
                    1. Inmatning
                    2. Min, Max och Medel
                    3. Sortera
                    4. Bästa Laddningstid (4h)
                    5. Inmatning från elpriser.csv
                    e. Avsluta""");
    }

    private static boolean isValidInput(String input) {
        return VALID_INPUTS.contains(input);
    }

    private static boolean arePricesAvailable() {
        if (prices.length == 0) {
            System.out.println("Priser saknas! Vänligen kör \"1. Inmatning\" eller \"5. Inmatning från elpriser.csv\" först.");
            return false;
        }
        return true;
    }

    private static void handleInput(String input, InputPrices inputPrices) {
        switch (input) {
            case "1" -> prices = inputPrices.getHourlyPrices(sc);
            case "5" -> prices = inputPrices.getPricesFromCsv();
            case "e" -> System.exit(0);
            default -> handlePriceDependentCases(input);
        }
    }

    private static void handlePriceDependentCases(String input) {
        if (!arePricesAvailable()) return;

        switch (input) {
            case "2" -> MinMaxAverage.analyzePrices(prices);
            case "3" -> Sorting.sortArr(prices);
            case "4" -> ChargingOptimizer.OptimalChargingTime(prices);
        }
    }
}
