package pkg;

import java.io.IOException;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class CourseListController 
{
    @FXML private TableView<Course> courseTable;
    @FXML private TableColumn<Course, String> courseNameColumn;
    @FXML private TableColumn<Course, String> professorNameColumn;
    @FXML private TableColumn<Course, Double> midtermColumn;
    @FXML private TableColumn<Course, Double> finalExamColumn;
    @FXML private TableColumn<Course, Double> attendanceColumn;
    @FXML private TableColumn<Course, Double> assignmentsColumn;
    @FXML private TableColumn<Course, Double> quizzesColumn;

	//method that sends the user back to the main menu (whether it's the professor page or the student page)
	public void switchToMainMenu(ActionEvent event) throws IOException
	{		
		Parent root = FXMLLoader.load(getClass().getResource("student.fxml")); //get login fxml
		Stage stg0 = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene studPage = new Scene(root, 600, 400); //create login page
		stg0.setScene(studPage); //apply login page
		stg0.show(); //display login page
	}

	public void displayCourseInfo() 
	{
		//clear table columns before adding them (to prevent duplicate columns)
		courseTable.getColumns().clear();
		
		//add data fields from course constructor to each column
		courseNameColumn.setCellValueFactory(cellData -> cellData.getValue().getCourseNameProperty());
		professorNameColumn.setCellValueFactory(cellData -> cellData.getValue().getProfNameProperty());
		midtermColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getMidtermExamWeight()*100).asObject());
		finalExamColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getFinalExamWeight()*100).asObject());
		attendanceColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getAttendanceWeight()*100).asObject());
		assignmentsColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getAssignmentsWeight()*100).asObject());
		quizzesColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getQuizweight()*100).asObject());
		courseTable.setItems(Database.courseData);
		
		//add each column to the table individually (inconvenient but it works)
		courseTable.getColumns().add(courseNameColumn);
		courseTable.getColumns().add(professorNameColumn);
		courseTable.getColumns().add(midtermColumn);
		courseTable.getColumns().add(finalExamColumn);
		courseTable.getColumns().add(attendanceColumn);
		courseTable.getColumns().add(assignmentsColumn);
		courseTable.getColumns().add(quizzesColumn);
		
	}
}
