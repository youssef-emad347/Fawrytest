package Cart;

import model.Product;

public class CartItem {
    private Product item;
    private int quantity;

    CartItem(Product item,int quantity){
        this.item = item;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public boolean equals(Product p) {
        return this.item.getName().equals(p.getName());
    }

}
