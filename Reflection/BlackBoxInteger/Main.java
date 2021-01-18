package BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scan = new Scanner(System.in);

        String input=scan.nextLine();

        Class clazz=Class.forName("BlackBoxInteger.BlackBoxInt");

        Constructor<?> constructor =  clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = (BlackBoxInt)constructor.newInstance();


        while (!input.equals("END")) {
            printCurrentInnerValue(input, clazz, blackBoxInt);
            input=scan.nextLine();
        }
        System.out.println();
    }

    private static void printCurrentInnerValue(String input, Class clazz, BlackBoxInt blackBoxInt) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        String [] tokens=input.split("_");
        String commandName=tokens[0];
        int value= Integer.parseInt(tokens[1]);
        Method declaredMethod = clazz.getDeclaredMethod(commandName,int.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(blackBoxInt, value);
        Field field=clazz.getDeclaredField("innerValue");
        field.setAccessible(true);
        System.out.println(field.getInt(blackBoxInt));
    }
}
