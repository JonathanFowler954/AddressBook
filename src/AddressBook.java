
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    private ArrayList<Contact> friends; // An array of Contacts - each stores info for one friend

    // Create an empty AddressBook
    public AddressBook() {
        friends = new ArrayList<>();
    }

    // Add a contact that's passed in as a parameter.
    public void addContact(Contact c) {
        friends.add(c);

    }
    
    public Contact getContactFromList(int i)
    {
        return friends.get(i);
    }

    // Print out info on all contacts using method Contact class.
    public void printContacts() {
        for (Contact friend : friends) {
            friend.printContact();
        }
    }

    // Returns the number of friends currently in AddressBook
    public int numContacts() {
        return friends.size();
    }

    // Returns int as long as there is a Contact with name s exists corresponding
    // to which place in the array friends the Contact is stored. Returns -1
    // otherwise.
    public int searchContactPlace(String s) {
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).getName().equals(s)) {
                return i;
            }
        }
        return -1;
    }

    // Deletes a contact with name s, if one is in the AddressBook.
    public void deleteContact(String s) {
        int c = searchContactPlace(s);
        friends.remove(c);
    }
    
    // Update a Contact with name s, if one is in the address book
    public void updateContact(String s)
    {
        int c = searchContactPlace(s);
        Scanner keyboard = new Scanner(System.in);
        
        keyboard.nextLine(); //Clear the buffer
                //Reads in all appropriate information.");
                System.out.println("Enter your friend\'s name:");
                String name = keyboard.nextLine();
                System.out.println("Enter their age.");
                int age = keyboard.nextInt();
                System.out.println("Enter their phone number.");
                String number = keyboard.nextLine();
                    keyboard.nextLine();
                System.out.println("Enter their full address.");
                String addr = keyboard.nextLine();
                System.out.println("Enter their email address.");
                String em = keyboard.nextLine();
                System.out.println("Enter their company name.");
                String comp = keyboard.nextLine();

		// Uses information to create Contact object, which is
                // a parameter to the addContact method.
                Contact newContact= new Contact(name, age, number, addr, em, comp);
        friends.set(c, newContact);
    }
    
    /**
     *
     * @param name
     * @param age
     * @param number
     * @param addr
     * @param place
     */
    public void updateContact(String name, int age, String number, String addr, String em, String comp, int place)
    {
        Contact newContact= new Contact(name, age, number, addr, em, comp);
        friends.set(place, newContact);
    }
    
    //Read from File
    public AddressBook readAddressBook() throws IOException
    {
        AddressBook tmpAddressBook = new AddressBook();
        ArrayList<Contact> arraylist= new ArrayList<>();
        try
        {
            FileInputStream fis = new FileInputStream("myfile");
            ObjectInputStream ois = new ObjectInputStream(fis);
            arraylist = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        }
        catch(IOException ioe)
        {
             ioe.printStackTrace();
        }
        
        catch(ClassNotFoundException c)
        {
             System.out.println("Class not found");
             c.printStackTrace();
        }
        tmpAddressBook.friends = arraylist;
        tmpAddressBook.printContacts();
        
        return tmpAddressBook;
        
    }
    //Output to file
    public void outputAddressBook() throws IOException
    {
    try
        {
        FileOutputStream fos= new FileOutputStream("myfile");
        ObjectOutputStream oos= new ObjectOutputStream(fos);
        oos.writeObject(friends);
        oos.close();
        fos.close();
        
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error with specified file") ;
            e.printStackTrace();
        }
    }
    
    //  Created for logic Testing prior to UI implementation
    
/*    public static void main(String[] args) throws IOException {

        Scanner keyboard = new Scanner(System.in);

        // Instantiate AddressBook object
        AddressBook blackbook = new AddressBook();

        // Menu driven loop.
        menu();
        int choice = keyboard.nextInt();
        while (choice != 7) {

            // Only adds contact if there is room in AddressBook blackbook.
            if (choice == 1) {
                keyboard.nextLine(); //Clear the buffer
                //Reads in all appropriate information.");
                System.out.println("Enter your friend\'s name:");
                String name = keyboard.nextLine();
                System.out.println("Enter their age.");
                int age = keyboard.nextInt();
                    keyboard.nextLine();
                System.out.println("Enter their phone number.");
                String number = keyboard.nextLine();
                System.out.println("Enter their full address.");
                String addr = keyboard.nextLine();

		    	// Uses information to create Contact object, which is
                // a parameter to the addContact method.
                blackbook.addContact(new Contact(name, age, number, addr));

            } // Implements rest of the choices by calling appropriate AddressBook methods on blackbook.
            else if (choice == 2) {

                System.out.println("What is the name of the contact you want to delete?");
                String name = keyboard.next();
                blackbook.deleteContact(name);
            } else if (choice == 3) {
                System.out.println("You have " + blackbook.numContacts() + " contacts.");
            } else if (choice == 4) {
                blackbook.printContacts();
            } else if (choice == 5) {
                blackbook.outputAddressBook();
            } else if (choice == 6){
                blackbook = blackbook.readAddressBook();
            } else if (choice != 7) {
                System.out.println("Sorry, that was an invalid menu choice, try again.");
            }
            menu();
            choice = keyboard.nextInt();
        }

    }

    public static void menu() {
        System.out.println("1.Add a new contact to your address book.");
        System.out.println("2.Delete a contact from your address book.");
        System.out.println("3.Print out the number of contacts you have.");
        System.out.println("4.Print out information of all of your contacts.");
        System.out.println("5.Output Address Book to file.");
        System.out.println("6.Read Address Book from file. ");
        System.out.println("7.Quit.");
        System.out.println("Enter your menu choice:");
    }*/
}
