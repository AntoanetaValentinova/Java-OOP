package Animal;

import Animal.animals.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String animalType=scan.nextLine();

        List<Animal> animals=new ArrayList<>();
        while (!animalType.equals("Beast!")) {
            String [] animalInfo=scan.nextLine().split("\\s+");
            isInputValid(animalType,animalInfo);
            if (isInputValid(animalType,animalInfo)) {
                String name=animalInfo[0];
                int age= Integer.parseInt(animalInfo[1]);
                String gender=animalInfo[2];
                addAnimal(animalType,name,age,gender,animals);
            } else {
                System.out.println("Invalid input!");
            }
            animalType=scan.nextLine();
        }
        
        printAnimals(animals);
    }

    private static void printAnimals(List<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    private static void addAnimal(String animalType, String name, int age, String gender, List<Animal> animals) {
        if (animalType.equals("Cat")) {
            Cat cat=new Cat(name,age,gender);
            animals.add(cat);
        } else if (animalType.equals("Dog")) {
            Dog dog=new Dog(name,age,gender);
            animals.add(dog);
        } else if (animalType.equals("Frog")) {
            Frog frog=new Frog(name,age,gender);
            animals.add(frog);
        } else if (animalType.equals("Kitten")) {
            Kitten kitten=new Kitten(name,age);
            animals.add(kitten);
        } else if (animalType.equals("Tomcat")) {
            Tomcat tomcat=new Tomcat(name,age);
            animals.add(tomcat);
        }
    }

    private static boolean isInputValid(String animalType, String[] animalInfo) {
        String name=animalInfo[0];
        int age= Integer.parseInt(animalInfo[1]);
        String gender=animalInfo[2];
        if (!animalType.equals("Cat")&&!animalType.equals("Dog")&&!animalType.equals("Frog")&&!animalType.equals("Kitten")&&!animalType.equals("Tomcat")) {
            return false;
        }
        if (age<0) {
            return false;
        }
        if (!gender.equals("Male")&&!gender.equals("Female")) {
            return false;
        }
        if (animalInfo.length<3) {
            return false;
        }
        return true;

    }
}
