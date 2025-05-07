// Importing package for GUI
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

// RecruitmentSystem class represents the GUI for hiring staff
public class RecruitmentSystem extends JFrame implements ActionListener {
    // List to store hired staff members
    private final ArrayList<StaffHire> staffList = new ArrayList<>();

    // Defining all input fields used in the form
    private final JTextField txtVacancyNumber = new JTextField(15);
    private final JTextField txtDesignation = new JTextField(15);
    private final JTextField txtJobType = new JTextField(15);
    private final JTextField txtStaffName = new JTextField(15);
    private final JTextField txtJoiningDate = new JTextField(15);
    private final JTextField txtQualification = new JTextField(15);
    private final JTextField txtAppointedBy = new JTextField(15);
    private final JTextField txtJoined = new JTextField(15);
    private final JTextField txtSalary = new JTextField(15);
    private final JTextField txtWeeklyHours = new JTextField(15);
    private final JTextField txtWorkingHours = new JTextField(15);
    private final JTextField txtWagesPerHour = new JTextField(15);
    private final JTextField txtShifts = new JTextField(15);
    private final JTextField txtTerminateNumber = new JTextField(15);
    private final JTextField txtDisplayNumber = new JTextField(15);

    // Defining all buttons used in the GUI
    private final JButton btnAddFullTime = new JButton("Add Full Time Staff");
    private final JButton btnAddPartTime = new JButton("Add Part Time Staff");
    private final JButton btnSetSalary = new JButton("Set Salary");
    private final JButton btnSetShift = new JButton("Set Shift");
    private final JButton btnTerminate = new JButton("Terminate Staff");
    private final JButton btnDisplay = new JButton("Display Staff");
    private final JButton btnClear = new JButton("Clear");

    // Constructor initializes the GUI window
    public RecruitmentSystem() {
        setTitle("London Metropolitan University Hiring System");
        setSize(950, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on screen

        // Theme and style definitions
        Color uniPurple = new Color(102, 0, 153);
        Font headerFont = new Font("Segoe UI", Font.BOLD, 24);

        // Main layout panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // Header panel with university title and logo
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(uniPurple);
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));

        try {
            // Attempt to load and display the logo
            ImageIcon icon = new ImageIcon("londonmet_logo.png");
            Image scaled = icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            JLabel logoLabel = new JLabel(new ImageIcon(scaled));
            titlePanel.add(logoLabel);
            titlePanel.add(Box.createRigidArea(new Dimension(15, 0)));
        } catch (Exception e) {
            System.out.println("Logo not found.");
        }

        JLabel titleLabel = new JLabel("London Metropolitan University Hiring System");
        titleLabel.setFont(headerFont);
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        titlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        headerPanel.add(titlePanel);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Form panel with labels and input fields
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 10, 6, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Adding fields to the form panel
        addField(formPanel, gbc, "Vacancy Number:", txtVacancyNumber);
        addField(formPanel, gbc, "Designation:", txtDesignation);
        addField(formPanel, gbc, "Job Type:", txtJobType);
        addField(formPanel, gbc, "Staff Name:", txtStaffName);
        addField(formPanel, gbc, "Joining Date:", txtJoiningDate);
        addField(formPanel, gbc, "Qualification:", txtQualification);
        addField(formPanel, gbc, "Appointed By:", txtAppointedBy);
        addField(formPanel, gbc, "Joined (true/false):", txtJoined);
        addField(formPanel, gbc, "Salary:", txtSalary);
        addField(formPanel, gbc, "Weekly Hours:", txtWeeklyHours);
        addField(formPanel, gbc, "Working Hours:", txtWorkingHours);
        addField(formPanel, gbc, "Wages Per Hour:", txtWagesPerHour);
        addField(formPanel, gbc, "Shifts:", txtShifts);
        addField(formPanel, gbc, "Terminate Number:", txtTerminateNumber);
        addField(formPanel, gbc, "Display Number:", txtDisplayNumber);

        // Panel to hold all action buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        buttonPanel.setBackground(new Color(245, 245, 255));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Actions"));

        // Styling and adding buttons to the panel
        JButton[] buttons = {
            btnAddFullTime, btnAddPartTime, btnSetSalary,
            btnSetShift, btnTerminate, btnDisplay, btnClear
        };

        for (JButton btn : buttons) {
            btn.setBackground(new Color(240, 240, 240));
            btn.setForeground(Color.BLACK);
            btn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
            btn.addActionListener(this); // Register button with action listener
            buttonPanel.add(btn);
        }

        // Add button panel below form fields
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy++;
        formPanel.add(buttonPanel, gbc);

        // Scroll pane to allow scrolling of long forms
        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Add everything to the frame
        add(mainPanel);
        setVisible(true);
    }

    // Helper method to add label + text field pair into the form layout
    private void addField(JPanel panel, GridBagConstraints gbc, String label, JTextField field) {
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        panel.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        panel.add(field, gbc);
        gbc.gridy++;
    }

    // Handles all button click events
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Add Full Time Staff":
                JOptionPane.showMessageDialog(this, "Functionality to add full-time staff here.");
                break;
            case "Add Part Time Staff":
                JOptionPane.showMessageDialog(this, "Functionality to add part-time staff here.");
                break;
            case "Set Salary":
                JOptionPane.showMessageDialog(this, "Functionality to set salary here.");
                break;
            case "Set Shift":
                JOptionPane.showMessageDialog(this, "Functionality to set shift here.");
                break;
            case "Terminate Staff":
                JOptionPane.showMessageDialog(this, "Functionality to terminate staff here.");
                break;
            case "Display Staff":
                JOptionPane.showMessageDialog(this, "Functionality to display staff here.");
                break;
            case "Clear":
                clearFields(); // Clear all text fields
                break;
        }
    }

    // Clears all input fields on the form
    private void clearFields() {
        JTextField[] fields = {
            txtVacancyNumber, txtDesignation, txtJobType, txtStaffName, txtJoiningDate,
            txtQualification, txtAppointedBy, txtJoined, txtSalary, txtWeeklyHours,
            txtWorkingHours, txtWagesPerHour, txtShifts, txtTerminateNumber, txtDisplayNumber
        };
        for (JTextField field : fields) {
            field.setText(""); // Clear each field
        }
    }

    // Main method to launch the GUI application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(RecruitmentSystem::new);
    }
}

