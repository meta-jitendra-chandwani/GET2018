import java.util.HashMap;
import java.util.Map;


public final class Product {

    void setProduct(Map < String, Integer > map) {
        map.put("T-Shirt", 150);
        map.put("Shoe", 180);
        map.put("Shirt", 1150);
        map.put("Mobile", 4500);
        map.put("Glasses", 520);
    }
    Map < String, Integer > map = new HashMap < > ();
    public HashMap < String, Integer > getPeopleMap() {
        return (HashMap < String, Integer > ) map;
    }
}