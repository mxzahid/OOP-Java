package lab01;

public class SumExperiment {
	
	public static int check_sum(int[] array){
		
		int p1 = 0;
		int p2 = array.length - 1;
		for(int i = 0; i<7; i++)
		{
			if ((array[p1]+array[p2] == 20) && (array[p1] != array[p2])) 
			{
				return p1;
			}
			else if (array[p1] + array[p2] > 20)
			{
				--p2;
			}
			else if (array[p1] + array[p2] < 20)
			{
				++p1;
			}
			
			}
		return -1;		
				
		// This function will inspect the input to find any pair of values that add up to 20
		// if it find such a pair, it will return the *index* of the smallest value
		// if it does not find such as pair, it will return -1;
		// remove the following line after you are done writing the function
		
	}
	
	
	public static void main(String[] args) {
		int[] array1 = new int[]{5, 7, 8, 9, 10, 15, 16};
		if (check_sum(array1) != 0)
			System.err.println("TEST1 FAILED");
		
		int[] array2 = new int[]{3, 5, 8, 9, 10, 15, 16};
		if (check_sum(array2) != 1)
			System.err.println("TEST2 FAILED");

		
		int[] array3 = new int[]{3, 4, 6, 9, 10, 14, 15};
		if (check_sum(array3) != 2)
			System.err.println("TEST3 FAILED");
		
		int[] array4 = new int[]{6, 7, 8, 9, 10, 15, 16};
		if (check_sum(array4) != -1)
			System.err.println("TEST4 FAILED");
		
		System.out.println("Done!!!");
	}
}



