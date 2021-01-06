package FirstAndReserveTeam;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }


    public void setFirstName(String firstName) {
        checkNameLength(firstName, "First name cannot be less than 3 symbols");
        this.firstName=firstName;
    }

    public void setLastName(String lastName) {
        checkNameLength(lastName, "Last name cannot be less than 3 symbols");
        this.lastName = lastName;
    }

    private void checkNameLength(String lastName, String s) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException(s);
        }
    }

    public void setAge(int age) {
        if (age<=0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    private double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary<460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    private String getFirstName() {
        return firstName;
    }

    private String getLastName() {
        return lastName;
    }

    public int getAge() {
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
