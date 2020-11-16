
package greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] itemsAndQuantities = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap();
        long gold = 0;
        long gem = 0;
        long money = 0;

        for (int i = 0; i < itemsAndQuantities.length; i += 2) {
            String itemInput = itemsAndQuantities[i];
            long quantity = Long.parseLong(itemsAndQuantities[i + 1]);
            String item = getItem(itemInput);

            if (validateCollectInTheBagOperation(capacity, bag, quantity, item)) {
                continue;
            }

            switch (item) {
                case "Gem":
                    if (checkCapacityCollectGem(bag, quantity, item, "Gold")) continue;
                    break;
                case "Cash":
                    if (checkCapacityCollectGem(bag, quantity, item, "Gem")) continue;
                    break;
            }

            fillMap(bag, itemInput, quantity, item);

            if (item.equals("Gold")) {
                gold += quantity;
            } else if (item.equals("Gem")) {
                gem += quantity;
            } else if (item.equals("Cash")) {
                money+= quantity;
            }
        }

        printOutput(bag);
    }

    public static void printOutput(Map<String, LinkedHashMap<String, Long>> bag) {
        for (Map.Entry<String,LinkedHashMap<String,Long>> entry : bag.entrySet()) {
            Long sum = entry.getValue().values().stream().mapToLong(l -> l).sum();
            System.out.println(String.format("<%s> $%s", entry.getKey(), sum));
            entry.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    public static void fillMap(Map<String, LinkedHashMap<String, Long>> bag, String itemInput, long quantity, String item) {
        if (!bag.containsKey(item)) {
            bag.put((item), new LinkedHashMap<String, Long>());
        }

        if (!bag.get(item).containsKey(itemInput)) {
            bag.get(item).put(itemInput, 0L);
        }

        bag.get(item).put(itemInput, bag.get(item).get(itemInput) + quantity);
    }

    public static boolean checkCapacityCollectGem(Map<String, LinkedHashMap<String, Long>> bag, long quantity, String item, String gold2) {
        if (!bag.containsKey(item)) {
            if (bag.containsKey(gold2)) {
                if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                    return true;
                }
            } else {
                return true;
            }
        } else if (bag.get(item).values().stream().mapToLong(e -> e).sum() + quantity > bag.get(gold2).values().stream().mapToLong(e -> e).sum()) {
            return true;
        }
        return false;
    }

    public static boolean validateCollectInTheBagOperation(long capacity, Map<String, LinkedHashMap<String, Long>> bag, long quantity, String item) {
        if (item.equals("")) {
            return true;
        } else if (isReachCapacity(capacity, bag, quantity)) {
            return true;
        }
        return false;
    }

    public static boolean isReachCapacity(long capacity, Map<String, LinkedHashMap<String, Long>> bag, long quantity) {
        return capacity < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + quantity;
    }

    public static String getItem(String itemInput) {
        String item = "";

        if (itemInput.length() == 3) {
            item = "Cash";
        } else if (itemInput.toLowerCase().endsWith("gem")) {
            item = "Gem";
        } else if (itemInput.toLowerCase().equals("gold")) {
            item = "Gold";
        }
        return item;
    }
}