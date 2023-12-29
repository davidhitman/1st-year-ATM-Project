import java.util.Scanner;
public class AtmApplication {

    public static void main(String[] args) { // main method
        int passPin1=0; // setting passPin1 to 0 this variable is going to hold the pin of the new account owner
        int passAmount1=0; // setting passAmount1 to 0 this variable is going to hold the Amount of the new account owner
        AccountHolder N0 = new AccountHolder(); // declaring object N0 of class AccountHolder. Object N0 has Default values that are already stored in the ATM
        long passAmount = N0.Amount; // setting the variable AmountPass with the default value of Amount of class AccountHolder
        int passPin= N0.pin; // setting the variable pinPass with the default value of pin of class AccountHolder
        menu(passPin,passAmount,passPin1,passAmount1);// calling the function menu and passing parameters pinPass,passAmount,pinPass1 and passAmount1 with it.
        }

    public static void menu(int passPin, long passAmount,int passPin1, long passAmount1){ // the menu method that will be used to call other methods and where most of the details of the program are.

        int choice; // initialization of the variable choice
        Scanner input = new Scanner(System.in);// Declaring object input of Scanner class

        System.out.println("Welcome To Dubai ATM Machine");

        // Displaying the services offered by the ATM and what the user should enter to access a particular service

        System.out.println("\nEnter 1 for withdrawing money");
        System.out.println("Enter 2 for adding money");
        System.out.println("Enter 3 for changing the PIN");
        System.out.println("Enter 4 for checking your Account Balance");
        System.out.println("Enter 5 for adding a new account Holder");

        System.out.print("\nEnter your choice:");
        choice= input.nextInt(); // storing the choice entered by the user into variable choice

        while (choice!=1 && choice !=2 && choice !=3 && choice !=4 && choice!=5){ // while loop to check if the choice entered is in the range 1 to 5 if not enter the value again
            System.out.println("Wrong choice Entered");
            System.out.print("\nEnter your choice Again:");
            choice= input.nextInt(); //storing the choice entered by the user into variable choice
        }// end of the while loop

        switch (choice){ // switch cases used to call the methods depending on the choice of the user
            case 1: withDraw(passPin,passAmount,passPin1,passAmount1);
            case 2: AddMoney(passPin,passAmount,passPin1,passAmount1);
            case 3: passChange(passPin,passAmount,passPin1,passAmount1);
            case 4: balanceDisplay(passPin,passAmount,passPin1,passAmount1);
            case 5: newOwner(passPin,passAmount,passPin1,passAmount1);
        } // end of switch case
    }// end of the menu method


    public static void withDraw(int passPin,long passAmount,int passPin1, long passAmount1){// method to withdraw money from the ATM
        Scanner input = new Scanner(System.in);// Declaring object input of Scanner class
        long cashOut; // declaring variable cashOut as long to store the amount the user wants to withdraw
        int pinEntered; // declaring variable pinEntered as int to store the pin entered by the user
        System.out.print("Enter your PIN:");
        pinEntered=input.nextInt();// storing the pin entered by the user in variable pinEntered
        if(pinEntered==passPin) { // if statement comparing if the pin entered is equal to the pin that's already stored in the passPin
            System.out.print("Enter the amount you want to withdraw:");
            cashOut=input.nextInt(); // storing the amount the user entered into an variable called CashOut
            if(cashOut>passAmount){ // if condition checking if the amount the user wants to withdraw is not greater than the amount of money he has.
                System.out.println("You Don't have enough money in your Account");
                System.out.println("\nEnter 1 to return to the menu or 0 to exist:");// prompting the User to enter 1 if they want to return to menu or zero if they want to exit the programme
                int pasChoice=input.nextInt(); // storing the user's choice in variable pasChoice
                switch (pasChoice) { // a switch case statement that calls the method menu when the user has entered 1
                    case 1: menu(passPin, passAmount,passPin1,passAmount1);
                    case 0:
                }// end of case statement
            }// end of if statement
            else{ // if the Amount Entered by the user is not greater than the amount stored in passAmount then,
                passAmount=passAmount-cashOut; // the stored amount is subtracted from the amount the user wants to withdraw
                System.out.println("You have successfully withdrawn:"+" "+cashOut+"AED,"+"Your balance is:"+" "+passAmount+"AED."); // displaying the balance and the money the user withdrew
                System.out.println("Enter 1 to return to the menu or 0 to exist:"); // prompting the User to enter 1 if they want to return to menu or zero if they want to exit the programme
                int pasChoice=input.nextInt(); // storing the user's choice in variable pasChoice
                switch (pasChoice){ // a switch case statement that calls the method menu when the user has entered 1
                    case 1: menu(passPin,passAmount,passPin1,passAmount1);
                    case 0:
                }// end of switch
            }// end of else statement
        }// end of if statement
        else if (pinEntered==passPin1 && pinEntered!=0){ //if statement comparing if the pin entered is equal to the pin that's already
            // stored in the passPin1 and if the pin entered is not equal to zero if the Pin is equal to zero then that means the is on one account the default account
            System.out.print("Enter the amount you want to withdraw:");
            cashOut=input.nextInt(); // storing the amount the user entered into an variable called CashOut
            if(cashOut>passAmount1){ // if statement to check if the Amount Entered by the user to with draw is greater that the amount stored in passAmount1 (which is the money he has)
                System.out.println("You Don't have enough money in your Account");
                System.out.println("\nEnter 1 to return to the menu or 0 to exist:"); // prompting the User to enter 1 if they want to return to menu or zero if they want to exit the programme
                int pasChoice=input.nextInt(); //storing the user's choice in variable pasChoice
                switch (pasChoice) { // a switch case statement that calls the method menu when the user has entered 1
                    case 1: menu(passPin, passAmount,passPin1,passAmount1);
                    case 0:
                }// end of case statement
            }// end of  if statement
            else{ //if the Amount Entered by the user is not greater than the amount stored in passAmount1 then,
                passAmount1=passAmount1-cashOut;
                System.out.println("You have successfully withdrawn:"+" "+cashOut+"AED,"+"Your balance is:"+" "+passAmount1+"AED.");
                System.out.println("Enter 1 to return to the menu or 0 to exist:"); // prompting the User to enter 1 if they want to return to menu or zero if they want to exit the programme
                int pasChoice=input.nextInt();
                switch (pasChoice){ // a switch case statement that calls the method menu when the user has entered 1
                    case 1: menu(passPin,passAmount,passPin1,passAmount1);
                    case 0: 
                }// end of switch
            }// end of else statement
        }// end of if else condition
        else{ // if the pin entered doesn't match to any of the two pins passPin and passPin1 then,
            System.out.println("Wrong PIN Entered");
            System.out.println("Enter 1 to return to the menu or 0 to exist:");// prompting the User to enter 1 if they want to return to menu or zero if they want to exit the programme
            int pasChoice=input.nextInt(); //storing the user's choice in variable pasChoice
            switch (pasChoice){ // a switch case statement that calls the method menu when the user has entered 1
                case 1: menu(passPin,passAmount,passPin1,passAmount1);
                case 0:
            }// end of switch
        }// end of else statement
    }// end of withDraw method

    public static void AddMoney(int passPin, long passAmount, int passPin1, long passAmount1){// addMoney method to add money on your ATM
        Scanner input=new Scanner(System.in); // Declaring object input of Scanner class
        int pinEntered; // declaring variable pinEntered as int to store the pin entered by the user
        long cashIn; // variable that will store the amount of money the user wants to add to the account
        System.out.print("Enter your PIN:");
        pinEntered=input.nextInt(); // storing the pin entered by the user in variable pinEntered
        if(pinEntered==passPin){ // if statement comparing if the pin entered is equal to the pin that's already stored in the passPin
            System.out.print("Enter the amount of money you want to add:");
            cashIn=input.nextInt(); // store the Amount entered by the user that they wish to add to their accounts
            passAmount=cashIn+passAmount; // Adding the amount entered by the user to the Amount that is already in the Account
            System.out.println("you have successfully added"+" "+cashIn+"AED"+" "+"your balance is"+" "+passAmount+"AED"); // printing out the New balance and the amount you wanted to enter
            System.out.println("\nEnter 1 to return to the menu or 0 to exist:");
            int pasChoice=input.nextInt(); //storing the user's choice in variable pasChoice
            switch (pasChoice){ // a switch case statement that calls the method menu when the user has entered 1
                case 1: menu(passPin,passAmount,passPin1,passAmount1);
                case 0:
            }// end of switch
        } // end of if condition
        else if (pinEntered==passPin1 && pinEntered!=0){  //if statement comparing if the pin entered is equal to the pin that's already
            // stored in the passPin1 and if the pin entered is not equal to zero if the Pin is equal to zero then that means the is only one account the default account

            System.out.print("Enter the amount of money you want to add:");
            cashIn=input.nextInt(); // store the Amount entered by the user that they wish to add to their accounts
            passAmount1=cashIn+passAmount1;  // Adding the amount entered by the user to the Amount that is already in the Account
            System.out.println("you have successfully added"+" "+cashIn+"AED"+" "+"your balance is"+" "+passAmount1+"AED");  // printing out the New balance and the amount you wanted to enter
            System.out.println("\nEnter 1 to return to the menu or 0 to exist:");
            int pasChoice=input.nextInt();  //storing the user's choice in variable pasChoice
            switch (pasChoice){  // a switch case statement that calls the method menu when the user has entered 1
                case 1: menu(passPin,passAmount,passPin1,passAmount1);
                case 0:
            }// end of switch
        }// end of else if condition
        else{ // if the PIN entered is not equal to passPin and passPin1 then the following lines are executed
            System.out.println("Wrong PIN Entered");
            System.out.println("\nEnter 1 to return to the menu or 0 to exist:");
            int pasChoice=input.nextInt();  //storing the user's choice in variable pasChoice
            switch (pasChoice){  // a switch case statement that calls the method menu when the user has entered 1
                case 1: menu(passPin,passAmount,passPin1,passAmount1);
                case 0:
            }// end of switch

        } // end of the elseIf statement

    }// end of add method

    public static void newOwner(int passPin, long passAmount,int passPin1, long passAmount1){ // method to set a new account holder
        Scanner input =new Scanner(System.in);
        String  fName,sName,Address,Contact,Email;
        int Age,pin;
        long Amount;
        System.out.print("Enter your First Name:");
        fName=input.next(); // storing the first name in the variable fName
        System.out.print("Enter your Second Name:");
        sName=input.next();// storing the second Name in variable sName
        System.out.print("Enter your Address:");
        Address=input.next();// storing the address in variable Address
        System.out.print("Enter your Contact:");
        Contact=input.next();// storing the contact in variable Contact
        System.out.print("Enter your Email:");
        Email=input.next();// storing the email in variable Email
        System.out.print("Enter your Age:");
        Age=input.nextInt(); // storing the age in variable Age
        System.out.print("Enter your PIN:");
        pin=input.nextInt(); //storing the pin in variable pin
        while(pin==0){ // checking if the pin is not equal to zero because by default the value of passPin1 is zero
            // and the pin entered in this new account is stored in passPin1
            // and when the value of passPin1 is zero it means the is no account

            System.out.println("0 is not allowed to be saved as a PIN, Please enter another PIN that is not 0");
            System.out.print("\nEnter your PIN:");
            pin=input.nextInt(); //storing the pin in variable pin
        }// end of while loop
        while(pin==passPin){ // checking if the pin entered is not the same as the pin of the existing default account
            // this is to reduce confusion when it comes to accessing the both accounts
            System.out.println("This Pin is already used by another User, Please Enter a different Pin");
            System.out.print("Enter your new PIN:");
            pin=input.nextInt(); //storing the pin in variable pin
        } // end of while loop
        System.out.print("Re-Enter your PIN:");
        int rPin=input.nextInt(); // store the pin entered for the second time in variable rPin
        while(pin!=rPin){ // if pin entered for the first time is not equal to pin entered for the second time then the following lines are executed
            System.out.println("Both PINs Entered did not match");
            System.out.print("Enter your new PIN Again:");
            pin=input.nextInt();
            System.out.print("Re-Enter your PIN Again:");
            rPin=input.nextInt();
        } // end of while loop
        System.out.print("Enter the Amount:");
        Amount=input.nextInt(); // stores the amount entered by the user in the variable Amount
        AccountHolder N1 = new AccountHolder(fName,sName,Address,Email,Contact,Age,pin,Amount);
        // the purpose of the  above line is to create an object N1 aof class AccountHolder and pass the a parameter to the class constructor
        passPin1=pin; // setting passPin1 to the value of pin
        passAmount1=Amount; // setting passAmount1 to the value of Amount
        N1.printDetails(); // calling the printDetail Method that is in class AccountHolder

        System.out.println("\nEnter 1 to return to the menu or 0 to exist:");
        int pasChoice=input.nextInt();  //storing the user's choice in variable pasChoice
        switch (pasChoice){ // a switch case statement that calls the method menu when the user has entered 1
            case 1: menu(passPin,passAmount,passPin1,passAmount1);
            case 0:
        }// end of switch
    }// end of new owner class

    public static void passChange(int passPin, long passAmount,int passPin1, long passAmount1){ // method to change the account password
        Scanner input=new Scanner(System.in);
        int pinEntered;
        System.out.print("Enter your Current PIN:");
        pinEntered= input.nextInt(); // stores the value of the pin entered by the user
        if (pinEntered==passPin){  // if statement comparing if the pin entered is equal to the pin that's already stored in the passPin
            System.out.print("Enter your new PIN:");
            int nPin=input.nextInt(); // stores new pin entered by the user stored in the variable nPin
            while(nPin==0){  // checking if the pin is not equal to zero because by default the value of passPin1 is zero
                // and if nPin entered is zero and the default value of passPin1 is zero this would cause a confusion when accessing the accounts
                System.out.println(" 0 is not allowed to be saved as a PIN, Please enter another PIN that is not 0");
                System.out.print("Enter your new PIN:");
                nPin=input.nextInt();
            }// end of while loop
            while(nPin==passPin1){// while condition to check if the pin entered is not the same as the pin for another account
                System.out.println("This Pin is already used by another User, Please Enter a different Pin");
                System.out.print("Enter your new PIN:");
                nPin=input.nextInt();
            }// end of while loop
            System.out.print("Re-Enter your PIN:");
            int rPin=input.nextInt();// store the pin entered by the user for the second time
            while(nPin!=rPin){ // loop checking if the pin entered the first time is the same as the pin entered the second time
                System.out.println("Both PINs Entered did not match");
                System.out.print("Enter your new PIN Again:");
                nPin=input.nextInt();
                System.out.print("Re-Enter your PIN Again:");
                rPin=input.nextInt();
            }
            passPin=nPin;// setting passPin to nPin
            System.out.println("Your new pin has been saved");

            System.out.println("\nEnter 1 to return to the menu or 0 to exist:");
            int pasChoice=input.nextInt();  //storing the user's choice in variable pasChoice
            switch (pasChoice){ // a switch case statement that calls the method menu when the user has entered 1
                case 1: menu(passPin,passAmount,passPin1,passAmount1);
                case 0:
            }// end of switch
        }// end of if statement
        else if(pinEntered==passPin1 && pinEntered!=0){   //if statement comparing if the pin entered is equal to the pin that's already
            // stored in the passPin1 and if the pin entered is not equal to zero if the Pin is equal to zero then that means the is only one account the default account
            System.out.print("Enter your new PIN:");
            int nPin=input.nextInt(); //stores new pin entered by the user stored in the variable nPin
            while(nPin==0){  // checking if the pin is not equal to zero because by default the value of passPin1 is zero
                // and the pin entered  is stored in passPin1
                // and when the value of passPin1 is zero it means the is no account
                System.out.println(" 0 is not allowed to be saved as a PIN, Please enter another PIN that is not 0");
                System.out.print("Enter your new PIN:");
                nPin=input.nextInt();
            }// end of the while loop
            while(nPin==passPin){ // while condition to check if the pin entered is not the same as the pin for another account
                System.out.println("This Pin is already used by another User, Please Enter a different Pin");
                System.out.print("Enter your new PIN:");
                nPin=input.nextInt();
            }// end of while loop
            System.out.print("Re-Enter your PIN:");
            int rPin=input.nextInt(); // store the pin entered by the user for the second time
            while(nPin!=rPin){ // if both the Pins entered are not equal then the following lin is executed
                System.out.println("Both PINs Entered did not match");
                System.out.print("Enter your new PIN Again:");
                nPin=input.nextInt();
                System.out.print("Re-Enter your PIN Again:");
                rPin=input.nextInt();
            }// end of the while
            passPin1=nPin;// setting passPin1 to the value of nPin
            System.out.println("Your new pin has been saved");

            System.out.println("\nEnter 1 to return to the menu or 0 to exist:");
            int pasChoice=input.nextInt(); //stores new pin entered by the user stored in the variable nPin
            switch (pasChoice){ // a switch case statement that calls the method menu when the user has entered 1
                case 1: menu(passPin,passAmount,passPin1,passAmount1);
                case 0:
            }// end of switch
        }// end of if else condition
        else{ // when both pins entered are wrong the the following lines are executed
            System.out.println("Wrong pin");

            System.out.println("\nEnter 1 to return to the menu or 0 to return to menu:");
            int pasChoice=input.nextInt(); //stores new pin entered by the user stored in the variable nPin
            switch (pasChoice){ // a switch case statement that calls the method menu when the user has entered 1
                case 1: menu(passPin,passAmount,passPin1,passAmount1);
                case 0:
            }// end of switch

        }// end of else statement
    }// end of method passChange

    public static void balanceDisplay(int passPin, long passAmount,int passPin1, long passAmount1){ // method to display the account balance
        int pinEntered;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your PIN:");
        pinEntered= input.nextInt(); // stores the pin entered by the user

        if (pinEntered==passPin){ // if statement comparing if the pin entered is equal to the pin that's already stored in the passPin
            System.out.println("Your Balance is:"+" "+passAmount+"AED.");

            System.out.println("\nEnter 1 to return to the menu or 0 to return to menu:"); // prompting the User to enter 1 if they want to return to menu or zero if they want to exit the programme
            int pasChoice=input.nextInt();// store the choice entered by the user
            switch (pasChoice){ // a switch case statement that calls the method menu when the user has entered 1
                case 1: menu(passPin,passAmount,passPin1,passAmount1);
                case 0:
            }// end of switch
        }// end of the if statement
        else if (pinEntered==passPin1 && pinEntered!=0){ //if statement comparing if the pin entered is equal to the pin that's already stored in the passPin1 and if the pin entered is not equal to zero
            System.out.println("Your Balance is:"+" "+passAmount1+"AED.");

            System.out.println("\nEnter 1 to return to the menu or 0 to return to menu:"); // prompting the User to enter 1 if they want to return to menu or zero if they want to exit the programme
            int pasChoice=input.nextInt();// stores the choice entered by the user
            switch (pasChoice){ // a switch case statement that calls the method menu when the user has entered 1
                case 1: menu(passPin,passAmount,passPin1,passAmount1);
                case 0:
            }// end of switch
        }// end of the if else statement
        else{ // if the password entered doesn't match passPin and passPin1 then the following lines are excuted
            System.out.println("Wrong PIN Entered");

            System.out.println("\nEnter 1 to return to the menu or 0 to return to menu:"); // prompting the User to enter 1 if they want to return to menu or zero if they want to exit the programme
            int pasChoice=input.nextInt(); // stores the choice entered by the user
            switch (pasChoice){ // a switch case statement that calls the method menu when the user has entered 1
                case 1: menu(passPin,passAmount,passPin1,passAmount1);
                case 0:
            }// end of switch
        }// end of the else statement
    }// end of the balanceDisplay method
}// end of AtmApplication class
