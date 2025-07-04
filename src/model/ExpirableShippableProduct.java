package model;

import java.time.LocalDate;

public class ExpirableShippableProduct extends Product implements Expirable,Shippable {
    double weight;
    LocalDate expiryDate;

    public ExpirableShippableProduct(String name, float price, int quantity,String expiryDate,double weight) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = LocalDate.parse(expiryDate);
        setShippable(true);
        setExpirable(true);
    }

    public double getWeight() {
        return weight;
    }
    public String getName(){
        return super.getName();
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
