package pkg;

import java.io.FileNotFoundException;
import java.text.ParseException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application
{	
	public static void main(String[] args) throws FileNotFoundException, ParseException
	{
		Database.createLists();
		Database.addCourseData();
		launch();
	}
	
	public void start(Stage stg0) throws Exception 
	{
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml")); //get login interface (login.fxml) from bin folder 
		Scene login = new Scene(root, 600, 400); //set window size to 600x400
		stg0.setResizable(false); //disable maximize button
		stg0.setTitle("Student Information System"); //set window title
		stg0.setScene(login); //apply login scene
		stg0.show(); //display what is currently on the stage
	}
}
