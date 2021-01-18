package HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {

        Class<?> clazz=Class.forName("HighQualityMistakes.Reflection");
        Set<Field> wrongFields=new TreeSet<>(Comparator.comparing(Field::getName));
        Set<Method> wrongSetters=new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> wrongGetters=new TreeSet<>(Comparator.comparing(Method::getName));

        getMistakes(clazz, wrongFields, wrongSetters, wrongGetters);

        print(wrongFields, wrongSetters, wrongGetters);
    }

    private static void print(Set<Field> wrongFields, Set<Method> wrongSetters, Set<Method> wrongGetters) {
        wrongFields.stream()
                .forEach(f-> System.out.println(String.format("%s must be private!",f.getName())));
        wrongGetters.stream()
                .forEach(g-> System.out.println(String.format("%s have to be public!",g.getName())));
        wrongSetters.stream()
                .forEach(s->System.out.println(String.format("%s have to be private!",s.getName())));
    }

    private static void getMistakes(Class<?> clazz, Set<Field> wrongFields, Set<Method> wrongSetters, Set<Method> wrongGetters) {
        getWrongFields(clazz, wrongFields);
        getWrongMethods(clazz, wrongSetters, wrongGetters);
    }

    private static void getWrongMethods(Class<?> clazz, Set<Method> wrongSetters, Set<Method> wrongGetters) {
        Method[] declaredMethods=clazz.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().startsWith("set")&&!Modifier.isPrivate(declaredMethod.getModifiers())) {
                wrongSetters.add(declaredMethod);
            } else if (declaredMethod.getName().startsWith("get")&&!Modifier.isPublic(declaredMethod.getModifiers())) {
                wrongGetters.add(declaredMethod);
            }
        }
    }

    private static void getWrongFields(Class<?> clazz, Set<Field> wrongFields) {
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (!Modifier.isPrivate(declaredField.getModifiers())) {
                wrongFields.add(declaredField);
            }
        }
    }
}
