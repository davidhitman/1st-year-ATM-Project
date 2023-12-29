// frame 6 for changing your pin

import javax.swing.*; // importing a library that include the JFrame, JPanel, JLabel
import java.awt.*; // importing a library that include Font and GridLayout to be used in the styling of this Frame
import java.awt.event.*; // importing a library that has ActionListener, ActionEvent and getActionCommand used to capture the Action of a button
import java.sql.*; // import libraries that would enable us to access the sql

public class Frame6 extends JFrame implements ActionListener { // The class Frame5 that inherits from the superclass JFrame and implements
    JTextField textBox, textBox1; // declaring textBox and textBox1 of type JTextField
    int intPin1; //declaring intPin1 of type int
    boolean pinDigit=true; // declaring boolean pinDigit setting it to true
    Frame6(){

        JPanel panel = new JPanel(); // creating panel in the GUI window
        JPanel panel1 = new JPanel(); // creating panel1 in the GUI window
        JLabel label = new JLabel("ENTER YOUR NEW PIN"); // creating a label and setting the text to "Enter Your New Pin"
        textBox = new JTextField(20); // creating a text field and set it width to 10
        JLabel label1 = new JLabel("RE-ENTER YOUR NEW PIN"); // creating a label and setting the text to "RE-ENTER YOUR NEW PIN"
        textBox1 = new JTextField(20); // creating a text field and set it width to 10
        JButton button = new JButton(); // creating a button

        button.setText("ENTER"); // set the text of a button to "Enter"
        button.addActionListener(this); // calling this class that implements ActionListener and method actionPerformed for the functionality of this button

        panel.add(label); // adding a label to panel
        panel.add(textBox); // adding the textBox to panel
        panel.add(label1); // adding a label1 to panel
        panel.add(textBox1); // adding the textBox1 to panel
        panel1.add(button); // adding a button to panel1

        this.add(panel); // add the panel to the frame
        this.add(panel1); // add the panel1 to the frame
        this.setLayout(new GridLayout(2,0)); // set the layout of the two panel in frame6, Grid the panel 2 rows and 0 column
        this.setSize(420,320); // set the size of frame5 to width 420 and height 420
        this.setTitle("BK"); // set the title of the frame to "BK"
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //  this allows the frame to close when the exist button is press
        this.setVisible(true); // making the frame visible
    }
    public boolean pinValidation(){ // the method that is in charge of the button events(button clicks)
        int intPin2 = 0; // declaring an integer intPin2
        String stringPin1 = textBox.getText(); // storing the info entered in the first field by the user in the string stringPin1
        String stringPin2 = textBox1.getText(); // storing the info entered in the second text field by the user in the string stringPin1
        try{ // exception to check if the user has entered digits for the pin to be saved
            intPin1 = Integer.parseInt(stringPin1); // converting stringPin1 to integer
            intPin2 = Integer.parseInt(stringPin2); // converting stringPin2 to integer
        }catch (NumberFormatException ex){ //  if its not possible to convert the variables stringPin1 or stringPin2 to integer then the user didn't enter digits
            // the error is caught and display the appropriate message in the messageBox
            JOptionPane.showMessageDialog(null, "The PIN has to be in Digits");
            pinDigit = false; // set the variable pinDigit to false
        } // end of the exception
        if (intPin1 == intPin2){ // compare the two pins entered by the user
            // if they are equal then return true
            return true;
        } // end of the if condition
        else{ // if the two pins are not equal then
            // return false
            return false;
        } // end of the else condition
    } // end of the method pinValidation
    public void actionPerformed(ActionEvent e) { // the method that is in charge of the button events(button clicks)
        boolean valid; // declare the boolean variable valid
        try { // exception handling that checks if there is any error regarding the sql connectivity and access the sql
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM", "root", "David@25092");
            // creating a connection (variable connect of type Connection) with the workbench sql the url is location of the sql,
            // on the url the is a word ATM which is the name of the table
            // provide the User and the password of your workbench as well
            Statement state = connect.createStatement(); // declaring variable state of type Statement used to execute the sql line
            ResultSet res = state.executeQuery("select Pin from custome where Pin=" + Frame3.intEnteredPin);
            // sql statement to select the column Pin from the table custome where the pin is equal to the pin entered in Frame3
             // store the data retrieved from the database in the variable res
            if (e.getActionCommand().equals("ENTER")){ // check if the button clicked is the enter button
                valid = pinValidation(); // call the method pinValidation
                if (valid==true && pinDigit==true){ // if valid is true and the pin is a digit then
                    int query= state.executeUpdate("update custome set Pin ="+intPin1+" where Pin = "+Frame3.intEnteredPin);
                    // store the new pin in the database
                    JOptionPane.showMessageDialog(null, "You Have successfully changed your Pin");
                    // displaying the message "You Have successfully changed your Pin" in the message box
                } // end of the if condition
                else if (valid!=true && pinDigit==true){ // if valid is not equal to true and the pin is a digit
                    // displaying the message "Both Pins Entered above don't match" in the message box
                    JOptionPane.showMessageDialog(null, "Both Pins Entered above don't match");
                } // end of the else if condition
                pinDigit=true; // set pinDigit to true
            } // end of the if condition
        } catch (Exception a) { // if there is any error regarding accessing and connecting to the database
            System.out.println(a); // print the error
        } // end of exception
    } // end of actionPerformed method
} // end of class Frame6

