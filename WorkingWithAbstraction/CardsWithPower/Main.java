package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String rank=scan.nextLine().toUpperCase();
        String suit=scan.nextLine().toUpperCase();

        printCardInfo(rank,suit);
    }

    private static void printCardInfo(String rank, String suit) {

        System.out.printf("Card name: %s of %s; Card power: %d",rank,suit,
                (RankPower.valueOf(rank).getPower()+SuitPower.valueOf(suit).getPower()));
    }
}
