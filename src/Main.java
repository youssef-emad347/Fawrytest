import Cart.Cart;
import Cart.CartItem;
import Services.ShippingService;
import model.ExpirableProduct;
import model.ExpirableShippableProduct;
import model.Product;
import model.ShippableProduct;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product cheese = new ExpirableShippableProduct(
                "Cheese", 100, 10, "2025-07-01", 200
        );

        Product biscuits = new ExpirableShippableProduct(
                "Biscuits", 150, 5, "2026-01-01", 700
        );

        Product tv = new ShippableProduct(
                "TV", 5000, 3, 3000
        );

        Product scratchCard = new Product("Scratch Card", 50, 20);

        Customer customer = new Customer("Youssef", 5000);

        Cart cart = new Cart();
        cart.add(cheese, 2);        // 2 × 100 = 200
        cart.add(biscuits, 1);      // 1 × 150 = 150
        cart.add(scratchCard, 1);   // 1 × 50 = 50

        checkout(customer,cart);

    }
    public static void checkout(Customer m , Cart c){
        isExpire(c.getExpirableItems());
        double totalWeight = ShippingService.ship(c.getShippableItems());
        float shippingFees = (float) (totalWeight * 0.05); //fees is 0.3$ for gram
        float subtotal = c.subtotal();
        float total = shippingFees + subtotal;

        if(!m.checkBalance(total)){
            System.out.println("Insufficient balance");
            return;
        }

        System.out.println("** Checkout receipt **");
        for(CartItem i: c.getCartItemList()){
            float price = i.getQuantity() * i.getItem().getPrice();
            System.out.printf("%dx %s     %.1f$ \n",i.getQuantity(),i.getItem().getName(),price);
        }
        System.out.println("------------------------");
        System.out.println("Subtotal      "+subtotal);
        System.out.println("Shipping      "+shippingFees);
        System.out.println("Amount        "+total);

    }
    public static <T extends ExpirableShippableProduct> void isExpire(List<T> list){
        for(T i:list){
            if(i.getExpiryDate().isBefore(LocalDate.now())){
                System.out.println(i.getName() + " is expired");
                return;
            }
        }
    }
}


