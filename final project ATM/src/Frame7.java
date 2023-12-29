//frame7 displaying your balance

import javax.swing.*; // importing a library that include the JFrame, JPanel, JLabel
import java.awt.*; // importing a library that include Font and GridLayout to be used in the styling of this Frame

public class Frame7 extends JFrame { // The class Frame5 that inherits from the superclass JFrame
    public static JLabel label1; // declaring variable label1, the variable is made public and static so as it can be used in the other classes as well
    Frame7(){
        JPanel panel = new JPanel(); // creating panel in the GUI window
        JPanel panel1 = new JPanel(); // creating panel1 in the GUI window
        JLabel label = new JLabel("Your Balance is"); // creating a label and setting the text to "Your Balance is"
        label1 = new JLabel(" "); // creating a label1 and setting it's text to blank , it's where your balance will be written

        label.setFont(new Font("Sans-serif",Font.BOLD,20)); // setting the font type , font weight and the font size

        panel.add(label); // add  label to  panel
        panel1.add(label1); // add label1 to  panel1


        this.add(panel); // add panel to the frame
        this.add(panel1); // add panel1 to the frame
        this.setLayout(new GridLayout(3,0)); // set the layout of the three panel in frame7, Grid the panel 3 rows and 0 column
        this.setSize(420,220); //  set the size of frame6 to width 420 and height 420
        this.setTitle("BK"); // set the title of the frame to "BK"
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // this allows the frame to close when the exist button is press
        this.setVisible(true); // making the frame visible
    }
} // end of the class Frame7

