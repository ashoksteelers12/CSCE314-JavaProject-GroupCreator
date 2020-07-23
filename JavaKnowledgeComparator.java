//Description: Sorting the students in ascending order based on Java Knowledge input.
//Name: Ashok Meyyappan

import java.util.*;

public class JavaKnowledgeComparator implements Comparator<Student314>
{
	//Comparing Two 314 Student Values Based on Java Knowledge
	public int compare(Student314 s1, Student314 s2)
	{
		if (s1.getJavaKnowledge() == s2.getJavaKnowledge()) //If Equal
			return 0;
		else if (s1.getJavaKnowledge() < s2.getJavaKnowledge()) //If Student 1 is Less
			return -1;
		else //If Student 1 is More
			return 1; 
	}
}
