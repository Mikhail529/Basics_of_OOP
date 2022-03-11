package Store;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Store implements Flower, PackageFlower {
    String nameCompany;
    String nameOfFlowers;
    String typeOfPackaging;

    public Store(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public void addOrder() {
        Order order = new Order();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Choose a flower: ");
        String tempFlower = scanner1.nextLine();
        order.setNameOfFlowers(tempFlower);

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Select type of packaging: ");
        String tempPackaging = scanner2.nextLine();
        order.setTypeOfPackaging(tempPackaging);

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Enter number of flowers: ");
        int tempNofF = scanner3.nextInt();
        order.setNumberOfFlowers(tempNofF);

        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Enter buyer's name: ");
        String tempNameBuyer = scanner4.nextLine();
        order.setNameCustomer(tempNameBuyer);

        Scanner scanner5 = new Scanner(System.in);
        System.out.println("Enter your phone number in the format +357 (__) ___ __ __: ");
        String tempPhone = scanner5.nextLine();
        order.setPhoneCustomer(tempPhone);

        System.out.println(order);
    }

    @Override
    public void showFlowersAvailable() throws FileNotFoundException {
        String separator = File.separator;
        String path = "src" + separator + "TextFile" + separator + "FlowersAvailable";
        File fileFlowers = new File(path);

        Scanner scanner = new Scanner(fileFlowers);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    @Override
    public void showTypeOfPackaging() throws FileNotFoundException {
        String separator = File.separator;
        String path = "src" + separator + "TextFile" + separator + "TypeOfPackaging";
        File fileType = new File(path);

        Scanner scanner = new Scanner(fileType);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    @Override
    public String toString() {
        return "Store: \"" + nameCompany + "\"";
    }

    static class Order extends Store {
        int numberOfFlowers;
        String phoneCustomer;
        String nameCustomer;

        public Order() {
            super("\"World Flowers Plus\"");
        }

        public int getNumberOfFlowers() {
            return numberOfFlowers;
        }

        public void setNumberOfFlowers(int numberOfFlowers) {
            this.numberOfFlowers = numberOfFlowers;
        }

        public String getPhoneCustomer() {
            return phoneCustomer;
        }

        public void setPhoneCustomer(String phoneCustomer) {
            this.phoneCustomer = phoneCustomer;
        }

        public String getNameCustomer() {
            return nameCustomer;
        }

        public void setNameCustomer(String nameCustomer) {
            this.nameCustomer = nameCustomer;
        }

        @Override
        public String toString() {
            return "\t\t*** Order ***" +
                    "\nCompany:\t\t\t" + nameCompany +
                    "\nFlower name:\t\t" + nameOfFlowers +
                    "\nType of Packaging:\t" + typeOfPackaging +
                    "\nNumber of Flowers:\t" + numberOfFlowers +
                    "\nCustomer name:\t\t" + nameCustomer +
                    "\nCustomer phone:\t\t+375" + phoneCustomer;
        }

        public String getNameCompany() {
            return nameCompany;
        }

        public void setNameCompany(String nameCompany) {
            this.nameCompany = nameCompany;
        }

        public String getNameOfFlowers() {
            return nameOfFlowers;
        }

        public void setNameOfFlowers(String nameOfFlowers) {
            this.nameOfFlowers = nameOfFlowers;
        }

        public String getTypeOfPackaging() {
            return typeOfPackaging;
        }

        public void setTypeOfPackaging(String typeOfPackaging) {
            this.typeOfPackaging = typeOfPackaging;
        }
    }
}