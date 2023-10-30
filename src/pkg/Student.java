package pkg;

import java.util.Date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student extends Person 
{
	private int personID;

	public Student(int personID, String firstName, String lastName, Date birthDate, String birthplace, boolean isProf)
	{
		super(personID, firstName, lastName, birthDate, birthplace, isProf);
		this.personID = personID;
		this.firstNameProperty = new SimpleStringProperty(super.getFirstName());
		this.lastNameProperty = new SimpleStringProperty(super.getLastName());
		this.birthdayProperty = new SimpleStringProperty(super.getBirthDate().toString());
		this.birthplaceProperty = new SimpleStringProperty(super.getBirthplace());
		//this.coursesProperty = new SimpleIntegerProperty(getCoursesTaken());
		
	}
	//string properties
	SimpleIntegerProperty studIDProperty;
	SimpleStringProperty firstNameProperty;
	SimpleStringProperty lastNameProperty;
	SimpleStringProperty birthdayProperty;
	SimpleStringProperty birthplaceProperty;
	SimpleIntegerProperty coursesProperty;
	
	//getters and setters for course/professor names
    public int getStudentID() 
    {
        return personID;
    }
    public void setStudentID(int personID) 
    {
    	this.personID = personID;
    }
    public String getFirstName() 
    {
        return firstNameProperty.get();
    }
    public void setFirstName(String firstName) 
    {
    	firstNameProperty.set(firstName);
    }
    public String getLastName() 
    {
        return lastNameProperty.get();
    }
    public void setLastName(String lastName) 
    {
    	lastNameProperty.set(lastName);
    }
    public String getBirthday() 
    {
        return birthdayProperty.get();
    }
    public void setBirthday(String birthday) 
    {
    	birthdayProperty.set(birthday);
    }    
    public String getBirthplace() 
    {
        return birthplaceProperty.get();
    }
    public void setBirthplace(String birthplace) 
    {
    	birthplaceProperty.set(birthplace);
    }
    public int getCoursesTaken() 
    {
        return coursesProperty.get();
    }
    public void setCoursesTaken(int coursesTaken) 
    {
    	coursesProperty.set(coursesTaken);
    }
	public SimpleIntegerProperty getStudIDProperty() {
		return studIDProperty;
	}
	public void setStudIDProperty(SimpleIntegerProperty studIDProperty) {
		this.studIDProperty = studIDProperty;
	}
	public SimpleStringProperty getFirstNameProperty() {
		return firstNameProperty;
	}
	public void setFirstNameProperty(SimpleStringProperty firstNameProperty) {
		this.firstNameProperty = firstNameProperty;
	}
	public SimpleStringProperty getLastNameProperty() {
		return lastNameProperty;
	}
	public void setLastNameProperty(SimpleStringProperty lastNameProperty) {
		this.lastNameProperty = lastNameProperty;
	}
	public SimpleStringProperty getBirthdayProperty() {
		return birthdayProperty;
	}
	public void setBirthdayProperty(SimpleStringProperty birthdayProperty) {
		this.birthdayProperty = birthdayProperty;
	}
	public SimpleStringProperty getBirthplaceProperty() {
		return birthplaceProperty;
	}
	public void setBirthplaceProperty(SimpleStringProperty birthplaceProperty) {
		this.birthplaceProperty = birthplaceProperty;
	}
	public SimpleIntegerProperty getCoursesProperty() {
		return coursesProperty;
	}
	public void setCoursesProperty(SimpleIntegerProperty coursesProperty) {
		this.coursesProperty = coursesProperty;
	}
}
