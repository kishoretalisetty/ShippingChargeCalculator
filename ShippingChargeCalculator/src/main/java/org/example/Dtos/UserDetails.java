package org.example.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
"name": "Andheri Mini Mart",
  "productName": "Noodles",
   "weight": 10.0,
  "deliveryType":"Standard",
  "lat": 17.232,
  "long" : 33.445495
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetails {
    private String name;
    private String productName;
    private String deliveryType;
    private double weight;
//    List<Product> listOfProducts;
    private double latitude;
    private  double longitude;

}
