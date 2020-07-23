//Description: Providing additional information on any person if they are a student, which is UIN and rank.
//Name: Ashok Meyyappan
//UIN: 827001687
//Email: ashoksteelers12@tamu.edu

public class Student extends Person 
{
	//Private Objects
	private String UIN;
	private Rank rank;
		
	//Default Constructor
	Student() 
	{
		super();
		UIN = " ";
		rank = null;
	}
	
	//Constructor
	Student(String fn, String ln, String id, Rank r) 
	{
		super(fn, ln);
		UIN = id;
		rank = r;
	}
	
	//Setters and Getters
	public void setUIN(String id) {UIN = id;}
	public String getUIN() {return UIN;}
	public void setRank(Rank r) {rank = r;}
	public Rank getRank() {return rank;}	
	
	//Output Values
	@Override
	public String toString()
	{
		return super.toString() + ", UIN = " + UIN + ", Rank = " + rank;
	}
}
