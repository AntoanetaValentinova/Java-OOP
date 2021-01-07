package Animal.animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal (String name,int age,String gender) {
        this.name=name;
        this.age=age;
        this.gender=gender;
    }

    public String produceSound () {
        if (getClass().getSimpleName().equals("Dog")) {
            return "Woof!";
        } else if  (getClass().getSimpleName().equals("Cat")) {
            return "Meow meow";
        } else if  (getClass().getSimpleName().equals("Frog")) {
            return "Ribbit";
        } else if  (getClass().getSimpleName().equals("Kitten")) {
            return "Meow";
        } else if  (getClass().getSimpleName().equals("Tomcat")) {
            return "MEOW";
        }
        return "";
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s%n%s",getClass().getSimpleName(),this.name,this.age,this.gender,this.produceSound());
    }
}
