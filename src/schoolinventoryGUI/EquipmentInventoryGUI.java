
package schoolinventoryGUI;
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
        
        
        tblRecords = new JTable(tableModel);
        tblRecords.setRowHeight(24);
        tblRecords.getTableHeader().setBackground(NAVY);
        tblRecords.getTableHeader().setForeground(WHITE);
        tblRecords.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tblRecords.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tblRecords.setSelectionBackground(new Color(147, 197, 253));

        JScrollPane scrollPane = new JScrollPane(tblRecords);
        scrollPane.setBounds(20, 105, 590, 250);
        scrollPane.setBorder(BorderFactory.createLineBorder(NAVY));
        add(scrollPane);

        btnRegister = createButton("Register Equipment");
        btnRegister.setBounds(20, 375, 180, 32);
        btnRegister.addActionListener(e -> registerEquipment());
        add(btnRegister);

        btnDisplay = createButton("Display Records");
        btnDisplay.setBounds(220, 375, 180, 32);
        btnDisplay.addActionListener(e -> displayRecords(true));
        add(btnDisplay);

        btnUpdate = createButton("Update Availability");
        btnUpdate.setBounds(420, 375, 190, 32);
        btnUpdate.addActionListener(e -> updateAvailability());
        add(btnUpdate);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(BUTTON_BLUE);
        button.setForeground(WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
        return button;
    }

    private void registerEquipment() {
        JTextField txtID = new JTextField();
        JTextField txtName = new JTextField();
        JTextField txtCategory = new JTextField();
        JTextField txtExtra = new JTextField();

        JRadioButton rdoIT = new JRadioButton("IT Equipment", true);
        JRadioButton rdoLab = new JRadioButton("Laboratory Equipment");
        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(rdoIT);
        typeGroup.add(rdoLab);

        JRadioButton rdoAvailable = new JRadioButton("Available", true);
        JRadioButton rdoBorrowed = new JRadioButton("Borrowed");
        JRadioButton rdoMaintenance = new JRadioButton("Under Maintenance");
        ButtonGroup availabilityGroup = new ButtonGroup();
        availabilityGroup.add(rdoAvailable);
        availabilityGroup.add(rdoBorrowed);
        availabilityGroup.add(rdoMaintenance);

        JLabel lblExtra = new JLabel("Brand:");
        rdoIT.addActionListener(e -> lblExtra.setText("Brand:"));
        rdoLab.addActionListener(e -> lblExtra.setText("Laboratory Name:"));

        JPanel form = new JPanel(new GridLayout(0, 2, 8, 8));
        form.add(new JLabel("Equipment ID:"));
        form.add(txtID);
        form.add(new JLabel("Equipment Name:"));
        form.add(txtName);
        form.add(new JLabel("Category:"));
        form.add(txtCategory);
        form.add(new JLabel("Type:"));
        form.add(rdoIT);
        form.add(new JLabel(""));
        form.add(rdoLab);
        form.add(new JLabel("Availability:"));
        form.add(rdoAvailable);
        form.add(new JLabel(""));
        form.add(rdoBorrowed);
        form.add(new JLabel(""));
        form.add(rdoMaintenance);
        form.add(lblExtra);
        form.add(txtExtra);
        
        
        int result = JOptionPane.showConfirmDialog(
                this,
                form,
                "Register Equipment",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result != JOptionPane.OK_OPTION) {
            return;
        }

        String id = txtID.getText().trim();
        String name = txtName.getText().trim();
        String category = txtCategory.getText().trim();
        String extra = txtExtra.getText().trim();
        String availability = selectedAvailability(rdoAvailable, rdoBorrowed, rdoMaintenance);

        if (id.isEmpty() || name.isEmpty() || category.isEmpty() || extra.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "All fields are required. Please complete the registration form.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if (equipmentList.containsID(id)) {
            JOptionPane.showMessageDialog(
                    this,
                    "Equipment ID \"" + id + "\" already exists. Duplicate IDs are not allowed.",
                    "Duplicate ID",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        Equipment newEquipment;
        if (rdoIT.isSelected()) {
            newEquipment = new ITEquipment(id, name, category, availability, extra);
        } else {
            newEquipment = new LaboratoryEquipment(id, name, category, availability, extra);
        }

        equipmentList.add(newEquipment);
        displayRecords(false);

        JOptionPane.showMessageDialog(
                this,
                "Equipment registered successfully.",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

rivate String selectedAvailability(JRadioButton available, JRadioButton borrowed, JRadioButton maintenance) {
        if (borrowed.isSelected()) {
            return "Borrowed";
        }
        if (maintenance.isSelected()) {
            return "Under Maintenance";
        }
        return "Available";
    }

    private void displayRecords(boolean showEmptyMessage) {
        tableModel.setRowCount(0);

        if (equipmentList.isEmpty()) {
            if (showEmptyMessage) {
                JOptionPane.showMessageDialog(
                        this,
                        "There are no registered equipment records.",
                        "No Records",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
            return;
        }

        Equipment[] records = equipmentList.toArray();
        for (int i = 0; i < records.length; i++) {
            Equipment item = records[i];
            Object[] row = {
                item.getEquipmentID(),
                item.getEquipmentName(),
                item.getCategory(),
                item.getAvailability(),
                item.getType()
            };
            tableModel.addRow(row);
        }
    }

    private void searchEquipment() {
        String id = txtSearchID.getText().trim();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter an Equipment ID to search.",
                    "Search",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        Equipment found = equipmentList.searchByID(id);

        if (found == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Equipment not found.",
                    "Search Result",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        JOptionPane.showMessageDialog(
                this,
                found.displayInfo(),
                "Equipment Found",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void updateAvailability() {
        String id = JOptionPane.showInputDialog(
                this,
                "Enter Equipment ID:",
                "Update Availability",
                JOptionPane.QUESTION_MESSAGE
        );

        if (id == null) {
            return;
        }

        id = id.trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Equipment ID is required.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        Equipment found = equipmentList.searchByID(id);
        if (found == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Equipment not found.",
                    "Update Availability",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        String newAvailability = (String) JOptionPane.showInputDialog(
                this,
                "Select new availability for " + found.getEquipmentName() + ":",
                "Update Availability",
                JOptionPane.QUESTION_MESSAGE,
                null,
                AVAILABILITY_OPTIONS,
                found.getAvailability()
        );
        
        if (newAvailability == null) {
            return;
        }

        found.updateAvailability(newAvailability);
        displayRecords(false);

        JOptionPane.showMessageDialog(
                this,
                "Availability updated successfully.",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}


    
    
    

