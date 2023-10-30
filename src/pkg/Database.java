package pkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database 
{
	public static ArrayList<Person> personList = new ArrayList<>();
	public static ObservableList<Student> studList = FXCollections.observableArrayList();
	public static ObservableList<Course> courseData = FXCollections.observableArrayList();

	static boolean profOrNot = true;
	
	public static void addCourseData()
	{
		courseData.add(new Course("Chemistry I", "Walter White", 0.3, 0.5, 0, 0.2, 0));
		courseData.add(new Course("Spanish I", "Lalo Salamanca", 0.3, 0.5, 0.1, 0.1, 0));
		courseData.add(new Course("German I", "Werner Ziegler"));
		courseData.add(new Course("Business", "Jesse Pinkman", 0.1, 0.6, 0.1, 0, 0.2));
		courseData.add(new Course("American History", "Mike Ehrmantraut", 0.2, 0.6, 0.1, 0.1, 0));
	}
	
	public static void createLists() throws ParseException, FileNotFoundException 
	{
		File personalInfo = new File("PersonalInfo.txt");
		if (!personalInfo.exists() || personalInfo.length()==0)
			System.exit(1);
		
		//common person attributes
		int personID = 0; int listIndex=0; int studentID = 0;
		String fName = "N/A", lName = "N/A", birthplace = "N/A", birthday = "N/A"; 
		Date birthDate = null; 
		
		Scanner sc = new Scanner(personalInfo); //create scanner
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //create date format
		
		while (sc.hasNext()) 
		{	
			//scan data fields from file until space (default delimiter) is encountered
			fName = sc.next();
			lName = sc.next();
			birthday = sc.next();
			birthplace = sc.next();
			
			//create Date object for birthday, then make a temporary Student object
			birthDate = (Date)formatter.parse(birthday);
			
			//check if the person in question is a professor - if not, add him to the student list
			if (profOrNot==false)
			{
				studList.add(listIndex, new Student(personID, fName, lName, birthDate, birthplace, profOrNot));
				studList.get(listIndex).setPersonID(studentID); //overwrite person ID with student ID
				studentID++; //increment student ID
			}
			//add person to person list
			personList.add(listIndex, new Person(personID, fName, lName, birthDate, birthplace, profOrNot));
			//increment list index
			listIndex++; personID++; //increment person ID
		}
		sc.close(); //scanner
	}
}
