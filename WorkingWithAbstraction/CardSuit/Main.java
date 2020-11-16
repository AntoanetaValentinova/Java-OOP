package CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input=scan.nextLine();

        printSuits(input);
    }

    public static void printSuits(String input) {
        if (input.equals("Card Suits")) {
            Suits[] values = Suits.values();
            System.out.println("Card Suits:");
            for (Suits value : values) {
                System.out.printf("Ordinal value: %d; Name value: %s%n",value.getValue(),value);
            }
        }
    }
}
