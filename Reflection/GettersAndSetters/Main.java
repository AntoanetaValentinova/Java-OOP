package GettersAndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    
    public static class ComparatorByName implements Comparator<Method> {

        @Override
        public int compare(Method first, Method second) {
            return first.getName().compareTo(second.getName());
        }
    }
    
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {

        Class<?> clazz=Class.forName("GettersAndSetters.Reflection");

        Method[] declaredMethods = clazz.getDeclaredMethods();

        Set<Method> getters=new TreeSet<>(new ComparatorByName());
        Set<Method> setters=new TreeSet<>(new ComparatorByName());

        for (Method method : declaredMethods) {
            if (method.getName().startsWith("set")) {
                setters.add(method);
            } else if (method.getName().startsWith("get")) {
                getters.add(method);
            }
        }

        for (Method getter : getters) {
            System.out.printf("%s will return class %s%n",getter.getName(),getter.getReturnType().getName());
        }
        for (Method setter : setters) {
            System.out.printf("%s and will set field of class %s%n",setter.getName(),setter.getParameterTypes()[0].getName());
        }
        System.out.println();
    }
}
