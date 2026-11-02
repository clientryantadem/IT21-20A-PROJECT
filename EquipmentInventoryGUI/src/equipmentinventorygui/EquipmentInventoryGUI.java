
package equipmentinventorygui;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


public class EquipmentInventoryGUI  extends JFrame {{

  
    private final EquipmentList equipmentList;

    private JTextField txtSearchID;
    private JButton btnSearch;
    private JButton btnRegister;
    private JButton btnDisplay;
    private JButton btnUpdate;
    private DefaultTableModel tableModel;
    private JTable tblRecords;

    private static final Color NAVY = new Color(25, 55, 109);
    private static final Color BUTTON_BLUE = new Color(37, 99, 175);
    private static final Color LIGHT_BLUE = new Color(236, 244, 252);
    private static final Color WHITE = Color.WHITE;

    private static final String[] AVAILABILITY_OPTIONS = {
        "Available", "Borrowed", "Under Maintenance"
    };
    public static void main(String[] args) {
    
    }
    
}
