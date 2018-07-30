package Zone;

import java.util.ArrayList;
import java.util.List;

import Animal.BirdAnimal;
import Animal.MammalAnimal;
import Animal.ReptileAnimal;
import Cage.Cage;

public class Zone {
    int CapacityZone=2;
//    Cage cage=new Cage();
    List<MammalAnimal> mammalInCage;//=Cage.getMammalCageList();
    List<BirdAnimal> birdInCage;//=Cage.getBirdCageList();
    List<ReptileAnimal> reptileInCage;//e=Cage.getReptileCageList();
    public List<Cage> cageList=new ArrayList<Cage>();
    Cage cage;

    public Zone(_ZoneEnum_ zone) {
    	if(_ZoneEnum_.Zone1.equals(zone)){
    		cage=new Cage("mammal");
    		mammalInCage=Cage.getMammalInCageList();
    		cageList.add(new Cage("Mammal Cage1", "mammal", "Zone1"));
    		cageList.add(new Cage("Mammal Cage2", "mammal", "Zone1"));
    		
    	}
    	
    	else if(_ZoneEnum_.Zone2.equals(zone)){
    		cage=new Cage("bird");
    		birdInCage=Cage.getBirdInCageList();
    		cageList.add(new Cage("Bird Cage1", "Bird", "Zone3"));
    		cageList.add(new Cage("Bird Cage2", "Bird", "Zone3"));
    		
    	}
    	else if(_ZoneEnum_.Zone3.equals(zone)){
    		cage=new Cage("reptile");
    		reptileInCage=Cage.getReptileInCageList();
    		cageList.add(new Cage("Reptile Cage1", "Reptile", "Zone2"));
    		cageList.add(new Cage("Reptile Cage2", "Reptile", "Zone2"));
    		
    	}
    	
	}

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