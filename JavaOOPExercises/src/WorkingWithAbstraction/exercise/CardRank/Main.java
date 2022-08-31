package WorkingWithAbstraction.exercise.CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        if(input.equals("Card Ranks")){
            System.out.println("Card Ranks:");
            for (Rank rank : Rank.values()) {
                System.out.printf("Ordinal value: %d; Name value: %s%n", rank.ordinal(), rank);
            }
        }
    }
}
