// first frame the welcoming frame

import javax.swing.*;  // importing a library that include the JFrame, JPanel, JLabel
import java.awt.*; // importing a library that include Font and GridLayout to be used in the styling of this Frame
import java.awt.event.ActionEvent; // importing a library that has ActionEvent and getActionCommand used to capture the Action of a button
import java.awt.event.ActionListener; // importing a library that include ActionListener

public class Frame1 implements ActionListener{ // class Frame1 that implements ActionListener which is used to handle
    // all action Events such as when a user click on a button.
    public static void main(String[] args) { // main method
        JFrame frame1 = new JFrame(); // an object of class frame which displays the GUI window
        JPanel panel = new JPanel(); // the first panel in the GUI window
        JPanel panel1 = new JPanel(); // the second panel in the GUI window
        JPanel panel2 = new JPanel(); // the third panel in the GUI window
        JPanel panel3 = new JPanel(); // the fourth panel in the GUI window
        JButton button = new JButton();// declaration of the object button of class JButton

        JLabel label1 = new JLabel("WELCOME"); // the label Welcome
        JLabel label2 = new JLabel("TO BANK");  // the label enter card
        JLabel label3 = new JLabel("OF DUBAI");  // the label enter card

        label1.setFont(new Font("Sans-serif",Font.BOLD,35)); // setting the font type , font weight and the font size
        label2.setFont(new Font("Sans-serif",Font.BOLD,35)); // setting the font type , font weight and the font size
        label3.setFont(new Font("Sans-serif",Font.BOLD,35)); // setting the font type , font weight and the font size


        button.setText("CONTINUE"); //  setting the text in the button as continue
        button.addActionListener(new Frame1()); // calling this class that implements ActionListener and method actionPerformed for the  functionality of the button

        panel.add(label1); // placing the label1 in the panel
        panel1.add(label2); //  placing the label2 in the panel1
        panel2.add(label3); //  placing the label3 in the panel2
        panel3.add(button); //  placing the button in the panel3


        frame1.setLayout(new GridLayout(4,0)); // arranging the 4 panels in the frame using GridLayout
        frame1.add(panel); //  placing the panel in the frame
        frame1.add(panel1); //  placing the panel1 in the frame
        frame1.add(panel2); //  placing the panel2 in the frame
        frame1.add(panel3); //  placing the panel3 in the frame
        frame1.setTitle("BD"); // setting the title of the frame
        frame1.setSize(420,420); // setting the height and width of the frame
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // this allows the frame to close when the exist button is press
        frame1.setVisible(true); // making the frame visible

    } // end of main class
    public void actionPerformed(ActionEvent e){ // the method that is in charge of the button events(button clicks)
        if(e.getActionCommand().equals("CONTINUE")) { // checking if the button clicked was the continue button
            Frame2 frame2 = new Frame2(); // creating an object frame2 of class Frame2 which will display another window
        } // end of if statement
    } // end of actionPerformed method
} // end of class frame1



