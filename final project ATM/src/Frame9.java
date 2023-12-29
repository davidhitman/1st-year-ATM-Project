import javax.swing.*; // importing a library that include the JFrame, JPanel, JLabel
import java.awt.*; // importing a library that include Font and GridLayout to be used in the styling of this Frame
import java.awt.event.*; // importing a library that has ActionListener, ActionEvent and getActionCommand used to capture the Action of a button
import java.sql.*; // import libraries that would enable us to access the sql


public class Frame9 extends JFrame implements ActionListener{ // The class Frame4 that inherits from the superclass JFrame and implements
    // ActionListener which is used to handle all action Events such as when a user clicks on a button.
    JTextField [] textBox = new JTextField [10]; // declaring array textBox
    Frame9(){
        JPanel panel = new JPanel(); // creating panel in the GUI window
        JPanel panel1 = new JPanel(); //creating panel1 in the GUI window
        JLabel [] label = new JLabel [10]; // declaring array label
        String [] labels = {"First Name","Sur Name","Age","Address","Contact","Email","Gender","Amount","Pin","Account Type"};
        // storing data into the array

        JLabel label0 = new JLabel("ENTER YOUR DETAILS"); // creating a label0 and setting the text to "Enter Your Details"
        for (int i = 0; i < 10; i++) { // loop for creating text fields and labels
            label[i] = new JLabel(labels[i]); // creating labels and setting the text of each label to the value stored in the array label
            textBox[i] = new JTextField(10); // creating text field for user to enter data
            panel.add(label[i]); // adding the labels to the panel
            panel.add(textBox[i]); // adding the textBox to the panel
        } // end of for loop

        JButton button = new JButton(); // create a button
        button.setText("CREATE"); // set the text of the button to "CREATE"
        button.addActionListener(this); // calling this class that implements ActionListener and method actionPerformed for the functionality of this button
        panel1.add(button); // add the button to panel1
        panel.setLayout(new GridLayout(10,1)); // set the layout of the labels and text fields  in panel, Grid the panel to 10 rows and 1 column


        this.add(panel); // add panel into frame (window)
        this.add(panel1); // add panel1 into frame (window)
        this.setLayout(new GridLayout(2,0)); // set the layout of the three panel in frame9, Grid the panel 2 rows and 0 column
        this.setTitle("BK"); // set title of Frame9 to "BK"
        this.setSize(900,420); // set the size of frame5 to width 900 and height 420
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this allows the frame to close when the exist button is press
        this.setVisible(true); // making the frame visible
    }
    public void actionPerformed(ActionEvent e){ // the method that is in charge of the button events(button clicks)
        String [] content = new String [10]; // declaring array content to store the information entered by the user
        try{ // exception handling that checks if there is any error regarding the sql connectivity and access the sql
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM", "root", "David@25092");
            // creating a connection (variable connect of type Connection) with the workbench sql the url is location of the sql,
            // on the url the is a word ATM which is the name of the table
            // provide the User and the password of your workbench as well
            Statement state = connect.createStatement(); //  declaring variable state of type Statement used to execute the sql line
            for (int a = 0; a < 10; a++) { // for loop to store the values in array content
                content[a] = textBox[a].getText(); // storing the values in array content
            } // end of for loop
            if (e.getActionCommand().equals("CREATE")){ // checking if the button clicked is "CREATE"
                state.executeUpdate("Insert Into custome (FirstName,SurName,Age,Address,Contact,Email,Gender,Amount,Pin,AccountType) values('"+content[0]+"', '"+content[1]+"', '"+content[2]+"', '"+content[3]+"', '"+content[4]+"', '"+content[5]+"', '"+content[6]+"', '"+content[7]+"', '"+content[8]+"', '"+content[9]+"')");
            } // end of if condition
            connect.close(); // end of connection
            // display appropriate message after successfully creating the account
            JOptionPane.showMessageDialog(null, "You have successfully Created a new Account");
        }catch (Exception a){ //  if there is any error regarding accessing and connecting to the database
            System.out.println(a);  // print the error
        } // end of exception
    } // end of actionPerformed method
} // end of class Frame9
