/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jitendra
 */
public final class Product {

//    public Product(Map<String, Integer>  map) {
//    setProduct(map);
//    }
    
    void setProduct(Map<String, Integer>  map){
        map.put("T-Shirt",150);
	map.put("Shoe",180);
	map.put("Shirt",1150);
	map.put("Mobile",4500);
	map.put("Glasses",520);
    }
    Map<String, Integer>  map = new HashMap<>();
    public HashMap<String, Integer> getPeopleMap() {
         return (HashMap<String, Integer>) map;
    }
    
//    public static void main(String[] args) {
//        
//        Product product = new Product(map);
//    }
    
}
