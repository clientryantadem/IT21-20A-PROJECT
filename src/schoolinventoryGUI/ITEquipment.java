
package schoolinventoryGUI;

public class ITEquipment extends Equipment {

    private String brand;

    public ITEquipment(String equipmentID, String equipmentName, String category,
                       String availability, String brand) {
        super(equipmentID, equipmentName, category, availability);
        this.brand = brand;
    }
    public String getBrand() {
        return brand;
    }
     public void setBrand(String brand) {
        this.brand = brand;
    }
 @Override
    public String getType() {
        return "IT Equipment";
    }
     @Override
    public String displayInfo() {
        return super.displayInfo() + "\nBrand: " + brand;
    }
    
}
