package lab06;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class AnagramUtil {

	public static String sort (String InputString)
	{
		String output = "";
		if(InputString == null || InputString.isEmpty())
		{
			return null;
		}
		else
		{
			String lowercase = InputString.toLowerCase();
			char[] arrayInput = lowercase.toCharArray();
			for (int i =0; i < arrayInput.length; i++)
			{
				char index = arrayInput[i];
				int j = i;
				while (j > 0 && arrayInput [j -1] > index)
				{
					arrayInput[j] = arrayInput[j-1];
					j--;
				}
				arrayInput[j] = index;
			}
			for (int a = 0; a < arrayInput.length; a++)
			{
				output += arrayInput[a];			
			}
		}
		return output;

	}
	
	public static boolean areAnagrams(String string1, String string2)
	{
		String sorted1 = sort(string1);
		String sorted2 = sort(string2);
		if(sorted1 != null && sorted2 != null && sorted2.isEmpty() && sorted1.isEmpty())
		{
			if (sorted1.equals(sorted2))
			{
				return true;
			}
		}
		else
		{
			return false;
		}
		return false;
	}
	
	public static void insertionSort(String[] inputList)
	{
		if(inputList.length == 0)
		{
			System.out.println("empty array");
			return;
		}
		OrderString c = new OrderString();
		
		for (int i = 1; i < inputList.length; i++)
		{
			String index = inputList[i];
			int j = i;
			while ((j>0) && (c.compare(sort(inputList[j-1]), sort(index)) > 0 ))
				{
				
				inputList[j] = inputList[j-1];
				j--;
				
				}
			inputList[j] = index;
				
		}
			
			
			
	}
	
	public static String[] getLargestAnagramGroup(String[] inputList) 
	{
	if(inputList.length == 0) 
	{
	String[] x = new String[0];
	return x;
	}
	if(inputList == null) 
	{
	return null;
	}

	insertionSort(inputList);
	int index = 0;
	int counter = 1;
	int maxIndex = 0;
	int maxCounter = 1;

	for(int i = 0; i < inputList.length-1; i++) 
	{
	if(areAnagrams(inputList[i], inputList[i+1])) 
	{
	counter++;
	index = i+1;
	}
	else
	{
	counter = 1;
	index = 0;
	}
	if(counter > maxCounter) 
	{
	maxIndex = index;
	maxCounter = counter;
	}
	}

	String [] answer = new String [maxCounter];
	int x = 0;
	if(maxCounter == 1) 
	{
	String[] str = new String[0];
	return str;
	}
	else 
	{
	for(int i = maxIndex-maxCounter+1; i < maxIndex+1; i++) 
	{
	answer[x] = inputList[i];
	x++;
	}
	}
	return answer;
	}

	public static String[] getLargestAnagramGroup(String filename) 
	{
	if(filename.isEmpty()) 
	{
	String[] answer = new String[0];
	return answer;
	}
	String[] str = readFile(filename);
	String[] answer = getLargestAnagramGroup(str);
	return answer;
	}

	public static String[] readFile(String filename)
	{
	ArrayList<String> results = new ArrayList<String>();
	try
	{
	BufferedReader input = new BufferedReader(new FileReader(filename));
	while(input.ready())
	{
	results.add(input.readLine());
	}
	input.close();
	}
	catch(Exception e)
	{e.printStackTrace();}
	String[] retval = new String[1];
	return results.toArray(retval);
	}


	
}
