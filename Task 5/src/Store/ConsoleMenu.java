package Store;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConsoleMenu {

    public void menu() throws FileNotFoundException {
        Store store = new Store("");

        System.out.println("Show flower list  - 1");
        System.out.println("Show packing list - 2");
        System.out.println("Add order         - 3 \n");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = scanner.nextInt();

        switch (number) {
            case 1:
                store.showFlowersAvailable();
                break;
            case 2:
                store.showTypeOfPackaging();
                break;
            case 3:
                store.addOrder();
                break;
        }
    }
}