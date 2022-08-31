package DesignPatterns.Singleton;

public interface SingletonContainer {
    int getPopulation(String capital);
    void addPopulation(String capital, int amount);
    void reducePopulation(String capital, int amount);
}
