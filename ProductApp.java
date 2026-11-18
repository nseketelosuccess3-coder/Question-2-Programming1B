package productapp;

import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 * GUI for capturing a mattress sale and processing it (Q.2.1 - Q.2.4).
 */
public class ProductApp extends JFrame {

    private static final String[] PRODUCTS = {
        "Cozy Nights Monarch",
        "Restonic Barbados",
        "Sealy Phuket"
    };

    private final JTextField txtCustomerName = new JTextField();
    private final JComboBox<String> cmbProduct = new JComboBox<>(PRODUCTS);
    private final JTextField txtPrice = new JTextField();
    private final JButton btnProcess = new JButton("PROCESS");

    public ProductApp() {
        super("Product App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(createMenuBar());
        add(createFormPanel());
        pack();
        setSize(450, 250);
        setLocationRelativeTo(null);
    }

    /** Form with the text boxes, combo box and Process button (Q.2.2). */
    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 15));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Customer Name:"));
        panel.add(txtCustomerName);
        panel.add(new JLabel("Select Product:"));
        panel.add(cmbProduct);
        panel.add(new JLabel("Enter Price:"));
        panel.add(txtPrice);
        panel.add(new JLabel());
        panel.add(btnProcess);

        btnProcess.addActionListener(e -> processSale());
        return panel;
    }

    /** File > Exit, Tools > Process / Clear (Q.2.4). */
    private JMenuBar createMenuBar() {
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));

        JMenuItem processItem = new JMenuItem("Process");
        processItem.addActionListener(e -> processSale()); // same logic as the button

        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(e -> clearForm());

        JMenu fileMenu = new JMenu("File");
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        return menuBar;
    }

    /** Captures the input, calculates, shows the message box and saves to data.txt (Q.2.3). */
    private void processSale() {
        String customerName = txtCustomerName.getText().trim();
        if (customerName.isEmpty()) {
            showError("Please enter the customer name.");
            return;
        }

        double price;
        try {
            price = Double.parseDouble(txtPrice.getText().trim());
        } catch (NumberFormatException ex) {
            showError("Please enter a valid price (numbers only).");
            return;
        }
        if (price <= 0) {
            showError("The price must be greater than zero.");
            return;
        }

        SaleDetails sale = new SaleDetails(
                customerName,
                (String) cmbProduct.getSelectedItem(),
                new ProductCalculations(price));

        JOptionPane.showMessageDialog(this, sale.toMessage());

        try {
            sale.saveToFile();
        } catch (IOException ex) {
            showError("Could not save to data.txt: " + ex.getMessage());
        }
    }

    /** Clears the text boxes and resets the combo box to the first item. */
    private void clearForm() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}
public class ProductApp {
    
}
