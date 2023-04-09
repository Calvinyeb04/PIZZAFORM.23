import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class PizzaGUIFrame extends JFrame implements ActionListener {

    JComboBox Combobox;
    JButton btn;

    JPanel mainPnl = new JPanel();
    JPanel btnPnl = new JPanel();
    JPanel HeaderPnl = new JPanel();
    JPanel InvoicePnl = new JPanel();
    JPanel OrderPnl = new JPanel();

    JPanel OrderSIZEPnl = new JPanel();

    JPanel  createTEST2Pnl = new JPanel();

    // Buttons
    JRadioButton submitButton = new JRadioButton("ORDER");
    JRadioButton clearButton = new JRadioButton("CLEAR");
    JRadioButton quitButton = new JRadioButton("QUIT");


    //crust//
    JRadioButton ThinButtom = new JRadioButton("Thin");
    JRadioButton RegularButtom = new JRadioButton("Regular");
    JRadioButton DeepdishButtom = new JRadioButton("Deep-Dish");





    public PizzaGUIFrame() {
        setSize(600, 700);
        setTitle("Pizza Order Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createHeaderPnl();
        createOrderPnl();
        createInvoicePnl();
        createBtnPnl();
        createTEST2Pnl();

        // Create a new JPanel to hold the InvoicePnl and OrderPnl panels
        JPanel orderInvoicePanel = new JPanel(new GridLayout(2, 1));
        orderInvoicePanel.add(OrderPnl);
        orderInvoicePanel.add(InvoicePnl);

        // Create a new JPanel to hold the orderInvoicePanel and createTEST2Pnl panels in a vertical BoxLayout
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(orderInvoicePanel);
        centerPanel.add(createTEST2Pnl);

        // Add the panels to the main panel
        mainPnl.setLayout(new BorderLayout());
        mainPnl.add(HeaderPnl, BorderLayout.NORTH);
        mainPnl.add(centerPanel, BorderLayout.CENTER);
        mainPnl.add(btnPnl, BorderLayout.SOUTH);

        // Add main panel to frame
        add(mainPnl);

        setVisible(true);
    }




    private void createHeaderPnl() {
        HeaderPnl = new JPanel();
        HeaderPnl.setLayout(new GridLayout(1, 1));
        HeaderPnl.setBorder(new TitledBorder(new EtchedBorder(), "Header Panel"));

        JLabel label1 = new JLabel("DOMINO'S PIZZA");
        label1.setFont(new Font("Montserrat", Font.BOLD, 24));
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        HeaderPnl.add(label1);
    }



    private void createBtnPnl() {
        btnPnl = new JPanel();
        btnPnl.setLayout(new GridLayout(1, 1)); // set layout to a 1x3 grid
        btnPnl.setBorder(new TitledBorder(new EtchedBorder(), "BTN Panel"));

        ButtonGroup GROUP = new ButtonGroup();
        GROUP.add(clearButton);
        GROUP.add(submitButton);
        GROUP.add(quitButton);

        btnPnl.add(clearButton); // add radio buttons to the btnPnl panel
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Reset the form
                // Clear all the text fields
                // Reset the button group
                ThinButtom.setSelected(false);
                RegularButtom.setSelected(false);
                DeepdishButtom.setSelected(false);
                submitButton.setSelected(false);
                quitButton.setSelected(false);
                Combobox.setSelectedIndex(0);
            }
        });



        btnPnl.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Submit the order
                // Get the selected pizza size
                // Get the selected toppings
                // Calculate the total cost
                // Display the invoice
            }
        });


        btnPnl.add(quitButton);
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display a confirmation dialog to confirm the user wants to quit
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Confirm quit",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                // If the user confirms, exit the application
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });



        mainPnl.add(btnPnl, BorderLayout.SOUTH); // add btnPnl to the main panel
    }

    private void createOrderPnl() {
        OrderPnl = new JPanel();
        OrderPnl.setLayout(new FlowLayout()); // change the layout to FlowLayout
        OrderPnl.setBorder(new TitledBorder(new EtchedBorder(), "CRUST Panel"));

        // Create the radio buttons and add them to the panel
        ThinButtom = new JRadioButton("Thin");
        RegularButtom = new JRadioButton("Regular");
        DeepdishButtom = new JRadioButton("Deep Dish");
        ButtonGroup GROUPCRUST = new ButtonGroup();
        GROUPCRUST.add(ThinButtom);
        GROUPCRUST.add(RegularButtom);
        GROUPCRUST.add(DeepdishButtom);
        OrderPnl.add(ThinButtom);
        OrderPnl.add(RegularButtom);
        OrderPnl.add(DeepdishButtom);

        // Create a label to display the selected option
        JLabel selectedOptionLabel = new JLabel("Crust: ");
        OrderPnl.add(selectedOptionLabel);

        // Add an action listener to update the selected option label
        ActionListener updateSelectedOption = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JRadioButton selectedButton = (JRadioButton) e.getSource();
                selectedOptionLabel.setText("Selected: " + selectedButton.getText());
            }
        };
        ThinButtom.addActionListener(updateSelectedOption);
        RegularButtom.addActionListener(updateSelectedOption);
        DeepdishButtom.addActionListener(updateSelectedOption);



    }


    private void createInvoicePnl()
    {
        InvoicePnl = new JPanel();
        InvoicePnl.setLayout(new FlowLayout()); // change the layout to FlowLayout
        InvoicePnl.setBorder(new TitledBorder(new EtchedBorder(), "SIZE Panel"));



        // Create the radio buttons and add them to the panel
        JRadioButton smallButton = new JRadioButton("Small -$8.00");
        JRadioButton mediumButton = new JRadioButton("Medium - $12.00");
        JRadioButton largeButton = new JRadioButton("Large - $16.00");
        JRadioButton SuperlargeButton = new JRadioButton("Super Large - $16.00");

        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(smallButton);
        sizeGroup.add(mediumButton);
        sizeGroup.add(largeButton);
        sizeGroup.add(SuperlargeButton);
        InvoicePnl.add(smallButton);
        InvoicePnl.add(mediumButton);
        InvoicePnl.add(largeButton);
        InvoicePnl.add(SuperlargeButton);

        // Create a label to display the selected option
        JLabel selectedOptionLabel1 = new JLabel("Size: ");
        InvoicePnl.add(selectedOptionLabel1);

        // Add an action listener to update the selected option label
        ActionListener updateSelectedOption1 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JRadioButton selectedButton = (JRadioButton) e.getSource();
                selectedOptionLabel1.setText("Selected: " + selectedButton.getText());
            }
        };
        smallButton.addActionListener(updateSelectedOption1);
        mediumButton.addActionListener(updateSelectedOption1);
        largeButton.addActionListener(updateSelectedOption1);


    }

    private void createTEST2Pnl() {
        createTEST2Pnl = new JPanel();
        createTEST2Pnl.setLayout(new FlowLayout()); // change the layout to FlowLayout
        createTEST2Pnl.setBorder(new TitledBorder(new EtchedBorder(), "INGREDIENTS Panel"));

        // Create the check boxes and add them to the panel
        JCheckBox baconChkBox = new JCheckBox("Bacon ($2.50)");
        JCheckBox mushroomChkBox = new JCheckBox("Mushroom ($1.50)");
        JCheckBox pepperoniChkBox = new JCheckBox("Pepperoni ($2.00)");
        JCheckBox pineappleChkBox = new JCheckBox("Pineapple ($1.75)");
        JCheckBox hamChkBox = new JCheckBox("Ham ($2.25)");
        JCheckBox onionChkBox = new JCheckBox("Onion ($1.25)");
        JCheckBox oliveChkBox = new JCheckBox("Olive ($1.50)");
        JCheckBox greenPepperChkBox = new JCheckBox("Green Pepper ($1.50)");
        JCheckBox tomatoChkBox = new JCheckBox("Tomato ($1.25)");
        JCheckBox chickenChkBox = new JCheckBox("Chicken ($2.75)");
        JCheckBox beefChkBox = new JCheckBox("Beef ($3.00)");

        createTEST2Pnl.add(baconChkBox);
        createTEST2Pnl.add(mushroomChkBox);
        createTEST2Pnl.add(pepperoniChkBox);
        createTEST2Pnl.add(pineappleChkBox);
        createTEST2Pnl.add(hamChkBox);
        createTEST2Pnl.add(onionChkBox);
        createTEST2Pnl.add(oliveChkBox);
        createTEST2Pnl.add(greenPepperChkBox);
        createTEST2Pnl.add(tomatoChkBox);
        createTEST2Pnl.add(chickenChkBox);
        createTEST2Pnl.add(beefChkBox);

        // Add an action listener to each check box to print out the selected items
        ActionListener printSelectedIngredients = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCheckBox selectedBox = (JCheckBox) e.getSource();
                System.out.println(selectedBox.getText() + " selected");
            }
        };

        baconChkBox.addActionListener(printSelectedIngredients);
        mushroomChkBox.addActionListener(printSelectedIngredients);
        pepperoniChkBox.addActionListener(printSelectedIngredients);
        pineappleChkBox.addActionListener(printSelectedIngredients);
        hamChkBox.addActionListener(printSelectedIngredients);
        onionChkBox.addActionListener(printSelectedIngredients);
        oliveChkBox.addActionListener(printSelectedIngredients);
        greenPepperChkBox.addActionListener(printSelectedIngredients);
        tomatoChkBox.addActionListener(printSelectedIngredients);
        chickenChkBox.addActionListener(printSelectedIngredients);
        beefChkBox.addActionListener(printSelectedIngredients);
    }











    public static void main(String[] args) {
        new PizzaGUIFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}