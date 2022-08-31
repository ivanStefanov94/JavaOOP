package Polymorphism.WildFarm;

public class Cat extends Felime {
    private String breed;


    protected Cat(String animalName, String animalType, double animalWeight, String livingRegion,String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }
}
