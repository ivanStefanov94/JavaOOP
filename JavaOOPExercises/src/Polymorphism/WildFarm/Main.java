package Polymorphism.WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String evenLine = scan.nextLine();

        List<Animal> animalList = new ArrayList<>();

        while(!evenLine.equals("End")){

            String oddLine = scan.nextLine();

            Animal animal = createAnimal(evenLine.split("\\s+"));
            Food food = createFood(oddLine.split("\\s+"));

            animal.makeSound();

            try{
                animal.eat(food);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }

            animalList.add(animal);

            evenLine = scan.nextLine();
        }

        for (Animal animal : animalList) {
            System.out.println(animal.toString());
        }
    }

    private static Food createFood(String[] tokens) {
        int quantity = Integer.parseInt(tokens[1]);
        //return tokens[0].equals("Polymorphism.WildFarm.Meat") ? new Polymorphism.WildFarm.Meat(quantity) : new Polymorphism.WildFarm.Vegetable(quantity);
        if(tokens[0].equals("Polymorphism.WildFarm.Meat")){
            return new Meat(quantity);
        }
        return new Vegetable(quantity);
    }

    private static Animal createAnimal(String[] tokens) {
        switch(tokens[0]){
            case "Polymorphism.WildFarm.Cat":
                return new Cat(tokens[1], "Polymorphism.WildFarm.Cat", Double.parseDouble(tokens[2]), tokens[3], tokens[4]);
            case "Polymorphism.WildFarm.Tiger":
                return new Tiger(tokens[1], "Polymorphism.WildFarm.Tiger", Double.parseDouble(tokens[2]), tokens[3]);
            case "Polymorphism.WildFarm.Zebra":
                return new Zebra(tokens[1], "Polymorphism.WildFarm.Zebra", Double.parseDouble(tokens[2]), tokens[3]);
            case "Polymorphism.WildFarm.Mouse":
                return new Mouse(tokens[1], "Polymorphism.WildFarm.Mouse", Double.parseDouble(tokens[2]), tokens[3]);
            default:
                throw new IllegalStateException("Unknown animal type" + tokens[0]);
        }
    }
}
