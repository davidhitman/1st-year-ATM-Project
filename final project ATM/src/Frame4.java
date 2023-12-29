// frame 4 withdrawing the money

import javax.swing.*; // importing a library that include the JFrame, JPanel, JLabel
import java.awt.*; // importing a library that include Font and GridLayout to be used in the styling of this Frame
import java.awt.event.*; // importing a library that has ActionListener, ActionEvent and getActionCommand used to capture the Action of a button
import java.sql.*; // import libraries that would enable us to access the sql

public class Frame4 extends JFrame implements ActionListener { // The class Frame4 that inherits from the superclass JFrame and implements
    // ActionListener which is used to handle all action Events such as when a user clicks on a button.
    JTextField textBox; // declaring textBox of type JTextField
    String stringAmount; // declare stringAmount of type String
    boolean notInt= false; // declare boolean notInt and set it to false

    Frame4(){
        JPanel panel = new JPanel(); // creating panel in the GUI window
        JPanel panel1 = new JPanel(); //creating panel1 in the GUI window
        JPanel panel2 = new JPanel(); // creating panel2 in the GUI window
        JLabel label = new JLabel("Enter the Amount You Want to withdraw"); // creating the label and setting the text to "Enter the Amount You Want to withdraw"
        textBox = new JTextField(30); // create a textBox and set it's width to 30
        JButton button = new JButton(); // create a button

        label.setFont(new Font("Sans-serif",Font.BOLD,20)); // setting the font type , font weight and the font size

        button.setText("ENTER"); // set the text in the button
        button.addActionListener(this); // calling this class that implements ActionListener and method actionPerformed for the functionality of this button

        panel.add(label); // adding the label in the panel
        panel1.add(textBox); // adding the textBox in the panel1
        panel2.add(button); // adding the button to the panel2

        this.add(panel); // add panel to frame4
        this.add(panel1); // add panel1 to frame4
        this.add(panel2); // add panel2 to frame4
        this.setLayout(new GridLayout(3,0)); // set the layout of the three panel in frame4, Grid the panel 3 rows and 0 column
        this.setSize(520,420); // set the size of frame4 to width 520 and height 420
        this.setTitle("BK"); // set the title of the frame to "BK"
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // this allows the frame to close when the exist button is press
        this.setVisible(true); // making the frame visible
    } // end of the constructor

    public long withDraw(){ // method withDraw that returns the total amount
        long  intAmount = 0; // initialise the intAmount to zero
        long totalAmount; // declare totalAmount
        stringAmount = textBox.getText(); // store the input the user entered in the variable stringAmount
        try{ // exception to check if the user has entered digits for the amount to withdraw
            intAmount = Long.parseLong(stringAmount); // convert the stringAmount from string to long and store the value in intAmount
        }catch (NumberFormatException ex){ // if its not possible to convert the stringAmount to long the the user didn't enter digits
            // the error is caught and display the appropriate message in the messageBox
            JOptionPane.showMessageDialog(null, "The Amount has to be in Digits"); // messageBox
            notInt= true; // set notInt to true meaning the value entered by the user is not an integer
        } // end of the exception
        if(FrameN.charge==50){ // if variable charge in frameN is equal to 50
           totalAmount = intAmount + 50; // add 50 to the amount to be withDrawn
        } // end of the if condition
        else if(FrameN.charge==100){ // if variable charge in frameN is equal to 100
           totalAmount = intAmount + 100; // add 100 to the amount to be withDrawn
        } // end of the else if condition
        else{ // else if the variable charge in frameN is equal to 10
            totalAmount = intAmount + 10; // add 10 to the amount to be withDrawn
        } // end of the else condition
        return totalAmount; // return the totalAmount
    } // end of method withDraw

    public void actionPerformed(ActionEvent e){ // the method that is in charge of the button events(button clicks)
        String stringBalance=""; // declare string stringBalance
        try { // exception handling that checks if there is any error regarding the sql connectivity and access the sql
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM", "root", "David@25092");
            // creating a connection (variable connect of type Connection) with the workbench sql the url is location of the sql,
            // on the url the is a word ATM which is the name of the table
            // provide the User and the password of your workbench as well
            Statement state = connect.createStatement();// declaring variable state of type Statement used to execute the sql line
            ResultSet res = state.executeQuery("select Amount from custome where Pin="+Frame3.intEnteredPin);
            // sql statement to select the column Amount from the table custome where the pin is equal to the pin entered in Frame3
            // store the data retrieved from the database in the variable res
            if (e.getActionCommand().equals("ENTER")) { // check if the button clicked is the enter button
                while(res.next()){ // this is a while loop that loops through the data retrieved from the database
                    String stringCashBank = res.getString("Amount"); // store the Amount retrieved from the database in the variable stringCashBank
                    long intCashBank = Long.parseLong(stringCashBank); // convert stringCashBank from String to long and store it in variable intCashBank
                    long Amount = withDraw(); // store the  value returned by the method withDraw in the variable Amount
                    if(Amount <= intCashBank && notInt==false){ // checking if the money to be deducted is not greater than what is stored in the database
                        // and the Amount is an integer
                        long balance = intCashBank - Amount; // subtract the Amount to be withdrawn from the amount stored in the Database
                        stringBalance = Long.toString(balance); // convert balance from Long to string
                        int query= state.executeUpdate("update custome set Amount ="+stringBalance+" where Pin = "+Frame3.intEnteredPin);
                        // store the new balance into the sql
                        if(FrameN.charge==50){ // if the charge in frameN is 50
                            // print the the amount you withdrew and that you were charged 50
                            JOptionPane.showMessageDialog(null, "You have successfully withdrawn"+" "+stringAmount+"AED"+" "+"you have been charged 50 AED for the service");
                        } // end of the if condition
                        else if(FrameN.charge==100){ // if the charge in frameN is 100
                            // print the the amount you withdrew and that you were charged 100
                            JOptionPane.showMessageDialog(null, "You have successfully withdrawn"+" "+stringAmount+"AED"+" "+"you have been charged 100 AED for the service");
                        } // end of the else if condition
                        else{ // else the charge in frameN is 10
                            // print the the amount you withdrew and that you were charged 10
                            JOptionPane.showMessageDialog(null, "You have successfully withdrawn"+" "+stringAmount+"AED"+" "+"you have been charged 10 AED for the service");
                        } // end of the else condition
                    } // end of the if condition
                    else if(Amount > intCashBank && notInt==false){ // if the amount to be withdrawn is greater than what is stored in the database and the
                        // amount to be withdrawn is still in digits, display the appropriate message.
                        JOptionPane.showMessageDialog(null, "You Don't have enough cash in your bank account"); // messageBox
                    } // end of else if condition
                } // end of while condition
            } // end of if condition
            notInt=false; // I set the notInt value to false because when I need to enter the digit after the error has occurred it should run cuz
            // after the error the notInt is set to true and wen u try to enter again it doesn't work... it requires u tu re run the programme.... because it was initialised at the start og the class
        }catch (Exception a){ // if there is any error regarding accessing and connecting to the database
            // the error will be caught by this part of the code
            System.out.println(a); // print out the error
        } // end of exception
    }  // end of actionPerformed method
} // end of class Frame4


