import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterGUI extends JFrame implements ActionListener {
    private JComboBox<String> unitSelection;
    private JTextField inputField;
    private JButton convertButton;
    private JLabel resultLabel;

    public TemperatureConverterGUI() {
        setTitle("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        // Create components
        unitSelection = new JComboBox<>(new String[]{"Celsius to Fahrenheit", "Fahrenheit to Celsius"});
        inputField = new JTextField(10);
        convertButton = new JButton("Convert");
        resultLabel = new JLabel("");

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10)); // Improved layout
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Added padding
        panel.setBackground(Color.LIGHT_GRAY); // Background color

        // Design improvements for components
        unitSelection.setFont(new Font("Arial", Font.PLAIN, 14));
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        convertButton.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        resultLabel.setForeground(Color.BLUE);

        // Add components to the panel
        panel.add(unitSelection);
        panel.add(inputField);
        panel.add(convertButton);
        panel.add(resultLabel);

        // Add an action listener to the convert button
        convertButton.addActionListener(this);

        // Add the panel to the frame
        add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            try {
                double inputValue = Double.parseDouble(inputField.getText());
                int selectedIndex = unitSelection.getSelectedIndex();
                double result;

                if (selectedIndex == 0) {
                    result = (inputValue * 9 / 5) + 32;
                    resultLabel.setText("Result: " + result + " °F");
                } else {
                    result = (inputValue - 32) * 5 / 9;
                    resultLabel.setText("Result: " + result + " °C");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input. Please enter a number.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TemperatureConverterGUI();
        });
    }
}
