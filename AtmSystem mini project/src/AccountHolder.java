public class AccountHolder {
    String fName,sName, Email, Address, Contact;
    int Age, pin;
    long Amount;
    AccountHolder(){
        fName="David";
        sName="Hitimana";
        Email="david@gmail.com";
        Address="Dubai";
        Contact="+250789805811";
        Age=20;
        pin=123;
        Amount=5000000;
    }
    AccountHolder(String fNames,String sNames, String Addresses, String Emails, String Contacts, int Ages, int pins, long Amounts){
        fName=fNames;
        sName=sNames;
        Email=Emails;
        Address=Addresses;
        Contact=Contacts;
        Age=Ages;
        pin=pins;
        Amount=Amounts;
    }
    public void printDetails(){
        System.out.println("\n Records you Entered");
        System.out.println("\nName:"+" "+fName+" "+sName);
        System.out.println("Email:"+" "+Email);
        System.out.println("Address:"+" "+Address);
        System.out.println("Contact:"+" "+Contact);
        System.out.println("Age:"+" "+Age);
        System.out.println("pin:"+" "+pin);
        System.out.println("Amount:"+" "+Amount);
    }

}
