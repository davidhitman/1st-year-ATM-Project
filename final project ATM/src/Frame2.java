// second frame, choose the action you want to perform

import javax.swing.*; // importing a library that include the JFrame, JPanel, JLabel
import java.awt.*; // importing a library that include Font and GridLayout to be used in the styling of this Frame
import java.awt.event.ActionEvent; // importing a library that has ActionEvent and getActionCommand used to capture the Action of a button
import java.awt.event.ActionListener; // importing a library that include ActionListener

public class Frame2 extends JFrame implements ActionListener{ // The class Frame2 that inherits from the superclass JFrame and implements
    // ActionListener which is used to handle all action Events such as when a user clicks on a button.
    public static boolean deposit, account, changePin,balance,withDraw; // declaring boolean variables to be used to store which button was clicked. to be used in FrameN
    Frame2(){
        Panel panel = new Panel(); // creating a  panel in the GUI window
        JButton button = new JButton(); // declaration of the object button of class JButton
        JButton button1 = new JButton(); // declaration of the object button1 of class JButton
        JButton button2 = new JButton(); // declaration of the object button2 of class JButton
        JButton button3 = new JButton(); // declaration of the object button3 of class JButton
        JButton button4 = new JButton(); // declaration of the object button4 of class JButton
        JButton button5 = new JButton(); // declaration of the object button5 of class JButton

        button.setText("CHECK ACCOUNT BALANCE"); //  setting the text in the button as CHECK ACCOUNT BALANCE
        button.addActionListener(this); // calling this class that implements ActionListener and method actionPerformed for the  functionality of this button
        button1.setText("WITHDRAW"); //  setting the text in the button as WITHDRAW
        button1.addActionListener(this); // calling this class that implements ActionListener and method actionPerformed for the  functionality of this button
        button2.setText("DEPOSIT"); // setting the text in the button as DEPOSIT
        button2.addActionListener(this); // calling this class that implements ActionListener and method actionPerformed for the  functionality of this button
        button3.setText("CREATE ACCOUNT"); // setting the text in the button as CREATE ACCOUNT
        button3.addActionListener(this); // calling this class that implements ActionListener and method actionPerformed for the  functionality of this button
        button4.setText("CHANGE PIN"); // setting the text in the button as CHANGE PIN
        button4.addActionListener(this); // calling this class that implements ActionListener and method actionPerformed for the  functionality of this button
        button5.setText("CHECK ACCOUNT DETAILS"); // setting the text in the button as CHECK ACCOUNT DETAILS
        button5.addActionListener(this); // calling this class that implements ActionListener and method actionPerformed for the  functionality of this button



        panel.add(button); // add the first button to the panel
        panel.add(button1);// add the second button to the panel
        panel.add(button2); // add the third button to the panel
        panel.add(button3); // add the fourth button to the panel
        panel.add(button4); // add the fifth button to the panel
        panel.add(button5); // add the sixth button to the panel
        panel.setLayout(new GridLayout(3,2)); // arranging the buttons in the grid form of 3 rows and 2 columns

        this.add(panel); // adding the panel to the frame
        this.setTitle("BD"); // setting the frames title to BK
        this.setSize(600,420); // setting the size of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this allows the frame to close when the exist button is press
        this.setVisible(true); // making the frame visible
    } // end of the constructor
        public void actionPerformed(ActionEvent e){ // the method that is in charge of the button events(button clicks)
            if(e.getActionCommand().equals("WITHDRAW")){ // checking if the button clicked was the WITHDRAW button
                withDraw = true; // set the boolean variable withDraw to true
                Frame3 frame3 = new Frame3(); // creating an object frame3 of class Frame3 which will display another window
            } // end of if condition
            else if(e.getActionCommand().equals("DEPOSIT")){ // checking if the button clicked was the DEPOSIT button
                 deposit=true; // set the boolean variable deposit to true
                 Frame3 frame3 = new Frame3(); //creating an object frame3 of class Frame3 which will display another window
            } // end of else if condition
            else if(e.getActionCommand().equals("CHECK ACCOUNT DETAILS")){ // checking if the button clicked was the CHECK ACCOUNT DETAILS button
                account = true; // set the boolean variable account to true
                Frame3 frame3 = new Frame3(); //creating an object frame3 of class Frame3 which will display another window
            } // end of else if condition
            else if(e.getActionCommand().equals("CHANGE PIN")){ // checking if the button clicked was the CHANGE PIN button
                changePin = true; // set the boolean variable changePin to true
                Frame3 frame3 = new Frame3(); //creating an object frame3 of class Frame3 which will display another window
            } // end of else if condition
            else if(e.getActionCommand().equals("CREATE ACCOUNT")){  // checking if the button clicked was the CREATE ACCOUNT button
                Frame9 frame9 = new Frame9(); //creating an object frame9 of class Frame9 which will display another window
            } // end of else if condition
            else if(e.getActionCommand().equals("CHECK ACCOUNT BALANCE")){ // checking if the button clicked was the CHECK ACCOUNT BALANCE button
                balance = true; // set the boolean variable balance to true
                Frame3 frame3 = new Frame3(); //creating an object frame3 of class Frame3 which will display another window
            } // end of else if condition
        } // end of actionPerformed method
} // end of class Frame2
