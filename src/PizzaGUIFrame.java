import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class PizzaGUIFrame extends JFrame implements ActionListener {

    JFrame frame;

    JPanel mainPnl;
    JPanel crustType;
    JPanel size;
    JPanel toppings;
    JPanel order;
    JPanel bottomPnl;
    JPanel headerPnl;

    JComboBox comboBox;

    JRadioButton thinBtn;
    JRadioButton regularBtn;
    JRadioButton deepDishBtn;

    JCheckBox pepperoniChkbox;
    JCheckBox sausageChkbox;
    JCheckBox hamChkbox;
    JCheckBox pineappleChkbox;
    JCheckBox olivesChkbox;
    JCheckBox baconChkbox;

    JTextArea orderTa;

    JButton orderBtn;
    JButton clearBtn;
    JButton quitBtn;

    JOptionPane quitOpane;

    ButtonGroup group;

    public PizzaGUIFrame() {
        setSize(600, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Pizza Order Form");

        mainPnl = new JPanel();
        mainPnl.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.VERTICAL;

        createHeader();
        mainPnl.add(headerPnl, gbc);

        createCrustType();
        mainPnl.add(crustType, gbc);

        createSize();
        mainPnl.add(size, gbc);

        //createToppings();
        //mainPnl.add(toppings, gbc);

        //createOrder();
        //mainPnl.add(order, gbc);

        //createBottomPnl();
        //mainPnl.add(bottomPnl, gbc);

        add(mainPnl);
        setVisible(true);
    }

    private void createHeader() {
        headerPnl = new JPanel();
        headerPnl.setLayout(new GridLayout(1, 1));
        headerPnl.setBorder(new TitledBorder(new EtchedBorder(), "Header Panel"));

        JLabel label1 = new JLabel("DOMINO'S PIZZA");
        label1.setFont(new Font("Montserrat", Font.BOLD, 15));

        label1.setHorizontalAlignment(SwingConstants.CENTER);
        headerPnl.add(label1);
    }

    private void createCrustType() {
        crustType = new JPanel();
        crustType.setLayout(new GridBagLayout());
        crustType.setBorder(new TitledBorder(new EtchedBorder(), "Crust Type"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10,10,10,10);

        JLabel label1 = new JLabel("Choose crust type:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.NONE;
        crustType.add(label1, gbc);

        thinBtn = new JRadioButton("Thin crust");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        crustType.add(thinBtn, gbc);

        regularBtn = new JRadioButton("Regular crust");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        crustType.add(regularBtn, gbc);

        deepDishBtn = new JRadioButton("Deep dish crust");
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        crustType.add(deepDishBtn, gbc);

        group = new ButtonGroup();
        group.add(thinBtn);
        group.add(regularBtn);
        group.add(deepDishBtn);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        crustType.add(new JLabel(" "), gbc);
    }


    private void createSize()
    {
        size = new JPanel();
        size.setBorder(new TitledBorder(new EtchedBorder(), "Size"));

        String[] sizes = { "Small", "Medium", "Large", "Super" };

        DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);

        comboBox = new JComboBox(sizes);
        comboBox.setSelectedIndex(0);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        comboBox.setPrototypeDisplayValue("AaAaAaAaAaAaAaAaAa");
        comboBox.setRenderer(listRenderer);
        size.add(comboBox, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new PizzaGUIFrame();
    }
}
