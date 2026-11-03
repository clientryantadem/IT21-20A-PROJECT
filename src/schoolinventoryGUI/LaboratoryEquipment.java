
package schoolinventoryGUI;

/**
 * Child class for science and laboratory tools.
 */
public class LaboratoryEquipment extends Equipment {

    private String laboratoryName;

    public LaboratoryEquipment(String equipmentID, String equipmentName, String category,
                               String availability, String laboratoryName) {
        super(equipmentID, equipmentName, category, availability);
        this.laboratoryName = laboratoryName;
    }
    public String getLaboratoryName() {
        return laboratoryName;
    }
    public void setLaboratoryName(String laboratoryName) {
        this.laboratoryName = laboratoryName;
    }
     @Override
    public String getType() {
        return "Laboratory Equipment";
    }
    @Override
    public String displayInfo() {
        return super.displayInfo() + "\nLaboratory: " + laboratoryName;
}
}
