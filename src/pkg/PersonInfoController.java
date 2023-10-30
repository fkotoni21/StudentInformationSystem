package pkg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonInfoController
{
	//text fields for personal info
	@FXML private TextField personIDField;
	@FXML private TextField firstNameField;
	@FXML private TextField lastNameField;
	@FXML private TextField birthdayField;
	@FXML private TextField birthplaceField;
	//index of current person
	int currIndex;
	
	//method that takes the personal info of the chosen student and displays it on screen
	public void displayPersonInfo() throws FileNotFoundException, ParseException
	{
		int i=0;
		//for each person in the database's student list...
		for (Person p: Database.personList)
		{
			//check if the current session ID belongs to them
			if (LoginController.sessionID == p.getPersonID())
			{
				//display personal info on each label
				personIDField.setText(Integer.toString(p.getPersonID()));
				firstNameField.setText(p.getFirstName());
				lastNameField.setText(p.getLastName());
				birthplaceField.setText(p.getBirthplace());

				//create date object, then a date format for it (without time, only day month and year)
				Date dateWithNoTime = p.getBirthDate();
				DateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
				//display dateWithNoTime on birthday text field
				birthdayField.setText(formatter.format(dateWithNoTime.getTime()));
				//keep track of current index
				currIndex=i;
			}
		}
	}
	
	//method that sends the user back to the main menu (whether it's the professor page or the student page)
	public void switchToMainMenu(ActionEvent event) throws IOException
	{		
		String fxmlFileName = "professor.fxml"; //get professor fxml by default
	
		//for each person in the database's student list...
		for (int i=0; i<Database.personList.size(); i++)
		{
			//based on their current index, check if said person is a student
			if (Database.profOrNot == false)
				fxmlFileName = "student.fxml";
		}

		Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName)); //get login fxml
		Stage stg0 = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene studPage = new Scene(root, 600, 400); //create login page
		stg0.setScene(studPage); //apply login page
		stg0.show(); //display login page
	}
}
