package org.example.ServiceLayer;

import org.example.Dtos.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class ShippingChargesService {

    public double calculateShippingCharge(UserDetails userDetails){
        double BLR_Warehouse= distance(userDetails.getLatitude(),userDetails.getLongitude(),12.99999,37.923273, "K");
       double MUMB_Warehouse= distance(userDetails.getLatitude(),userDetails.getLongitude(),11.99999,27.923273, "K");
//        System.out.println(BLR_Warehouse+" "+MUMB_Warehouse);
        double shortestDistance =Math.min(BLR_Warehouse, MUMB_Warehouse);

        double  shippingCharge=0;
//        log.in

        if(shortestDistance>500){
            shippingCharge = 1*shortestDistance*userDetails.getWeight();
        }
        else if(shortestDistance > 100){
            shippingCharge =  2*shortestDistance*userDetails.getWeight();
        }
        else {
            shippingCharge =  3*shortestDistance*userDetails.getWeight();
        }
//
        if(userDetails.getDeliveryType().equals("Standard")){
            shippingCharge+=10;
        }
        else if (userDetails.getDeliveryType().equals("Express")) {
            shippingCharge+=11.2;
        }

        return shippingCharge;

    }



    private  double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }
        else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (unit.equals("K")) {
                dist = dist * 1.609344;
            } else if (unit.equals("N")) {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }
}
