package model;

public class ShippableProduct extends Product implements Shippable{
    double weight;

    public ShippableProduct(String name, float price, int quantity,double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
    public String getName(){
        return super.getName();
    }
}
