
import java.io.Serializable;

public class Contact  implements Serializable {

    private String name; // Stores name of Contact
    private int age;  // Stores age of Contact
    private String phonenumber; // Stores phone number of contact
    private String address;
    private String email;
    private String Company;

    // Creates Contact object based on parameters.
    public Contact(String n, int a, String p, String ad, String em, String comp) {
		setName(n);
		setAge(a);
		setPhonenumber(p);
		setAddress(ad);
                setEmail(em);
                setCompany(comp);
                
    }
    // Implements the passing of Contact's birthday.
    public void Birthday() {
		age++;
    }

    // Returns the name of a Contact
    public String getName() {
		return name;
    }

    // Returns the age of a Contact
    public int getAge() {
		return age;
    }

    // Returns the phone number of a Contact
    public String getPhonenumber() {
		return phonenumber;
    }

    // Prints all information about a contact out to terminal.
    public void printContact() {
		System.out.print("Name: " + getName() + " Age: " + getAge() + " Phone#: " + getPhonenumber());
                System.out.print(" Address: " + getAddress() + " Email: " + getEmail() + "Company Name: "+ getCompany() +"\n");
		
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String ad) {
        address = ad;
    }

    /**
     * @param n the name to set
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * @param a the age to set
     */
    public void setAge(int a) {
        age = a;
    }

    /**
     * @param p the phone number to set
     */
    public void setPhonenumber(String p) {
        phonenumber = p;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the Company
     */
    public String getCompany() {
        return Company;
    }

    /**
     * @param Company the Company to set
     */
    public void setCompany(String Company) {
        this.Company = Company;
    }


}
