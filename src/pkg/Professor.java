package pkg;

import java.util.Date;

public class Professor extends Person 
{
	public Professor(int personID, String firstName, String lastName, Date birthday, String birthplace, boolean isProf) 
	{
		super(personID, firstName, lastName, birthday, birthplace, isProf);
	}
}
