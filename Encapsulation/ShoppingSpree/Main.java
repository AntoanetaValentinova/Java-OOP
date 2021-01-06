package ShoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Person> personList = new LinkedHashMap<>();
        Map<String, Product> productsList = new LinkedHashMap<>();
        boolean shouldBreak=false;
        String[] people = scan.nextLine().split(";");
        addPerson(personList, people);

        String[] products = scan.nextLine().split(";");
        addProduct(productsList, products);

        String input = scan.nextLine();

        while (!input.equals("END")) {
            String[] command = input.split("\\s+");
            String person = command[0];
            String product = command[1];
                try {
                    personList.get(person).buyProduct(productsList.get(product));
                    System.out.printf("%s bought %s%n", person, product);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            input = scan.nextLine();
        }

        printPersonWithProducts(personList);
    }

    private static void printPersonWithProducts(Map<String, Person> personList) {
        personList
                .entrySet()
                .stream()
                .forEach(person -> {
                            System.out.printf("%s - ", person.getKey());
                            if (person.getValue().getProducts().isEmpty()) {
                                System.out.println("Nothing bought");
                            } else {
                                String collect = person.getValue()
                                        .getProducts()
                                        .stream()
                                        .map(String::valueOf)
                                        .collect(Collectors.joining(", "));
                                System.out.println(collect);
                            }
                        }
                );
    }

    private static void addProduct(Map<String, Product> productsList, String[] products) {
        for (int i = 0; i < products.length; i++) {
            String[] currentProduct = products[i].split("=");
            String name = currentProduct[0];
            double cost = Double.parseDouble(currentProduct[1]);
                Product product = new Product(name, cost);
                productsList.put(name, product);
        }
    }

    private static void addPerson(Map<String, Person> personList, String[] people) {
        for (int i = 0; i < people.length; i++) {
            String[] currentPerson = people[i].split("=");
            String name = currentPerson[0];
            double money = Double.parseDouble(currentPerson[1]);
                Person person = new Person(name, money);
                personList.put(name, person);
        }
    }
}
