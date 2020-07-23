# CSCE314-JavaProject-GroupCreator

You will create groups of 2 people based on responses from a survey in CSV (comma) form linked here. 

There will be many things NOT in the UML below in order to keep it simple. 
1.	Setters/Getters/toStrings (“Complete class profiles”) for EACH class, except Utility, Driver, JavaKnowledgeComparator and Rank.
2.	Each file has a (header comments)
      a.	description of what the class is doing as a part of the project
      b.	Your gradebook name
      c.	Your UIN
      d.	Your email
      e.	IN THAT ORDER
3.	Comments 
      a.	Other than the file header comments, you need to comment about 30% of your code
      b.	prime times to comment, adding, deleting, if/else statement, validating, etc… anything that is not 201 stuff. 
      c.	I will not give every example when to comment, if in doubt, COMMENT
4.	Any errors caught…will be logged in ErrorLog.txt
      a.	the error description must state where (file/class) the error was caught and why
          i.	think of this as debugging 
          
Some assumptions:
    1.	Names (first and last) will always be separated by a space
    2.	The overall layout of the file will always remain the same
    3.	FOR NOW… gender is not considered in the project. Yet. 
    4.	Person (class/file) must be abstract.
    5.	Student (class/file) must inherit from Person.
    6.	314Student (class/file) must inherit from Student.
    7.	JavaKnowledgeComparator (class/file) must be simple and just be used as a comparator with not much utility other than sorting order.
    8.	Any Java Collection data structure can be used.
    9.	TeamBuilder (class/file) should be where most of the application work is conducted. It will pull from all the other classes EXCEPT Driver.
    10.	Driver should be minimum. Probably less than 20 lines.
    11.	Results of grouping should be placed in results.txt in this form:

        502 - Bowen Lupoli (4) Jamila Booth (2)

