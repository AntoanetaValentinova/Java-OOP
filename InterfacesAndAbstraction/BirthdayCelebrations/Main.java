package BirthdayCelebrations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input=scan.nextLine();

        List<Birthable> citizensAndPets=new ArrayList<>();

        while (!input.equals("End")) {
            String [] tokens=input.split("\\s+");
            String type=tokens[0];
            switch (type) {
                case"Citizen" :
                    String name=tokens[1];
                    int age= Integer.parseInt(tokens[2]);
                    String id=tokens[3];
                    String birthdate=tokens[4];
                    Citizen citizen=new Citizen(name,age,id,birthdate);
                    citizensAndPets.add(citizen);
                    break;
                case"Robot" :
                    String model=tokens[1];
                    String idRobot=tokens[2];
                    Robot robot=new Robot(idRobot,model);
                    break;
                case"Pet" :
                    String petName=tokens[1];
                    String petBirthdate=tokens[2];
                    Pet pet=new Pet(petName,petBirthdate);
                    citizensAndPets.add(pet);
                    break;
            }
            input=scan.nextLine();
        }

        String year=scan.nextLine();

        for (Birthable citizensAndPet : citizensAndPets) {
            if (citizensAndPet.getBirthDate().endsWith(year)) {
                System.out.println(citizensAndPet.getBirthDate());
            }

        }

    }

}
