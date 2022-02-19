package Treasure;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConsoleMenu {

    public ConsoleMenu() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu: Enter the transaction number to select");

        System.out.println("1. View all treasures");
        System.out.println("2. See the most precious treasure");
        System.out.println("3. Treasure selection worth");

        int number = scanner.nextInt();

        Cave cave = new Cave();

        switch (number) {
            case 1:
                cave.showAllTreasure();
                break;
            case 2:
                cave.showExpensiveTreasure();
                break;
            case 3:
                System.out.println("Enter your amount: ");
                double sum = scanner.nextDouble();
                cave.selectionTreasure(sum);
                break;
        }
    }
}