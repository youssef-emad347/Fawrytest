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

    public <T> List<T> getShippableItems() {
        List<T> items = new ArrayList<T>();
        for (CartItem i : cartItemList) {
            if (i.getItem().isShippable()) {
                items.add((T) i.getItem());
            }
        }
        return items;
    }

    public <T> List<T> getExpirableItems() {
        List<T> items = new ArrayList<T>();
        for (CartItem i : cartItemList) {
            if (i.getItem().isExpirable()) {
                items.add((T) i.getItem());
            }
        }
        return items;
    }
}
