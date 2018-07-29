package zoo_management_system.Zone;

import java.util.ArrayList;
import java.util.List;
import zoo_management_system._CageEnum_;

public class Zone {
    int CapacityZone=5;
    List<String> cage=new ArrayList<>();

    void getInfo(){
        
    }
    
    void addCage(){
        
    }
    
    int SpareCapacity(){
//        return CapacityZone-List.size();
    return -1;
    }
    
    int totalCapacity(){
        return CapacityZone;
    }
    
    boolean hasCanteen(){
        return false;
    }
    
    boolean hasPark(){
        return true;
    }
       
}