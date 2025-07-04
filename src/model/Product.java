package model;

public class Product {
    private String name;
    private float price;
    private int quantity;
    private boolean isShippable;
    private boolean isExpirable;

    public Product(String name, float price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isShippable() {
        return isShippable;
    }

    public void setShippable(boolean shippable) {
        isShippable = shippable;
    }

    public boolean isExpirable() {
        return isExpirable;
    }

    public void setExpirable(boolean expirable) {
        isExpirable = expirable;
    }
}
