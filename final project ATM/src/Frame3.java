// Third frame Enter your Pin in your System

import javax.swing.*; // importing a library that include the JFrame, JPanel, JLabel
import java.awt.*; // importing a library that include Font and GridLayout to be used in the styling of this Frame
import java.awt.event.*; // importing a library that has ActionListener, ActionEvent and getActionCommand used to capture the Action of a button
import java.sql.*; // import libraries that would enable us to access the sql

public class Frame3 extends JFrame implements ActionListener { // The class Frame3 that inherits from the superclass JFrame and implements
    // ActionListener which is used to handle all action Events such as when a user clicks on a button.
    static JTextField textBox; // declaring textBox of type JTextField and making it static so as it can be used in the main method as well as in the other methods
    public static int intEnteredPin; // declaring a int variable intEnteredPin, making the variable public so as it can be used in other frames.

    Frame3(){

        JPanel panel = new JPanel(); // creating the  first panel in the GUI window
        JPanel panel1 = new JPanel(); // creating the second panel in the GUI window
        JPanel panel2 = new JPanel(); // creating the third panel in the GUI window
        JLabel label = new JLabel("ENTER PIN:"); // the label Enter Pin
        textBox = new JTextField(25);// text filled where data is enter with the width of 25
        JButton button = new JButton(); // declaration of the object button of class JButton / creating a new button


        label.setFont(new Font("Sans-serif",Font.BOLD,40)); // setting the font type , font weight and the font size

        button.setText("Enter"); //setting the text in the button as Enter
        button.addActionListener(this); // calling this class that implements ActionListener and method actionPerformed for the functionality of this button

        panel.add(label); //add the label to the panel
        panel1.add(textBox); //add the textBox to the panel
        panel2.add(button); //add the button to the panel

        this.setLayout(new GridLayout(3,0)); // arranging the 3 panels in the frame using GridLayout
        this.add(panel); //placing the panel in the frame
        this.add(panel1); // placing the panel1 in the frame
        this.add(panel2); //placing the panel2 in the frame
        this.setTitle("BD"); // setting the frames title to BK
        this.setSize(420,420); // setting the size of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this allows the frame to close when the exist button is press
        this.setVisible(true); // making the frame visible
    } // end of the main frame

    public void actionPerformed(ActionEvent e) { // the method that is in charge of the button events(button clicks)
        int pin = 0; // declaring the int variable pin
        boolean pinFound=false, notInt=false; // declaring the boolean variable pinFound, notInt
        try { // exception handling that checks if there is any error regarding the sql connectivity and access the sql
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM", "root", "David@25092");
            // creating a connection (variable connect of type Connection) with the workbench sql the url is location of the sql,
            // on the url the is a word ATM which is the name of the table
            // provide the User and the password of your workbench as well
            Statement state = connect.createStatement(); // declaring variable state of type Statement used to execute the sql line
            ResultSet res = state.executeQuery("select Pin from custome"); // variable res of type ResultSet to store the data retrieved from the Database
            // In this case we have selected all the pins from our table custome
            if(e.getActionCommand().equals("Enter")){ // checking if the button clicked was the Enter button
                String enteredPin = textBox.getText(); // store what was typed in the textBox in the string variable enteredPin
                try{ //  exception handling that checks if the pin entered by the user is made of digits or if there is no letter in it
                    intEnteredPin = Integer.parseInt(enteredPin); // converting the string enteredPin into an integer and storing the results in variable intEnteredPin
                }catch (NumberFormatException ex){ // If converting the string enteredPin into an integer fails then the exception catch the error
                    // print a message " The Pin has to be in Digits" in the message box as shown bellow
                    JOptionPane.showMessageDialog(null, "The Pin has to be in Digits"); // message box
                    notInt=true; // set notInt to true meaning the pin entered was not an integer
                }
                while (res.next()){ // this is a while loop that loops through the data retrieved from the database
                    pin=res.getInt("Pin"); // store the pin retrieved from the database in the variable pin
                    if(intEnteredPin==pin){ // check if the pin entered by the user matches the pin in the database
                        pinFound=true; // if so set pinFound to true
                        if(Frame2.withDraw==true) { // check if the boolean variable withDraw in Frame2 is equal to true
                            FrameN frameN = new FrameN(); // Display FrameN by setting an object frameN of class FrameN
                        } // end of if condition
                        else if(Frame2.balance==true){ // check if the boolean variable balance in Frame2 is equal to true
                            Frame7 frame7 = new Frame7(); // Display Frame7 by setting an object frame7 of class Frame7
                            res = state.executeQuery("select Amount from custome where Pin=" + intEnteredPin);
                            // sql statement to select the column Amount in the table custome and retrieve the amount
                            // where the pin in the database is the same as the pin entered by the user
                            while (res.next()) { // this is a while loop that loops through the data retrieved from the database
                                String balance = res.getString("Amount"); // store the amount retrieved from the database in the variable balance
                                Frame7.label1.setText(balance + " " + "AED"); // set label1 in Frame7 to balance
                            } // end of while loop
                        } // end of else if condition
                        else if(Frame2.deposit == true){ // check if the boolean variable deposit in Frame2 is equal to true
                            Frame5 frame5 = new Frame5(); // Display Frame5 by setting an object frame5 of class Frame5
                        } // end of else if condition
                        else if(Frame2.account==true){ // check if the boolean variable account in Frame2 is equal to true
                            Frame8 frame8 = new Frame8(); // Display Frame8 by setting an object frame8 of class Frame8
                            res = state.executeQuery("select * from custome where Pin=" + intEnteredPin);
                            // the sql statement that selects all the information about a customer from the table custome
                            // where the pin in the database is the same as the pin entered by the user
                            while(res.next()){
                                String firstName = res.getString("FirstName"); // storing the firstName retrieved from the database in a string variable firstName
                                String surName = res.getString("SurName"); // storing the SurName retrieved from the database in a string variable SurName
                                String Name = firstName+" "+surName; // concatenating both the firstName and SurName and store it in Name
                                Frame8.label1.setText("Name:"+" "+Name);  //set label1 in Frame8 to Name
                                Frame8.label2.setText("Age:"+" "+res.getInt("Age")); // set label2 in frame8 to the value retrieved from the database in column Age
                                Frame8.label3.setText("Address:"+" "+res.getString("Address")); // set label3 in frame8 to the value retrieved from the database in column Address
                                Frame8.label4.setText("Telephone Number:"+" "+res.getString("Contact")); // set label4 in frame8 to the value retrieved from the database in column Contact
                                Frame8.label5.setText("Email:"+" "+res.getString("Email")); // set label5 in frame8 to the value retrieved from the database in column Email
                                Frame8.label6.setText("Gender:"+" "+res.getString("Gender")); // set label6 in frame8 to the value retrieved from the database in column Gender
                                Frame8.label7.setText("Amount:"+" "+res.getString("Amount")); // set label7 in frame8 to the value retrieved from the database in column Amount
                                Frame8.label8.setText("Pin:"+" "+res.getInt("Pin")); // set label8 in frame8 to the value retrieved from the database in column Pin
                                Frame8.label9.setText("Account Type:"+" "+res.getString("AccountType")); // set label9 in frame8 to the value retrieved from the database in column AccountType
                            } // end of the while loop
                        } // end of the if else condition
                        else if(Frame2.changePin==true){ // check if the boolean variable changePin in Frame2 is equal to true
                            Frame6 frame6 = new Frame6(); // Display Frame6 by setting an object frame6 of class Frame6
                        } // end of the else if condition
                    } // end of the first if condition
                } // end of the while loop
                if(pinFound==false && notInt==false){ // if the pin was not found but the pin is an integer
                    // the message box that display "Wrong Pin" will be displayed
                    JOptionPane.showMessageDialog(null, "WRONG PIN"); // message box
                } // end of if condition
            } // end of the if condition
            connect.close(); // closing the Database connection
        } catch (Exception a) { // if there is any error regarding accessing and connecting to the database
            // the error will be caught by this part of the code
            System.out.println(a); // print out the error
        } // end of exception
    } // end of actionPerformed method
} // end of class Frame3

