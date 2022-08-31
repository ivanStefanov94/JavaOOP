package WorkingWithAbstraction.exercise.CardSuite;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();


        if(input.equals("Card Suits")){
            System.out.println("Card Suits:");

            for (CardSuits c : CardSuits.values()) {
                System.out.printf("Ordinal value: %d; Name value: %s%n", c.getValue(), c);
            }


        }
    }
}
