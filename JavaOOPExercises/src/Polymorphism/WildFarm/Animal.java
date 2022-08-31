package Polymorphism.WildFarm;

public abstract class Animal  {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;

    protected Animal(String animalName, String animalType, double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
    }

    protected String getAnimalType() {
        return animalType;
    }

    public abstract void makeSound();
    public void eat(Food food){
        this.foodEaten += food.getQuantity();
    }


}
