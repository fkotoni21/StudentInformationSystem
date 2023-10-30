package pkg;

import java.io.IOException;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class StudentListController 
{
    @FXML private TableView<Student> studentTable;
    @FXML private TableColumn<Student, Integer> studIDColumn;
    @FXML private TableColumn<Student, String> firstNameColumn;
    @FXML private TableColumn<Student, String> lastNameColumn;
    @FXML private TableColumn<Student, String> birthdayColumn;
    @FXML private TableColumn<Student, String> birthplaceColumn;
    @FXML private TableColumn<Student, Integer> coursesColumn;
    
	//method that sends the user back to the main menu (whether it's the professor page or the student page)
	public void switchToMainMenu(ActionEvent event) throws IOException
	{		
		Parent root = FXMLLoader.load(getClass().getResource("professor.fxml")); //get login fxml
		Stage stg0 = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene studPage = new Scene(root, 600, 400); //create login page
		stg0.setScene(studPage); //apply login page
		stg0.show(); //display login page
	}

	public void displayStudList() 
	{
		//clear table columns before adding them (to prevent duplicate columns)
		studentTable.getColumns().clear();
		
		//add data fields from course constructor to each column
		studIDColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getStudentID()).asObject());
		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProperty());
		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getLastNameProperty());
		birthdayColumn.setCellValueFactory(cellData -> cellData.getValue().getBirthdayProperty());
		birthplaceColumn.setCellValueFactory(cellData -> cellData.getValue().getBirthplaceProperty());
		studentTable.setItems(Database.studList);
		//coursesColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCoursesTaken()).asObject());
		
		
		//add each column to the table individually (inconvenient but it works)
		studentTable.getColumns().add(studIDColumn);
		studentTable.getColumns().add(firstNameColumn);
		studentTable.getColumns().add(lastNameColumn);
		studentTable.getColumns().add(birthdayColumn);
		studentTable.getColumns().add(birthplaceColumn);
		//studentTable.getColumns().add(coursesColumn);
	}

}
