package Inheritance.Exercise.animals;

public class Tomcat extends Animal {
    private static final String GENDER = "Male";

    public Tomcat(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound(){
        return "MEOW";
    }
}
