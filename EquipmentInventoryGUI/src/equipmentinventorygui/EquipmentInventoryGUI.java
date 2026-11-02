
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
    
    public EquipmentInventoryGUI() {
        equipmentList = new EquipmentList();
        initWindow();
        initComponents();
    }

    private void initWindow() {
        setTitle("School Equipment Inventory");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 470);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(LIGHT_BLUE);
        setLayout(null);
    }

    private void initComponents() {
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(NAVY);
        headerPanel.setBounds(0, 0, 640, 50);
        headerPanel.setLayout(null);

        JLabel lblTitle = new JLabel("School Equipment Inventory");
        lblTitle.setForeground(WHITE);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(0, 0, 640, 50);
        headerPanel.add(lblTitle);
        add(headerPanel);

        JLabel lblSearch = new JLabel("Search Equipment ID");
        lblSearch.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblSearch.setBounds(20, 65, 140, 25);
        add(lblSearch);

        txtSearchID = new JTextField();
        txtSearchID.setBounds(165, 65, 320, 25);
        add(txtSearchID);

        btnSearch = createButton("Search");
        btnSearch.setBounds(495, 63, 115, 28);
        btnSearch.addActionListener(e -> searchEquipment());
        add(btnSearch);

        String[] columns = {
            "Equipment ID", "Equipment Name", "Category", "Availability", "Type"
        };
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

    public static void main(String[] args) {
    
    }
    
}
