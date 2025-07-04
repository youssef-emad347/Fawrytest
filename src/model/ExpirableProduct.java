package model;

import java.time.LocalDate;

public class ExpirableProduct extends Product implements Expirable{
    LocalDate expiryDate;
    public ExpirableProduct(String name, float price, int quantity,String expiryDate) {
        super(name, price, quantity);
        this.expiryDate = LocalDate.parse(expiryDate);

    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
