package SalaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    private double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    private String getFirstName() {
        return firstName;
    }

    private String getLastName() {
        return lastName;
    }

    private int getAge() {
        return age;
    }

    public void increaseSalary(double bonus) {
        if (this.age<30) {
            this.salary=(this.salary*(1+(bonus/2/100)));
        } else {
            this.salary=(this.salary*(1+(bonus/100)));
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva",this.firstName,this.lastName,this.salary);
    }
}
