package Services;

import model.ExpirableShippableProduct;
import model.Product;
import model.ShippableProduct;

import java.util.List;

public class ShippingService {
    public static <T extends ExpirableShippableProduct> double ship(List<T> list){
        if(list.isEmpty()) {
            System.out.println("there is no shippable items");
            return 0 ;
        }
        System.out.println("** Shipment notice **");
        double totalWeight = 0;

        for(T p: list){
            double weight = p.getQuantity() * p.getWeight();
            System.out.printf("%dx %s     %.1fg \n",p.getQuantity(),p.getName(),weight);
            totalWeight += weight;
        }
        if(totalWeight >= 1000) {
            double totalWeight1 = totalWeight/1000;
            System.out.println("Total package weight " + totalWeight1+"kg");
        }
        else System.out.println("Total package weight" + totalWeight+"g");
        return totalWeight;
    }
}
