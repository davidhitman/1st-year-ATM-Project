// frame5 Depositing the money

import javax.swing.*; // importing a library that include the JFrame, JPanel, JLabel
import java.awt.*; // importing a library that include Font and GridLayout to be used in the styling of this Frame
import java.awt.event.*; // importing a library that has ActionListener, ActionEvent and getActionCommand used to capture the Action of a button
import java.sql.*; // import libraries that would enable us to access the sql


public class Frame5 extends JFrame implements ActionListener { // The class Frame5 that inherits from the superclass JFrame and implements
    JTextField textBox1; // declaring textBox1 of type JTextField

    Frame5(){

        JPanel panel = new JPanel(); // creating panel in the GUI window
        JPanel panel1 = new JPanel(); // creating panel1 in the GUI window
        JPanel panel2 = new JPanel(); // creating panel2 in the GUI window
        JLabel label = new JLabel("Enter the Amount You Want to Deposit"); // creating the label and setting the text to "Enter the Amount You Want to Deposit"
        textBox1 = new JTextField(30); // create a text field and set it's width to 30
        JButton button = new JButton(); // create a button

        label.setFont(new Font("Sans-serif",Font.BOLD,20)); // setting the font type , font weight and the font size of the label

        button.setText("ENTER"); // set the text in the button
        button.addActionListener(this); // calling this class that implements ActionListener and method actionPerformed for the functionality of this button

        panel.add(label); // adding the label in the panel
        panel1.add(textBox1); // adding the textBox1 in the panel1
        panel2.add(button); // adding the button in panel2


        this.add(panel); // adding panel to frame5
        this.add(panel1); // adding panel1 to frame5
        this.add(panel2); // adding panel2 to frame2
        this.setLayout(new GridLayout(3,0)); // set the layout of the three panel in frame5, Grid the panel 3 rows and 0 column
        this.setSize(420,420); // set the size of frame5 to width 420 and height 420
        this.setTitle("BK"); // set the title of the frame to "BK"
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // this allows the frame to close when the exist button is press
        this.setVisible(true); // making the frame visible
    } // end of the constructor

    public void actionPerformed(ActionEvent e){ // the method that is in charge of the button events(button clicks)
        String stringTotalAmount=" "; // declaring string stringTotalAmount
        long intAmountEntered = 0; // declaring long intAmountEntered
        boolean notDigit = false; // declaring boolean notDigit and setting it to zero
        try { // exception handling that checks if there is any error regarding the sql connectivity and access the sql
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM", "root", "David@25092");
            // creating a connection (variable connect of type Connection) with the workbench sql the url is location of the sql,
            // on the url the is a word ATM which is the name of the table
            // provide the User and the password of your workbench as well
            Statement state = connect.createStatement(); // declaring variable state of type Statement used to execute the sql line
            ResultSet res = state.executeQuery("select Amount from custome where Pin="+Frame3.intEnteredPin);
            // sql statement to select the column Amount from the table custome where the pin is equal to the pin entered in Frame3
            // store the data retrieved from the database in the variable res
            if (e.getActionCommand().equals("ENTER")) { // check if the button clicked is the enter button
                String AmountEntered = textBox1.getText(); // store the input the user entered in the variable AmountEntered
                try{ // exception to check if the user has entered digits for the amount to withdraw
                    intAmountEntered = Long.parseLong(AmountEntered);// convert the variable AmountEntered from string to long and store the value in variable intAmountEntered
                }catch (NumberFormatException ex){ // if its not possible to convert the variable AmountEntered to long the the user didn't enter digits
                    // the error is caught and display the appropriate message in the messageBox
                    JOptionPane.showMessageDialog(null, "The Amount has to be in Digits"); // messageBox
                    notDigit = true; // set notInt to true meaning the value entered by the user is not an integer
                } // end of the exception
               if (notDigit == false) { // if notDigit is false meaning the value entered is an integer
                    while (res.next()) { // this is a while loop that loops through the data retrieved from the database
                        String cashBank = res.getString("Amount"); // store the Amount retrieved from the database in the variable cashBank
                        long intCashBank = Long.parseLong(cashBank); // convert the string cashBank into an integer and store it in intCashBank
                        long totalAmount = intCashBank + intAmountEntered; // add  intCashBank and intAmountEntered
                        stringTotalAmount = Long.toString(totalAmount); // convert the integer totalAmount into a string and store it in stringTotalAmount
                   } // end of the while loop
                    int query = state.executeUpdate("update custome set Amount =" + stringTotalAmount + " where Pin = " + Frame3.intEnteredPin);
                    // store the new balance in the sql
                    JOptionPane.showMessageDialog(null, "Your Deposit of" + " " + AmountEntered + " " + "AED, Was successful");
                    // display the appropriate message in the messageBox
                } // end of the if condition
            } // end of the if condition
        }catch (Exception a){ // if there is any error regarding accessing and connecting to the database
            System.out.println(a); // print the error
        } // end of exception
    } // end of actionPerformed method
} // end of class Frame5
