package Inheritance.Exercise.animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender){
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public void setName(String name) {
        if(name.isEmpty()){
        this.name = name;
        }else{
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public void setAge(int age) {
        if(age>=0){
        this.age = age;
        }else{
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public void setGender(String gender) {
        if(this.gender.equals("Male") || this.gender.equals("Female")){
        this.gender = gender;
        }else{
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public String produceSound(){
        return null;
    }

    @Override
    public String toString(){
        return String.format("%s%n%s %d %s%n %s",this.getClass().getSimpleName(), getName(), getAge(), getGender(),
                                                    produceSound());
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
}
