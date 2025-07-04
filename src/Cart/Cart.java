package Cart;

import model.ExpirableProduct;
import model.Product;
import model.Shippable;
import model.ShippableProduct;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItemList = new ArrayList<>();

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public void add(Product p, int q) {
        if (p.getQuantity() < q) {
            System.out.println("Sorry,there is no enough stock");
        }
        for (CartItem i : cartItemList) {
            if (i.equals(p)) {
                i.setQuantity(i.getQuantity() + q);
                return;
            }

        }
        cartItemList.add(new CartItem(p, q));
    }

    public void remove(Product p) {
        for (CartItem i : cartItemList) {
            if (i.equals(p)) {
                cartItemList.remove(i);
            } else System.out.println("Product is not in cart");
        }
    }

    public boolean isEmpty() {
        return cartItemList.isEmpty();
    }

    public float subtotal() {
        float subtotal = 0;
        for (CartItem i : cartItemList) {
            subtotal += (i.getQuantity() * i.getItem().getPrice());
        }
        return subtotal;
    }

    public List<ShippableProduct> getShippableItems() {
        List<ShippableProduct> items = new ArrayList<ShippableProduct>();
        for (CartItem i : cartItemList) {
            if (i.getItem() instanceof ShippableProduct) {
                items.add((ShippableProduct) i.getItem());
            }
        }
        return items;
    }

    public List<ExpirableProduct> getExpirableItems() {
        List<ExpirableProduct> items = new ArrayList<ExpirableProduct>();
        for (CartItem i : cartItemList) {
            if (i.getItem() instanceof ExpirableProduct) {
                items.add((ExpirableProduct) i.getItem());
            }
        }
        return items;
    }
}
