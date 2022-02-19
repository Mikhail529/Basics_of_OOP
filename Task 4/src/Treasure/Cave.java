package Treasure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cave {
    ArrayList<String> stringArrayList = new ArrayList<>();
    ArrayList<Treasure> treasureArrayList = new ArrayList<>();

    public Cave() throws FileNotFoundException {
        File fileTreasure = new File("src/TextFile/Treasure");
        Scanner scanner = new Scanner(fileTreasure);
        while (scanner.hasNextLine()) {
            this.stringArrayList.add(scanner.nextLine());
        }
        scanner.close();

        for (String s : stringArrayList) {
            createObject(s);
        }
    }

    private void createObject(String string) {
        Treasure treasure = new Treasure();

        Pattern patternName = Pattern.compile("\\d{1,3}\\.\\s\\D+");
        Matcher matcherName = patternName.matcher(string);
        while (matcherName.find()) {
            treasure.setName(matcherName.group());
        }

        Pattern patternWeight = Pattern.compile("\\d+\\w(g)");
        Matcher matcherWeight = patternWeight.matcher(string);
        while (matcherWeight.find()) {
            treasure.setWeight(matcherWeight.group());
        }

        Pattern patternPrice = Pattern.compile("\\d+\\.\\d{2}");
        Matcher matcherPrice = patternPrice.matcher(string);
        while (matcherPrice.find()) {
            treasure.setPrice(Double.parseDouble(matcherPrice.group()));
        }

        treasureArrayList.add(treasure);
    }

    public void showExpensiveTreasure() {
        String string = "";
        double max = treasureArrayList.get(0).getPrice();

        for (Treasure treasure : treasureArrayList) {
            if (max < treasure.getPrice()) {
                max = treasure.getPrice();
                string = String.valueOf(treasure);
            }
        }
        System.out.println("Dear Treasure: \n" + string);
    }

    public void showAllTreasure() {
        for (Treasure treasure : treasureArrayList) {
            System.out.println(treasure.toString());
        }
    }

    public void selectionTreasure(double sum) {
        sumRecursion(sum);
    }

    private void sumRecursion(double sum) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your current amount: $" + sum);
        System.out.println("Enter position number: ");
        int number = scanner.nextInt();
        number--;
        while (treasureArrayList.get(number).getPrice() > sum) {
            System.out.println("\t\tInsufficient Balanc!");
            System.out.println("\tThe price of the product: $" + treasureArrayList.get(number).getPrice());
            System.out.println("To continue, enter: \"n\" or \"y\": ");
            if (scanner.nextLine().equals("n")) {
                System.out.println("Account balance: $" + sum);
                return;
            }
            if (scanner.nextLine().equals("y")) {
                System.out.println("Enter position number: ");
                number = scanner.nextInt();
                number--;
            }
        }
        sum = sum-treasureArrayList.get(number).getPrice();
        System.out.println("The price of the product: $" + treasureArrayList.get(number).getPrice());
        System.out.println("Account balance: $" + sum);

        System.out.println("To continue, enter: \"n\" or \"y\": ");
        Scanner scanner1 = new Scanner(System.in);
        String x = scanner1.nextLine();
        if (x.equals("y")) {
            sumRecursion(sum);
        }
        if (x.equals("n")) {
            System.out.println("Account balance: $" + sum);
        }
    }
}