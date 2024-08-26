package lab1;

import java.util.HashSet;
import java.util.Locale;
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
        while (true) {
            System.out.println(
                            "Elpriser\n" +
                            "========\n" +
                            "1. Inmatning\n" +
                            "2. Min, Max och Medel\n" +
                            "3. Sortera\n" +
                            "4. Bästa Laddningstid (4h)\n" +
                            "e. Avsluta");

            String input = sc.nextLine().toLowerCase();

            try {
                if (!VALID_INPUTS.contains(input)) {
                    throw new IllegalArgumentException("Invalid input: " + input);
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
