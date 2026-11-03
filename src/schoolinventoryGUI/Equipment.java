package schoolinventoryGUI;

/**
 * Parent class for all school equipment.
 * Demonstrates encapsulation with private attributes and public getters/setters.
 */
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

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    /**
     * Updates the availability of this equipment object.
     */
    public void updateAvailability(String newAvailability) {
        this.availability = newAvailability;
    }

    /**
     * Child classes override this so the Type column can identify the subclass.
     */
    public String getType() {
        return "General";
    }

    /**
     * Returns a readable summary of this equipment.
     * Child classes override this to include extra attributes.
     */
    public String displayInfo() {
        return "Equipment ID: " + equipmentID
                + "\nEquipment Name: " + equipmentName
                + "\nCategory: " + category
                + "\nAvailability: " + availability
                + "\nType: " + getType();
    }
}
