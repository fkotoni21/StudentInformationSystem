package pkg;

import java.io.IOException;
import java.text.ParseException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController 
{		
	//method that sends the user to the personal info page
	public void switchToPersonInfo(ActionEvent event) throws IOException, ParseException
	{
		FXMLLoader loader = new FXMLLoader((getClass().getResource("personal.fxml"))); //get loader
		Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow(); //create stage object
		Scene personPage = new Scene(loader.load(), 600, 400); //create personal page
		
		PersonInfoController controller = loader.getController(); //get controller from loader
		controller.displayPersonInfo(); //function call (no static methods required)
		stg2.setScene(personPage); //apply personal page
		stg2.show(); //display personal page		
	}
	
	//method that sends the student to the course selection page
	public void switchToCourseSelect(ActionEvent event) throws IOException, ParseException
	{
		FXMLLoader loader = new FXMLLoader((getClass().getResource("courseselect.fxml"))); //get loader
		Stage stg3 = (Stage)((Node)event.getSource()).getScene().getWindow(); //create stage object
		Scene courseSelect = new Scene(loader.load(), 900, 400); //create course select page
		
		CourseListController controller = loader.getController();
        controller.displayCourseInfo();
		stg3.setScene(courseSelect); //apply course select page
		stg3.show(); //display course select page		
	}
	
	//method that sends the professor to the student list page
	public void switchToStudList(ActionEvent event) throws IOException, ParseException
	{
		FXMLLoader loader = new FXMLLoader((getClass().getResource("studentlist.fxml"))); //get loader
		Stage stg4 = (Stage)((Node)event.getSource()).getScene().getWindow(); //create stage object
		Scene studListPage = new Scene(loader.load(), 900, 400); //create personal page
		
		StudentListController controller = loader.getController();
        controller.displayStudList();
		stg4.setScene(studListPage); //apply student list page
		stg4.show(); //display student list page		
	}
	
	//method that sends the user back to the login page, whether they're a professor or not
	public void userLogOut(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml")); //get login fxml
		Stage stg0 = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene studPage = new Scene(root, 600, 400); //create login page
		stg0.setScene(studPage); //apply login page
		stg0.show(); //display login page
		LoginController.sessionID = 0; //reset session ID back to zero
		Database.profOrNot = true; //reset isProf boolean back to true
	}
}
