//Description: Enum class for Rank to get the year in college from an input integer.
//Name: Ashok Meyyappan
//UIN: 827001687
//Email: ashoksteelers12@tamu.edu

public enum Rank 
{
	FRESHMAN(1), SOPHOMORE(2), JUNIOR(3), SENIOR(4);

	private int value; //Private Object
	
	Rank(int val) {value = val;} //Constructor
	
	public int getValue() {return this.value;} //Getting Int Value
}
