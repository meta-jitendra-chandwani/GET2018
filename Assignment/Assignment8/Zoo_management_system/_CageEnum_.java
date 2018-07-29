package zoo_management_system;

public enum _CageEnum_ {
   CageMammal("Mammal");
   CageBird("Bird");
    String type;
    private _CageEnum_(String type) {
        this.type = type;
    }
    
    
}
