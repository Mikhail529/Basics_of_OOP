import java.util.ArrayList;
import java.util.Date;

public class CLS {
    public static void main(String[] args) {

        // Task 2. Создать класс Payment с внутреним классом, с помощью объектов которого можно сформировать
        // покупку из нескольких товаров

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product(5833181, 570.35, "Washing machine \"LG F2V9HS9W\""));
        productList.add(new Product(7548747, 890.15, "Smartphone \"Samsung Galaxy S21 FE 5G\""));
        productList.add(new Product(1518895, 155.51, "Vacuum cleaner \"Samsung VS15A6031R4\""));
        productList.add(new Product(5443799, 1770.53, "Notebook \"Apple Macbook Pro\""));
        productList.add(new Product(9901752, 1050.17, "TV set \"LG OLED55C1RLA\""));
        productList.add(new Product(8390781, 150.75, "Coffee machine \"DeLonghi Cappuccino\""));
        productList.add(new Product(2388889, 1990.27, "Camera \"Sony Alpha a7 III Body\""));

        Payment payment = new Payment();            // Создание первого покупателя
        payment.addPayment(productList.get(0));     // Первый покупатель покупает товар под индексом 0
        payment.addPayment(productList.get(1));     // Первый покупатель покупает товар под индексом 1
        payment.printPayment();                     // Оформление покупки, печать чека об плате для первого покупателя

        Payment payment1 = new Payment();           // Создание второго покупателя
        payment1.addPayment(productList.get(2));    // Второй покупатель покупает товар под индексом 2
        payment1.addPayment(productList.get(3));    // Второй покупатель покупает товар под индексом 3
        payment1.addPayment(productList.get(5));    // Второй покупатель покупает товар под индексом 5
        payment1.printPayment();                    // Оформление покупки, печать чека об плате для второго покупателя
    }
}

class Product {
    private int id;
    private double sum;
    private String name;

    public Product(int id, double sum, String name) {
        this.id = id;
        this.sum = sum;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product" +
                "\nid:\t\t" + id +
                "\nsum:\t" + sum +
                "\nname:\t" + name;
    }
}

class Payment{
    ArrayList<BankCheck> bankCheckList;
    private Date date;

    public Payment() {
        this.bankCheckList = new ArrayList<>();
    }

    public void addPayment(Product product) {
        bankCheckList.add(new BankCheck(product.getSum(), product.getName()));
        this.date = new Date();
    }

    public void printPayment() {
        double temp = 0;
        System.out.println("------------------------------------------------------");
        System.out.println("\t\t\t\t***** Check *****");
        System.out.println("------------------------------------------------------");
        for (BankCheck bankCheck : bankCheckList) {
            System.out.println(bankCheck);
            temp += bankCheck.sum;
            System.out.println();
        }
        System.out.println("------------------------------------------------------");
        System.out.println("To pay: " + temp + "\t\tData: " + date);
        System.out.println("------------------------------------------------------");
        System.out.println();
    }

    static class BankCheck {
        private final double sum;
        private final String name;
        private final String status;

        public BankCheck(double sum, String name) {
             this.sum = sum;
             this.name = name;
             this.status = "PAID";
        }

        @Override
        public String toString() {
            return  "Sum product:\t" + sum +
                    "\nProduct:\t\t" + name +
                    "\nStatus:\t\t\t" + status;
        }
    }
}