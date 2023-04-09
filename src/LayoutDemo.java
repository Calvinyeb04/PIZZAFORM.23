import javax.swing.*;
import java.awt.*;
/**
 * Class to demonstrate how layout managers work
 * @author Barb Ericson ericson@cc.gatech.edu
 *
 * Note how this example inherits from JPanel as opposed to the other approach
 * which inherits from JFrame. The program creates a JFrame container and adds the
 * JPanel inherited components to it.
 */
public class LayoutDemo extends JPanel
{
    //////////////// fields //////////////////////////////////
    private JButton button1 = new JButton("One is really long");
    private JButton button2 = new JButton("Two");
    private JButton button3 = new JButton("Three");
    private JButton button4 = new JButton("Four");
    private JButton button5 = new JButton("Five");
    //////////////// constructors /////////////////////////////
    public LayoutDemo()
    {
// call init to set-up the panel
        init();
    }
///////////////////// methods //////////////////////////////
    /**
     * Method to set-up the panel
     */
    public void init()
    {
// set the layout manager for this panel
// Use one of these with the simple form of add below
// this.setLayout(new FlowLayout());
// this.setLayout(new GridLayout(3,2));
/*
// add the buttons to this panel with Flow or Grid Layout
this.add(button1);
this.add(button2);
this.add(button3);
this.add(button4);
this.add(button5);
*/
// Or comment out the above code and use this for BorderLayout
// Notice how you specify where to add the element with BorderLayout
        this.setLayout(new BorderLayout());
        this.add(button1, BorderLayout.NORTH);
        this.add(button2, BorderLayout.SOUTH);
        this.add(button3, BorderLayout.EAST);
        this.add(button4, BorderLayout.WEST);
        this.add(button5, BorderLayout.CENTER);
    }
    /**
     * Main method for testing
     */
    public static void main(String[] argv)
    {
        LayoutDemo demo = new LayoutDemo();
        JFrame frame = new JFrame("Layout Demo");
// IMPORTANT: Set the program to exit when the user closes the frame...
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(demo);
        frame.pack();
        frame.setVisible(true);
    }
}