package zoo_management_system.Zoo;

import java.util.List;
import zoo_management_system.Animal.Animal;
import zoo_management_system.Animal.Lion;
import zoo_management_system.Cage.Cage;
import zoo_management_system.Zone.Zone;

public class Zoo {
    Animal animal;
    static List<Lion> animalList;
    
    
//List of zone jo enum se aaegi
   void addAnimal(){
        
    }
   
   void removeAnimal(){
       
   }
   
   boolean moveZone(String animal,int currentZone,int movedZone){
       //check compatibilty
       //availabilty of space
       return true;
   }
   
   boolean moveCage(String animal,int currentCage,int movedCage){
       return true;
   }
   
    
}
