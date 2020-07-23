//Description: Reads from a data file and writes the grouping results to a text file.
//Name: Ashok Meyyappan

import java.io.*;
import java.util.*;
public class Utility 
{	
	//Private Objects and Array
	private boolean finished;
	private ArrayList<Student314> studentList502; 
	private ArrayList<Student314> studentList503;
	
	//Default Constructor
	Utility() 
	{
		finished = false;
		studentList502 = new ArrayList<Student314>();
		studentList503 = new ArrayList<Student314>();
	}
	
	//Getter Functions
	ArrayList<Student314> getStudentList502() {return studentList502;}
	ArrayList<Student314> getStudentList503() {return studentList503;}
	
	//Reading File
	public boolean readFile(String fileName)
	{
		try
		{
			Scanner scan = new Scanner(new File(fileName));
			File file = new File("ErrorLog.txt"); //File for Reporting Errors
			PrintWriter pw = new PrintWriter(file); 
			scan.nextLine(); //Ignore Header Line
			//Run Through File Until There Isn't a Next Line
			while (scan.hasNext())
			{
				String data = scan.nextLine(); //Go to Next Line
				String[] values = data.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); //Regex for Parsing
				String[] nameValues = values[4].split(" "); //Splitting Name
				String firstName = nameValues[0]; //Set First Name for Student
				String lastName = nameValues[1]; //Set Last Name for Student
				String[] uinValues = values[6].split("@"); //Ignore Email Address 
				String UIN = uinValues[0]; //Set UIN for Student
				//Set Rank for Student
				Rank rank = null; //Initializing Rank
				if (values[7].matches("\\d+")) //Regex for Positive Integer
				{
					for (Rank year: Rank.values()) //Run Through Enum
					{
						if (Integer.parseInt(values[7]) == year.getValue())
							rank = year;
					}
				}
				int JavaKnowledge = Integer.parseInt(values[1]); //Set Java Knowledge for Student
				String[] sectionValues = values[5].split(" "); //Ignore the Times
				int section = Integer.parseInt(sectionValues[0]); //Set Section for Student
				//Call the Student314 Constructor
				Student314 student = new Student314(firstName, lastName, UIN, rank, JavaKnowledge, section);
				//Checking for Errors in Rank
				if (rank == null)
				{
					if (!file.exists()) //Checking if File Already Exists
					{
						try {file.createNewFile();} //Creating New File if No Exist
						catch (IOException e) {
							//Exception Caught
							pw.println("ERROR");
							pw.println("Reason -> IOException when Creating File");
							pw.println("File -> Error found in Utility.java");
							e.printStackTrace();
							} 
					}
					//Print in Error File
					pw.println("Invalid Rank for the Student: " + firstName + " " + lastName + ".");
					pw.println("Reason -> Not an Integer in 1-4 Range");
					pw.println("File -> Error Found in Utility.java");
				}
				if (student.getSection() == 502)
					studentList502.add(student); //Add to Array List for Section 502
				else if (student.getSection() == 503)
					studentList503.add(student); //Add to Array List for Section 503
			}
			pw.close(); //Close Error File
			scan.close(); //Close Data File
			finished = true; 
		}
		catch (FileNotFoundException e) //Unable to Find File
		{
			e.printStackTrace(); //Get Exception
		}
		return finished;
	}
	
	//Writing Results of Groupings to File
	public boolean writeResults()
	{
		try 
		{
			File file = new File("results.txt");
			if (!file.exists()) //Checking if File Already Exists
				file.createNewFile();
			PrintWriter pw = new PrintWriter(file);
			TeamBuilder tm = new TeamBuilder();
			tm.sortArray(); //Sorting Array for Both Sections
			tm.groupsForBothSections(); //Grouping Students in Both Sections
			Iterator<String> arr = tm.getGroupList().iterator(); //Initializing Iterator
			while (arr.hasNext()) //Until There is No Next
			{
				String arrayValue = arr.next(); //Iterate
				pw.println(arrayValue); //Write Each Line in File
			}
			pw.close(); //Close File for Writing
			finished = true; //Successful in Writing to File
		}
		catch (IOException e) //Exception Caught
		{
			e.printStackTrace();
		}
		return finished;
	}
}
