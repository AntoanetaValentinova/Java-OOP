package StudentSystem;

public class Student {
    private String name;
    private int age;
    private double grade;


    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String commentary(double grade) {
        if (this.grade >= 5.00) {
            return "Excellent student.";
        } else if (this.grade < 5.00 && this.grade >= 3.50) {
            return "Average student.";
        }
        return "Very nice person.";

    }

    @Override
    public String toString() {
        return String.format("%s is %d years old. %s", this.name, this.age, commentary(this.grade));
    }
}
