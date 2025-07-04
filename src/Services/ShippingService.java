package Services;

import model.ShippableProduct;

import java.util.List;

public class ShippingService {
    public static double ship(List<ShippableProduct> list){
        if(list.isEmpty()) {
            System.out.println("there is no shippable items");
            return 0 ;
        }
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for(ShippableProduct p: list){
            double weight = p.getQuantity() * p.getWeight();
            System.out.printf("%dx %s     %fg",p.getQuantity(),p.getName(),weight);
            totalWeight += weight;
        }
        if(totalWeight >= 1000) {
            totalWeight = totalWeight/1000;
            System.out.println("Total package weight" + totalWeight +"kg");
        }
        else System.out.println("Total package weight" + totalWeight+"g");
        return totalWeight;
    }
}
