/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AddressBookUIController implements Initializable {
    @FXML
    private MenuButton fileButton;
    @FXML
    private MenuItem openFileButton;
    @FXML
    private MenuItem saveButtonFile;
    @FXML
    private MenuItem exitButton;
    private TextField searchField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField ageTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private TextField workTextField;
    @FXML
    private Button deleteContactButton;
    @FXML
    private Button saveButton;
    
    private AddressBook blackbook = new AddressBook();
    @FXML
    private MenuItem PrintContactsTermButton;
    @FXML
    private TextField searchTextField;
    @FXML
    private Button SearchButton;
    @FXML
    private Label outputLabel;
    
    private int placeInLine = -1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void PrintContactList_Select(ActionEvent event) 
    {
        if(!(blackbook.numContacts()>0))
            System.out.println("No Contacts to Print");
        
        blackbook.printContacts();
    }

    @FXML
    private void OpenAddressBook_Select(ActionEvent event)
    {
        try {
            blackbook = blackbook.readAddressBook();
        } catch (IOException ex) {
            Logger.getLogger(AddressBookUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void SaveAddressBooktoFile_Select(ActionEvent event)
    {
        try {
            blackbook.outputAddressBook();
        } catch (IOException ex) {
            Logger.getLogger(AddressBookUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AddContactButton_Click(ActionEvent event) 
    {
        // if contact exits update otherwise add
        int place = blackbook.searchContactPlace(searchTextField.getText());
        
        
        
        if(place != -1)
        {
            blackbook.updateContact( nameTextField.getText(), Integer.parseInt( ageTextField.getText() )
                , phoneNumberTextField.getText(), addressTextField.getText(), emailTextField.getText(), 
                workTextField.getText(), place );
        } else blackbook.addContact(new Contact(nameTextField.getText(), Integer.parseInt( ageTextField.getText() )
                , phoneNumberTextField.getText(), addressTextField.getText(), emailTextField.getText(), workTextField.getText() ));
        
        ClearTextFields();
    }

    
    private void ClearTextFields()
    {
        searchTextField.setText("");
        nameTextField.setText("");
        addressTextField.setText("");
        ageTextField.setText("");
        emailTextField.setText("");
        phoneNumberTextField.setText("");
        workTextField.setText("");
        outputLabel.setText("");
    }

    @FXML
    private void SearchForContact(ActionEvent event) 
    {
        Contact tmpContact;
        int place = blackbook.searchContactPlace(searchTextField.getText());
        setPlaceInLine(place);
        
        if(place != -1)
        {
            outputLabel.setText("Contact is index " + getPlaceInLine() +" in the array.");
                        
            tmpContact = blackbook.getContactFromList(place);
            nameTextField.setText(tmpContact.getName());
            addressTextField.setText(tmpContact.getAddress());
            ageTextField.setText(String.valueOf(tmpContact.getAge()));
            emailTextField.setText(tmpContact.getEmail());
            phoneNumberTextField.setText(tmpContact.getPhonenumber());
            workTextField.setText(tmpContact.getCompany());
                        
        } else outputLabel.setText("Contact not found.");
            
    }

    @FXML
    private void DeleteDisplayedContact_Click(ActionEvent event) 
    {
        blackbook.deleteContact(nameTextField.getText());
        ClearTextFields();   
    }

    /**
     * @return the placeInLine
     */
    public int getPlaceInLine() {
        return placeInLine;
    }

    /**
     * @param placeInLine the placeInLine to set
     */
    public void setPlaceInLine(int placeInLine) {
        this.placeInLine = placeInLine;
    }
    
    
}
