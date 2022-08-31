package Encapsulation.PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings){
        setName(name);
        setToppings(numberOfToppings);
    }

    private void setName(String name) {
        if(this.name.trim().isEmpty() || this.name.length() >15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setToppings(int count) {
        if (count >= 0 && count <= 10){
            this.toppings = new ArrayList<>(count);
        }
        throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }
    public double getOverallCalories(){
        return this.dough.calculateCalories() + this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }
}
