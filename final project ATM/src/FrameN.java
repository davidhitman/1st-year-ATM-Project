// frameN choose the type of account if you want to withdraw

import javax.swing.*; // importing a library that include the JFrame, JPanel, JLabel
import java.awt.*; // importing a library that include Font and GridLayout to be used in the styling of this Frame
import java.awt.event.*; // importing a library that has ActionListener, ActionEvent and getActionCommand used to capture the Action of a button
import java.sql.*; // import libraries that would enable us to access the sql

public class FrameN extends JFrame implements ActionListener { // The class FrameN that inherits from the superclass JFrame and implements
    // ActionListener which is used to handle all action Events such as when a user clicks on a button.
    public static int charge; // declaring variable charge, making the variable public and static so as it can be passed to other classes

    FrameN() {
        JPanel panel1 = new JPanel(); // creating the  first panel in the GUI window
        JPanel panel2 = new JPanel(); // creating the second panel in the GUI window
        JLabel label = new JLabel(); // creating the label
        JButton button = new JButton(); // declaration of the object button of class JButton / creating a new button
        JButton button1 = new JButton(); // declaration of the object button1 of class JButton / creating a new button
        JButton button2 = new JButton(); //  declaration of the object button2 of class JButton / creating a new button

        label.setText("CHOOSE THE TYPE OF YOUR ACCOUNT"); // setting the text of the label to "CHOOSE THE TYPE OF YOUR ACCOUNT"
        button.setText("SAVINGS"); // setting the text in the button to "saving"
        button.addActionListener(this); // calling this class that implements ActionListener and method actionPerformed for the functionality of this button
        button1.setText("CURRENT"); // setting the text in the button1 to "current"
        button1.addActionListener(this); // calling this class that implements ActionListener and method actionPerformed for the functionality of this button
        button2.setText("STUDENT"); // setting the text in the button2 to "student"
        button2.addActionListener(this); // calling this class that implements ActionListener and method actionPerformed for the functionality of this button

        label.setFont(new Font("Sans-serif", Font.BOLD, 30)); // setting the font type , font weight and the font size

        panel1.add(label); // add label into panel1
        panel2.add(button); // add button into panel2
        panel2.add(button1); // add button1 to panel2
        panel2.add(button2); // add button2 to panel2
        panel2.setLayout(new GridLayout(0, 3)); // set the layout of the three buttons in panel2, Grid the buttons 3 columns and 0 rows

        this.setLayout(new GridLayout(2, 0)); // set the layout of the two panel in frameN, Grid the panel 2 rows and 0 column
        this.add(panel1); // add panel1 to frameN
        this.add(panel2); // add panel12 to frameN
        this.setTitle("BD"); // set the title of the frame to "BK"
        this.setSize(650, 420); // set the size of frameN to width 650 and height 420
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this allows the frame to close when the exist button is press
        this.setVisible(true); // making the frame visible
    } // end of the constructor

    public void actionPerformed(ActionEvent e) { // the method that is in charge of the button events(button clicks)
        boolean found = false; // setting a boolean variable found to false
        try { // exception handling that checks if there is any error regarding the sql connectivity and access the sql
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM", "root", "David@25092");
            // creating a connection (variable connect of type Connection) with the workbench sql the url is location of the sql,
            // on the url the is a word ATM which is the name of the table
            // provide the User and the password of your workbench as well
            Statement state = connect.createStatement(); // declaring variable state of type Statement used to execute the sql line
            ResultSet res = state.executeQuery("select AccountType from custome where Pin=" + Frame3.intEnteredPin);
             // sql statement to select the column AccountType from the table custome where the pin is equal to the pin entered in Frame3
            // store the data retrieved from the database in the variable res
            while (res.next()) { // this is a while loop that loops through the data retrieved from the database
                if (Frame2.withDraw == true) { // if the withdraw from frame2 is true, meaning the user selected option withdraw
                    if (e.getActionCommand().equals("SAVINGS")) { // if statement to check if the button the user clicked is "Savings"
                        if (res.getString("AccountType").equals("Saving")) { // check in the database if the account type is really saving
                            charge = 50; // set the charge to 50
                            found = true; // set the boolean variable found to true
                        } else { // if the account type in the database is not saving
                            // display "Your account is not a Savings Account" in a messageBox
                            JOptionPane.showMessageDialog(null, "Your account is not a Savings Account"); // messageBox
                        } // end of the if else condition
                    } else if (e.getActionCommand().equals("CURRENT")) { // if statement to check if the button the user clicked is "Current"
                        if (res.getString("AccountType").equals("Current")) { // check in the database if the account type is really current
                            charge = 100; // set charge to 100
                            found = true; // set the boolean variable found to true
                        } else { // if the account type in the database is not current
                            // display "Your account is not a Current Account" in a messageBox
                            JOptionPane.showMessageDialog(null, "Your account is not a Current Account"); // messageBox
                        } // end of if else condition

                    } else { // else if the account type is student
                        if (res.getString("AccountType").equals("Student")) { // check in the database if the account type is really student
                            charge = 10; //  set charge to 10
                            found = true; // set the boolean variable found to true
                        } else { // if the account type in the database is not student
                            // display "Your account is not a Student Account" in a messageBox
                            JOptionPane.showMessageDialog(null, "Your account is not a Student Account"); // messageBox
                        } // end of the else statement
                    } // end of the else statement
                    if (found==true){ // if found is true meaning the account type the user selected is equal to the account type stored in the database then
                        Frame4 frame4 = new Frame4();// Display Frame4 by setting an object frame4 of class Frame4
                   } // end of the if condition
                } // end of the if condition
            } // end of the while loop
        } catch (Exception a) { // if there is any error regarding accessing and connecting to the database
            // the error will be caught by this part of the code
            System.out.println(a); // print out the error
        } // end of exception
    } // end of actionPerformed method
} // end of class Frame3



