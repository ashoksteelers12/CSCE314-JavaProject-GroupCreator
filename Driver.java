//Description: The "main" of the program, in which the TeamBuilder class is accessed to get results.
//Name: Ashok Meyyappan

public class Driver 
{
	public static void main(String[] args) 
	{
		/*
		NOTE: 
		Groups include students who have errors in their rank 
		assuming their input error was an accident. They were
		listed in the error file for an incorrect input of their
		rank.
		*/
		TeamBuilder teamMaker = new TeamBuilder(); //Set to Default Constructor of TeamBuilder
		teamMaker.getResults(); //Obtain Grouping Results to File
		System.out.println(teamMaker);
	}
}
