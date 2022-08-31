package DesignPatterns.Singleton;

import java.util.HashMap;
import java.util.Map;

public class SingletonDataContainer implements SingletonContainer{

    private static SingletonDataContainer instance;
    private Map<String, Integer> capitals;

    //private constructor that will be called only once
    private SingletonDataContainer() {
        this.capitals = new HashMap<>();
        System.out.println("Initializing singleton object.");
    }

    @Override
    public int getPopulation(String name) {
        return capitals.get(name);
    }

    @Override
    public void addPopulation(String capital, int amount) {
        capitals.putIfAbsent(capital, 0);
        capitals.put(capital, capitals.get(capital) + amount);
    }

    @Override
    public void reducePopulation(String capital, int amount) {
        capitals.put(capital, capitals.get(capital) - amount);
    }

    //returns the instance of an object without creating a new instance(if an instance already exists)
    public static SingletonDataContainer getInstance(){
        if(instance != null){
            return instance;
        }
        instance = new SingletonDataContainer();
        return instance;
    }
}
