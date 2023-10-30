package pkg;

import java.util.Date;

public class Person 
{
	//data fields
	private int personID;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String birthplace;
	private boolean isProf;
	
	/** constructor with arguments */
	public Person(int personID, String firstName, String lastName, Date birthDate, String birthplace, boolean isProf)
	{
		this.personID = personID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.birthplace = birthplace;
		this.setProf(isProf);
	}
	
	/** getters and setters */
	public int getPersonID() 
	{
		return personID;
	}
	public void setPersonID(int personID) 
	{
		this.personID = personID;
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	public Date getBirthDate() 
	{
		return birthDate;
	}
	public void setBirthDate(Date birthDate) 
	{
		this.birthDate = birthDate;
	}
	
	public String getBirthplace() 
	{
		return birthplace;
	}
	public void setBirthplace(String birthplace) 
	{
		this.birthplace = birthplace;
	}
	
	public boolean getProf() 
	{
		return isProf;
	}

	public void setProf(boolean isProf) 
	{
		this.isProf = isProf;
	}
}
