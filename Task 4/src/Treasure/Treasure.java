package Treasure;

public class Treasure {
    private String name;
    private String weight;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Name:\t" + name +
                "\nWeight:\t" + weight +
                "\nPrice:\t$" + price + "\n";
    }
}