package lab1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    private static final Set<String> VALID_INPUTS = new HashSet<>();

    static {
        VALID_INPUTS.add("1");
        VALID_INPUTS.add("2");
        VALID_INPUTS.add("3");
        VALID_INPUTS.add("4");
        VALID_INPUTS.add("e");
    }

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        InputPrices inputPrices = new InputPrices();
        Price[] prices = null;

        while (true) {
            System.out.println("""
                    
                    Elpriser
                    ========
                    1. Inmatning
                    2. Min, Max och Medel
                    3. Sortera
                    4. Bästa Laddningstid (4h)
                    e. Avsluta""");

            String input = sc.nextLine().toLowerCase();

            try {
                if (!VALID_INPUTS.contains(input)) {
                    throw new IllegalArgumentException("Invalid input: " + input);
                }

                if (input.equals("1")) {
                    prices = inputPrices.getHourlyPrices(sc);
                }

                if (input.equals("2")) {
                    MinMaxAverage.analyzePrices(prices);
                }

                if (input.equals("3")) {
                    Sorting.sortArr(prices);
                }

                if (input.equals("e")) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Input. Try again.");
            }
        }
    }
}
