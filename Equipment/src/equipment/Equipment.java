
package equipment;


public class Equipment {
    private String equipmentID;
    private String equipmentName;
    private String category;
    private String availability;

    public Equipment(String equipmentID, String equipmentName, String category, String availability) {
        this.equipmentID = equipmentID;
        this.equipmentName = equipmentName;
        this.category = category;
        this.availability = availability;
    }
public String getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(String equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getEquipmentName() {
        return equipmentName;
    }
     public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    
    public static void main(String[] args) {
       
    }
    
}
