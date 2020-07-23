//Description: Providing additional information on any person if they are a 314 student, which is Java Knowledge and section.
//Name: Ashok Meyyappan

import java.util.*;

public class Student314 extends Student implements Comparator<Student314>
{
	//Private Objects
	private int JavaKnowledge;
	private int section;
	
	//Default Constructor
	Student314() 
	{
		super();
		JavaKnowledge = -1;
		section = -1;
	}
	
	//Constructor
	Student314(String fn, String ln, String id, Rank r, int jk, int s) 
	{
		super(fn, ln, id, r);
		JavaKnowledge = jk;
		section = s;
	}
	
	//Setters and Getters
	public void setJavaKnowledge(int jk) {JavaKnowledge = jk;}
	public int getJavaKnowledge() {return JavaKnowledge;}
	public void setSection(int s) {section = s;}
	public int getSection() {return section;}
	
	public int compare(Student314 s1, Student314 s2)
	{
		if (s1.getJavaKnowledge() == s2.getJavaKnowledge())
			return 0;
		else if (s1.getJavaKnowledge() < s2.getJavaKnowledge())
			return -1;
		else 
			return 1;
	}
	
	//Output Values
	@Override
	public String toString()
	{
		return super.toString() + ", Section =  " + section + ", Java Knowledge = " + JavaKnowledge;
	}
}
