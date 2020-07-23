//Description: Providing basic information of any person, which is first and last name.
//Name: Ashok Meyyappan

public class Person 
{
	//Private Objects
	private String firstName;
	private String lastName;
	
	//Default Constructor
	Person() 
	{
		firstName = " ";
		lastName = " ";
	} 
	
	//Constructor
	Person(String fn, String ln) 
	{
		firstName = fn;
		lastName = ln;
	}
	
	//Setters and Getters
	public void setFirstName(String fn) {firstName = fn;}
	public String getFirstName() {return firstName;}
	public void setLastname(String ln) {lastName = ln;}
	public String getLastName() {return lastName;}
	
	//Output Values
	@Override
	public String toString()
	{
		return "First Name = " + firstName + ", Last Name = " + lastName;
	}
}
