package DesignPatterns.Singleton;

public class Main {
    public static void main(String[] args) {

        SingletonDataContainer instance = SingletonDataContainer.getInstance();

        instance.addPopulation("Sofia", 2000000);
        instance.addPopulation("Varna", 150000);

        System.out.println(instance.getPopulation("Sofia"));

        SingletonDataContainer instance1 = SingletonDataContainer.getInstance();
        System.out.println(instance.getPopulation("Varna"));


    }
}
