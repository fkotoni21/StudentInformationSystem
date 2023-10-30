package pkg;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LoginController
{	
	//data fields for login info (from text fields)
	private String finalEmail;
	private String finalPwd;
	protected static int sessionID = 0;
	//text fields for login info
	@FXML private TextField emailField;
	@FXML private PasswordField pwdField;
	File loginInfo = new File("LoginInfo.txt"); //create file object
	
	public void checkLoginInfo(ActionEvent event) throws IOException
	{
		//overwrite data fields with whatever text is on both text fields
		finalEmail = emailField.getText();
		finalPwd = pwdField.getText();
		
		String currEmail, currPwd; //email and password from file
		Alert msg = new Alert(AlertType.NONE); //create alert object (with alert type set to none)
		
		//check if file DOESN'T exist (or is empty), then display error message and exit
		if (!loginInfo.exists() || loginInfo.length()==0)
		{
			//set error message properties
			msg.setContentText("Text file containing log-in info is either empty or not available."
					+ "\nTry again with a proper text file.");
			msg.setAlertType(AlertType.ERROR); msg.setTitle("No Login Info Found"); msg.show();
		}

		//check if the user has not entered an email or password
		if (finalEmail==null || finalPwd==null)
			return;

		Scanner sc = new Scanner(loginInfo); //create scanner for email and passwords
		
		while (sc.hasNext()) 
		{	
			//scan data fields from file until space (default delimiter) is encountered
			currEmail = sc.next();
			currPwd = sc.next();

			//compare login info from file with login info from user
			if (!currEmail.equals(finalEmail) || !currPwd.equals(finalPwd))
			{
				sessionID++;
				continue;
			}
			else //switch to student page if the login data is correct
				switchToNextStage(event); return;
		}
		
		//display error message if the given inputs don't match what's in the login info
		msg.setContentText("Incorrect email or password. Try again!");
		msg.setAlertType(AlertType.ERROR); msg.setTitle("Incorrect Input"); msg.show();
		LoginController.sessionID = 0; //reset session ID back to zero
		Database.profOrNot = true; //reset isProf boolean back to true
	}
	
	//method that checks the given email address and decides if the user is taken to the student page or the professor page
	public void switchToNextStage(ActionEvent event) throws IOException
	{
		String fxmlFileName = "professor.fxml"; //get professor fxml by default
		
		if (!isProfByEmail())
		{
			fxmlFileName = "student.fxml"; //set source to student fxml if the email contains numbers
			Database.profOrNot = false; //set isProf boolean to false
		}
		
		Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
		Stage stg1 = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene studPage = new Scene(root, 600, 400); //create student page
		stg1.setScene(studPage); //apply student page
		stg1.show(); //display student page
	}
	
	//method that checks if the user is a professor or student based on their email
	public boolean isProfByEmail()
	{
		if (finalEmail.matches(".*[0-9].*"))
			return false;
		return true;
	}
}
