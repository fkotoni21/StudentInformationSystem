package pkg;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Course 
{
	//data fields for weight percentages
	double midtermExamWeight;
	double finalExamWeight;
	double attendanceWeight;
	double assignmentsWeight;
	double quizweight;
	//string properties for general course information
	SimpleStringProperty profNameProperty;
	SimpleStringProperty courseNameProperty;
	SimpleDoubleProperty midtermProperty;
	SimpleDoubleProperty finalExamProperty;
	SimpleDoubleProperty attendanceProperty;
	SimpleDoubleProperty assignmentsProperty;
	SimpleDoubleProperty quizProperty;
	//boolean parameter that determines if the student has taken the course or not
	boolean isSelected = false;
	
	//default constructor (midterm and final exams only)
	public Course(String courseName, String profName)
	{		
		midtermExamWeight = 0.4;
		finalExamWeight = 0.6;
		this.courseNameProperty = new SimpleStringProperty(courseName);
		this.profNameProperty = new SimpleStringProperty(profName);
	}
	
	//constructor that takes all weight percentages as parameters
	public Course(String courseName, String profName, double midtermExamWeight, double finalExamWeight, 
	double attendanceWeight, double assignmentsWeight, double quizweight)
	{
		this.courseNameProperty = new SimpleStringProperty(courseName);
		this.profNameProperty = new SimpleStringProperty(profName);
		this.midtermExamWeight = midtermExamWeight;
		this.finalExamWeight = finalExamWeight;
		this.attendanceWeight = attendanceWeight;
		this.assignmentsWeight = assignmentsWeight;
		this.quizweight = quizweight;
	}
	
	//getters and setters for course/professor names
    public String getCourseName() 
    {
        return courseNameProperty.get();
    }
    public void setCourseName(String courseName) 
    {
    	courseNameProperty.set(courseName);
    }
    public String getProfName() 
    {
        return profNameProperty.get();
    }
    
    public void setLastName(String profName) 
    {
    	profNameProperty.set(profName);
    }
    
    //getters and setters for string properties
	public SimpleStringProperty getProfNameProperty() 
	{
		return profNameProperty;
	}
	public void setProfNameProperty(SimpleStringProperty profNameProperty) 
	{
		this.profNameProperty = profNameProperty;
	}
	public SimpleStringProperty getCourseNameProperty() 
	{
		return courseNameProperty;
	}
	public void setCourseNameProperty(SimpleStringProperty courseNameProperty) 
	{
		this.courseNameProperty = courseNameProperty;
	}
	//getters and setters for weight percentages
	public double getMidtermExamWeight() 
	{
		return midtermExamWeight;
	}
	public void setMidtermExamWeight(double midtermExamWeight) 
	{
		this.midtermExamWeight = midtermExamWeight;
	}
	public double getFinalExamWeight() 
	{
		return finalExamWeight;
	}
	public void setFinalExamWeight(double finalExamWeight) 
	{
		this.finalExamWeight = finalExamWeight;
	}
	public double getAttendanceWeight() 
	{
		return attendanceWeight;
	}
	public void setAttendanceWeight(double attendanceWeight) 
	{
		this.attendanceWeight = attendanceWeight;
	}
	public double getAssignmentsWeight() 
	{
		return assignmentsWeight;
	}
	public void setAssignmentsWeight(double assignmentsWeight) 
	{
		this.assignmentsWeight = assignmentsWeight;
	}
	public double getQuizweight() 
	{
		return quizweight;
	}
	public void setQuizweight(double quizweight) 
	{
		this.quizweight = quizweight;
	}
	public boolean isSelected() 
	{
		return isSelected;
	}
	public void setSelected(boolean isSelected) 
	{
		this.isSelected = isSelected;
	}
}