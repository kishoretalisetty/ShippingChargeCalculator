package org.example.ControllerLayer;

import org.example.Dtos.UserDetails;
import org.example.ServiceLayer.ShippingChargesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private ShippingChargesService shippingChargesService;

    @GetMapping("/GET/shipping-charge/")

    /*
     private String name;
    private String productName;
    private String deliveryType;
    private double weight;

    private double latitude;
    private  double longitude;
     */
    public String getShippingCharge(

                                    @RequestParam(name = "name") String name,
                                    @RequestParam(name = "productName") String productName,
                                    @RequestParam(name = "deliveryType") String deliveryType,
                                    @RequestParam(name = "weight") double weight,
                                    @RequestParam(name = "latitude") double latitude,
                                    @RequestParam(name = "longitude") double longitude
                                    ) {
//        System.out.println(userDetails);
        UserDetails userDetails=new UserDetails(name,productName,deliveryType,weight, latitude,longitude);
        return "ShippingCharge: "+ shippingChargesService.calculateShippingCharge(userDetails);
    }
}
