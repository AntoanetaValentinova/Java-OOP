package FoodShortage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n= Integer.parseInt(scan.nextLine());

        Map<String, Buyer> buyers = getBuyers(scan, n);

        String name=scan.nextLine();

        buyFood(scan, buyers, name);

        printTotalFood(buyers);
    }

    private static void printTotalFood(Map<String, Buyer> buyers) {
        int food=0;
        for (Buyer buyer : buyers.values()) {
            food+=buyer.getFood();
        }

        System.out.println(food);
    }

    private static void buyFood(Scanner scan, Map<String, Buyer> buyers, String name) {
        while (!name.equals("End")) {
            if (buyers.containsKey(name)) {
                buyers.get(name).buyFood();
            }
            name=scan.nextLine();
        }
    }

    private static Map<String, Buyer> getBuyers(Scanner scan, int n) {
        Map<String,Buyer> buyers=new LinkedHashMap<>();
        for (int i = 0; i <n ; i++) {
            String [] tokens=scan.nextLine().split("\\s+");
            String name=tokens[0];
            int age= Integer.parseInt(tokens[1]);
            if (tokens.length==4) {
                String id=tokens[2];
                String birthDate=tokens[3];
                Citizen citizen=new Citizen(name,age,id,birthDate);
                buyers.putIfAbsent(name,citizen);
            } else {
                String group=tokens[2];
                Rebel rebel=new Rebel(name,age,group);
                buyers.putIfAbsent(name,rebel);
            }
        }
        return buyers;
    }

}
