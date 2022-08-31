package WorkingWithAbstraction.exercise.TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] lightsColor = scan.nextLine().split(" ");
        int count = Integer.parseInt(scan.nextLine());

        List<Light> lightsList = new ArrayList<>();

        for (String color : lightsColor) {
            Light light = new Light(Colors.valueOf(color));
            lightsList.add(light);
        }

        for (int i = 0; i < count; i++) {
            for (Light light : lightsList) {
                light.changeColor();
                System.out.print(light.getColor() + " ");
            }
            System.out.println();
        }
    }
}
