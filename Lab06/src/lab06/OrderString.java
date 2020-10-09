package lab06;

import java.util.Comparator;

public class OrderString implements Comparator<String>
{
	public int compare(String input1, String input2)
	{
		if (input1.compareTo(input2) > 0)
		{
			return 1;
		}
		else if (input1.compareTo(input2) > 0)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	

}
