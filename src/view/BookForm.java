package view;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BookForm extends JFrame {

    private static final long serialVersionUID = 1L;

    // Form fields accessible by controller
    public JTextField txtId;
    public JTextField txtName;
    public JTextField txtEdition;
    public JTextField txtPrice;

    public JButton btnAdd;
    public JButton btnClear;
    public JButton btnExit;
    public JButton btnUpdate;
    public JButton btnDelete;

    public JTable table;
    public DefaultTableModel tableModel;

    public BookForm() {
        setTitle("Book Shop - MVC");
        setBounds(100, 100, 750, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Book Shop");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(270, 10, 200, 40);
        getContentPane().add(lblTitle);

        // Registration Panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(27, 78, 321, 241);
        getContentPane().add(panel);

        JLabel lblName = new JLabel("Book Name");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(20, 35, 98, 28);
        panel.add(lblName);

        JLabel lblEdition = new JLabel("Edition");
        lblEdition.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblEdition.setBounds(20, 73, 98, 28);
        panel.add(lblEdition);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPrice.setBounds(20, 111, 98, 28);
        panel.add(lblPrice);

        txtName = new JTextField();
        txtName.setBounds(121, 35, 177, 28);
        panel.add(txtName);

        txtEdition = new JTextField();
        txtEdition.setBounds(121, 73, 177, 28);
        panel.add(txtEdition);

        txtPrice = new JTextField();
        txtPrice.setBounds(121, 111, 177, 28);
        panel.add(txtPrice);

        btnAdd = new JButton("Save");
        btnAdd.setBounds(10, 162, 84, 45);
        panel.add(btnAdd);

        btnClear = new JButton("Clear");
        btnClear.setBounds(111, 162, 84, 45);
        panel.add(btnClear);

        btnExit = new JButton("Exit");
        btnExit.setBounds(214, 162, 84, 45);
        panel.add(btnExit);

        // Search Panel
        JPanel panelSearch = new JPanel();
        panelSearch.setLayout(null);
        panelSearch.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelSearch.setBounds(27, 329, 321, 55);
        getContentPane().add(panelSearch);

        JLabel lblId = new JLabel("Book ID");
        lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblId.setBounds(31, 17, 70, 28);
        panelSearch.add(lblId);

        txtId = new JTextField();
        txtId.setBounds(112, 16, 177, 28);
        panelSearch.add(txtId);

        // Table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(374, 77, 310, 241);
        getContentPane().add(scrollPane);

        table = new JTable();
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"ID", "Name", "Edition", "Price"});
        table.setModel(tableModel);
        scrollPane.setViewportView(table);

        // Buttons for update and delete
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(374, 339, 132, 36);
        getContentPane().add(btnUpdate);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(546, 339, 132, 36);
        getContentPane().add(btnDelete);
    }
}
