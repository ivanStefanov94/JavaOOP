package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static aquarium.common.ConstantMessages.WATER_NOT_SUITABLE;
import static aquarium.common.ExceptionMessages.*;

public abstract class BaseAquarium implements Aquarium {

    private String name;
    private int capacity;
    private List<Decoration> decorations;
    private List<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
//        int sum = 0;
//        for (Decoration decoration : decorations) {
//            sum+=decoration.getComfort();
//        }
//        return sum;

        return decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if(this.capacity == this.fish.size()){
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }

        String fishWaterType = fish.getClass().getSimpleName().replaceAll("Fish", "");

        if(!this.getClass().getSimpleName().contains(fishWaterType)){
            throw new IllegalStateException(WATER_NOT_SUITABLE);
        }


        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        for (Fish fish1 : fish) {
            fish1.eat();
        }
    }

    @Override
    public String getInfo() {
//        StringBuilder builder = new StringBuilder();
//        builder.append(this.name).append("(").append(this.getClass().getSimpleName()).append(":").append(System.lineSeparator());
//        builder.append("Fish: ");
//        if(!this.fish.isEmpty()){
//            for (Fish fish1 : fish) {
//                builder.append(fish1).append(" ");
//            }
//        }else {
//            builder.append("none");
//        }
//        builder.append(System.lineSeparator()).append("Decorations: ").append(this.decorations.size()).append(System.lineSeparator());
//        builder.append("Comfort: ").append(calculateComfort());
//
//        return builder.toString();
        String fishOutput = fish.isEmpty()
                ? "none"
                :fish.stream().map(Fish::getName).collect(Collectors.joining(" "));

        return String.format(
                "%s (%s):%n" +
                "Fish: %s%n" +
                "Decorations: %d%n" +
                "Comfort: %d", name, this.getClass().getSimpleName(),fishOutput, this.decorations.size(), calculateComfort());
    }

    @Override
    public Collection<Fish> getFish() {
        return fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return decorations;
    }
}
