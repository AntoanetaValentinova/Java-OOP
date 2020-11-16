package CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input=scan.nextLine();

        printCards(input);
    }

    public static void printCards(String input) {
        if (input.equals("Card Ranks")) {
            System.out.println("Card Ranks:");
            CardRank[] values = CardRank.values();
            for (CardRank card : values) {
                System.out.printf("Ordinal value: %d; Name value: %s%n",card.ordinal(),card);
            }
        }
    }
}
