// display your account details

import javax.swing.*; // importing a library that include the JFrame, JPanel, JLabel
import java.awt.*; // importing a library that include Font and GridLayout to be used in the styling of this Frame

public class Frame8 extends JFrame{ // The class Frame5 that inherits from the superclass JFrame
    // declaring from label1 to label9, making the variables public static to be used in other frames
    public static JLabel label1;
    public static JLabel label2;
    public static JLabel label3;
    public static JLabel label4;
    public static JLabel label5;
    public static JLabel label6;
    public static JLabel label7;
    public static JLabel label8;
    public static JLabel label9;

    Frame8(){
        JPanel panel = new JPanel(); // creating panel in the GUI window
        JPanel panel1 = new JPanel(); // creating panel1 in the GUI window
        JPanel panel2 = new JPanel(); // creating panel2 in the GUI window
        JLabel label = new JLabel("ACCOUNT DETAILS"); // creating the label and setting the text to "Account Details"

        // creating empty labels where customer details will be added after being retrieved from the database
        label1 = new JLabel(" ");
        label2 = new JLabel(" ");
        label3 = new JLabel(" ");
        label4 = new JLabel(" ");
        label5 = new JLabel(" ");
        label6 = new JLabel(" ");
        label7 = new JLabel(" ");
        label8 = new JLabel(" ");
        label9 = new JLabel(" ");
        JButton button = new JButton(); // creating a button

        button.setText("ENTER"); // set the text of the button to "ENTER"

        panel.add(label); // add label to the panel
        panel1.add(label1); //add label to the panel1
        panel1.add(label2); //add label to the panel2
        panel1.add(label3); //add label to the panel3
        panel1.add(label4); //add label to the panel4
        panel1.add(label5); //add label to the panel5
        panel1.add(label6); //add label to the panel6
        panel1.add(label7); //add label to the panel7
        panel1.add(label8); //add label to the panel8
        panel1.add(label9); //add label to the panel9
        panel2.add(button); //add label to the button

        this.add(panel); // add panel to the frame
        this.add(panel1); // add panel1 to the frame
        this.add(panel2); // add panel2 to the frame
        this.setLayout(new GridLayout(3,0)); // set the layout of the three panel in frame8, Grid the panel 3 rows and 0 column
        this.setSize(420,420); // set the size of frame8 to width 420 and height 420
        this.setTitle("BK"); // set the title of the frame to "BK"
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // this allows the frame to close when the exist button is press
        this.setVisible(true); //  making the frame visible
    }
} // end of class Frame8

