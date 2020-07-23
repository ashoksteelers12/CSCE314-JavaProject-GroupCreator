//Description: Sorts the Students in each section by Java Knowledge, and groups students into pairs.
//Name: Ashok Meyyappan

import java.io.*;
import java.util.*;

public class TeamBuilder 
{
	//Private Objects
	Student314 teams;
	Utility util;
	JavaKnowledgeComparator compare;
	ArrayList<String> groupList;
	
	//Default Constructor
	TeamBuilder()
	{
		teams = new Student314();
		util = new Utility();
		compare = new JavaKnowledgeComparator();
		groupList = new ArrayList<String>();
	}
	
	//Setters and Getters
	public void setTeams(Student314 t) {teams = t;}
	public Student314 getTeams() {return teams;}
	public void setUtil(Utility u) {util = u;}
	public Utility getUtil() {return util;}
	public void setCompare(JavaKnowledgeComparator c) {compare = c;}
	public JavaKnowledgeComparator getCompare() {return compare;}
	public ArrayList<String> getGroupList() {return groupList;}
	
	//Function to Sort Array by Java Knowledge
	public void sortArray()
	{
		util.readFile("./src/Class_Data.csv"); //Read Data File
		Collections.sort(util.getStudentList502(), compare); //Sort Section 502
		Collections.sort(util.getStudentList503(), compare); //Sort Section 503
	}
	
	//Function to Print Array of 314 Students for Testing Purposes
	public void printStudentArray(ArrayList<Student314> studentList)
	{
		Iterator<Student314> arr = studentList.iterator(); //Initialize Iterator
		while (arr.hasNext()) //Until No Next
		{
			Student314 arrayValue = arr.next(); //Iterate
			System.out.println(arrayValue); //Print Values
		}
	}
	
	//Function to Print Array of Strings for Testing Purposes
	public void printStringArray(ArrayList<String> studentList)
	{
		Iterator<String> arr = studentList.iterator(); //Initialize Iterator
		while (arr.hasNext()) //Until No Next
		{
			String arrayValue = arr.next(); //Iterate
			System.out.println(arrayValue); //Print Values
		}
	}
	
	//Function to Create Groups of Two
	public void placeIntoGroups(ArrayList<Student314> studentList)
	{
		//Initialize Two Halves of the Section
		ArrayList<String> firstHalf = new ArrayList<String>(); 
		ArrayList<String> secondHalf = new ArrayList<String>();
		//Finding the Half Mark
		int numberOfGroups = Math.floorDiv(studentList.size(), 2);
		//Obtaining the Extra Student Error for Odd Number of Students
		if (studentList.size() % 2 != 0)
		{
			try 
			{
				FileWriter fw = new FileWriter("ErrorLog.txt", true); //Append to Existing File
				PrintWriter pw = new PrintWriter(fw);
				pw.println("ODD #, so Extra Student: " + studentList.get(numberOfGroups + 1).getFirstName() + 
						" " + studentList.get(numberOfGroups + 1).getLastName() + "."); //Write to File
				pw.println("Reason -> Since odd number of students, there is one student left out.");
				pw.println("          The middle student was chosen as iteration occurred from both ends.");
				pw.println("File -> Error found in TeamBuilder.java");
				pw.close(); //Close File for Writing
			} 
			catch (IOException e1) {e1.printStackTrace();} //Catch Exception
		}
		String line = " "; //Initialization
		//Obtain First Half of Groupings
		for (int i = 0; i < numberOfGroups; i++)
		{
			line = studentList.get(i).getFirstName() + " " + 
					studentList.get(i).getLastName() + " (" + 
					studentList.get(i).getJavaKnowledge() + ")"; //Setting First Half Output of Line
			firstHalf.add(line); //Adding Line to Array
		}
		//Obtain Second Half of Groupings
		for (int i = studentList.size() - 1; i > numberOfGroups; i--)
		{
			line = studentList.get(i).getFirstName() + " " + 
					studentList.get(i).getLastName() + " (" + 
					studentList.get(i).getJavaKnowledge() + ")"; //Setting Second Half Output of Line
			secondHalf.add(line); //Adding Line to Array
		}
		//Combining both Halfs of Groupings
		for (int i = 0; i < numberOfGroups; i++)
		{
			line = studentList.get(i).getSection() + 
					" - " + firstHalf.get(i) + " " + secondHalf.get(i); //Setting Line to Groupings
			groupList.add(line); //Adding Finalized Line to Array
		}
	}

	//Function to Grouping Each Section
	public void groupsForBothSections()
	{
		placeIntoGroups(util.getStudentList502()); //Send Section 502 into Groupings Function
		placeIntoGroups(util.getStudentList503()); //Send Section 503 into Groupings Function
	}
	
	//Function to Call the Writing to File Function from Utility
	public void getResults() 
	{
		Utility results = new Utility(); //Calling Utility Default Constructor
		results.writeResults(); //Writing to results.txt
	}
	
	//Output
	@Override
	public String toString()
	{
		return "Finished Program";
	}
}
