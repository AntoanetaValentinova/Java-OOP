package HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scan = new Scanner(System.in);

        String neededModifier = scan.nextLine();
        Class<?> reflection = Class.forName("HarvestingFields.RichSoilLand");

        Field[] declaredFields = reflection.getDeclaredFields();


        while (!neededModifier.equals("HARVEST")) {
            print(neededModifier, declaredFields);
            neededModifier = scan.nextLine();
        }

    }

    private static void print(String neededModifier, Field[] declaredFields) {
        switch (neededModifier) {
            case "private":
                for (Field declaredField : declaredFields) {
                    if (Modifier.isPrivate(declaredField.getModifiers())) {
                        System.out.printf("%s %s %s%n", Modifier.toString(declaredField.getModifiers()), declaredField.getType().getSimpleName(), declaredField.getName());
                    }
                }
                break;
            case "protected":
                for (Field declaredField : declaredFields) {
                    if (Modifier.isProtected(declaredField.getModifiers())) {
                        System.out.printf("%s %s %s%n", Modifier.toString(declaredField.getModifiers()), declaredField.getType().getSimpleName(), declaredField.getName());
                    }
                }
                break;
            case "public":
                for (Field declaredField : declaredFields) {
                    if (Modifier.isPublic(declaredField.getModifiers())) {
                        System.out.printf("%s %s %s%n", Modifier.toString(declaredField.getModifiers()), declaredField.getType().getSimpleName(), declaredField.getName());
                    }
                }
                break;
            case "all":
                for (Field declaredField : declaredFields) {
                        System.out.printf("%s %s %s%n", Modifier.toString(declaredField.getModifiers()), declaredField.getType().getSimpleName(), declaredField.getName());
                }
                break;
        }
    }

}
