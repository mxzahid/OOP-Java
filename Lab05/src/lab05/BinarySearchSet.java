package lab05;

public class BinarySearchSet {
	
	public double[] storage; //represent the simple array that holds the list values
	private int capacity; //holds the length of the storage array
	private int numItems; //holds the number of the elements/values in the list

	public BinarySearchSet()
	{
		this.storage = new double [6];
		capacity = 6;
		numItems = 0;
	}
	
	public boolean isEmpty()
	{
		if (numItems == 0)
		{
				return true;
		}
		return false;
	}
	
	public int size()
	{
		return numItems;
	}
	
	public void grow()
	{
		double [] tmp = new double [storage.length*2];
		for (int i = 0; i< storage.length; i++)
		{
			tmp[i] = storage[i];
			
		}
		storage = tmp;
		capacity = storage.length;
		
	}
	
	public String toString()
	{
		String p = "";
		
		for(int i =0; i< capacity; i++)
		{
			p += "{" + storage[i] + "}, ";
		}
		
		p += "The capacity is " + capacity + " and the current size is " + size() + ".";
	    return p;
	}
	
	public boolean remove(double value)
	{
		for (int i = 0; i < storage.length; i++)
		{
			if (storage[i] == value)
			{
				for (int j = i; j < storage.length -1; j++)
				{
						storage[j] = storage[j+1];
					
				}
			numItems--;
			return true;
			}
		}
		return false;
	}
	
	public boolean sequential_add(double newVal)
	{
		if (capacity <= numItems)
		{
			grow();
		}
		for (int i =0; i< numItems; i++)
		{
			if (storage[i] == newVal)
			{
				return false;
			}
			
		}
		int j;
		for(j =0; j< numItems; j++)
		{
			if (storage[j] > newVal)
			{
				break;
			}
		}
		for (int k = numItems -1; k>=j; k--)
		{
			storage[k+1] = storage[k];
		}
		storage[j] = newVal;
		numItems++;
		return true;
			
	} 
	
	public static boolean BinarySearch(double[] List, double target)
	{
		int min = 0;
		int max = List.length-1;
		while(min<= max) 
		{
			int mid = (max + min)/2;
			if(List[mid] == target)
			{
				return true;
			}
			else if (List[mid] < target)
			{
				min = mid+1;
			}
			else 
			{
				max = mid-1;
			}
		}
		return false;
	}
	
	
	
	public boolean contains(double value)
	{
		for (int i = 0; i < storage.length; i++)
		{
			if(BinarySearch(storage, value))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean containsAll(double[] elements)
	{
		boolean[] tftable = new boolean [elements.length -1];
	
		for (int i =0; i < storage.length; i++)
		{
			if(BinarySearch(elements, storage[i]))
			{
				tftable[i] = true;
			}
			else
			{
				tftable[i] = false;
			}
		}
		
		for (int j = 0; j < tftable.length; j++)
		{
			if(tftable[j] == false)
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean binary_add(double newVal)
	{
		if(contains(newVal))
		{
			return false;
		}
		if(capacity <= numItems)
		{
			grow ();
		}
		if(numItems == 0)
		{
			storage[0] = newVal;
			numItems++;
			return true;
		}
		if(storage[0] > newVal)
		{
			for(int i = numItems; i>0; i--)
			{
				storage [i] = storage[i-1];
			}
			storage[0] = newVal;
			numItems++;
			return true;
		}
		else if(storage[numItems-1] < newVal)
		{
			storage[numItems] = newVal;
			numItems++;
			return true;
		}
		else
		{
			int min = 0;
			int max = numItems - 1;
			while (min <= max)
			{
				int mid = (max+min)/2;
				if(mid == 0)
				{
					for(int i = numItems; i > min; i --)
					{
						storage[i] = storage[i-1];
					}
					storage[mid + 1] = newVal;
					numItems++;
					return true;
				}
				if(storage[mid-1] <= newVal && storage[mid] >= newVal)
				{
					for(int i = numItems; i > mid; i --)
					{
						storage[i] = storage[i-1];
					}
					storage[mid] = newVal;
					numItems++;
					return true;
				}
				else if(storage[mid] < newVal)
				{
					min = mid +1;
				}
				else
				{
					max = mid -1;
				}
			}
			return false;
		}	}
	
	public BinarySearchSet(double[] input) 
	{
		BinarySearchSet con = new BinarySearchSet();
		
		
	}
	
	public void clear()
	{
		double [] tmp = new double[storage.length];
		
		for(int i =0; i < storage.length - 1; i++)
		{
			storage[i] = tmp[i];
		}
		numItems = 0;
	}
	
	
	
}

