package StudentSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input=scan.nextLine();

        List<Student> students=new ArrayList<>();
        while (!input.equals("Exit")) {
            checkCommand(input, students);
            input=scan.nextLine();
        }
    }

    public static void checkCommand(String input, List<Student> students) {
        String [] tokens=input.split("\\s");
        String command=tokens[0];
        if (command.equals("Create")) {
            Student student=createNewStudent(tokens);
            students.add(student);
        } else if (command.equals("Show")) {
            showStudent(students,tokens);
        }
    }

    private static void showStudent(List<Student> students, String[] tokens) {
        String name=tokens[1];
        for (Student student : students) {
            if (student.getName().equals(name)) {
                System.out.println(student);
            }
        }
    }

    private static Student createNewStudent(String[] tokens) {
        String name=tokens[1];
        int age= Integer.parseInt(tokens[2]);
        double grade= Double.parseDouble(tokens[3]);
        return new Student(name,age,grade);
    }
}
