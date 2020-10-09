package lab10;
import java.io.*;
public class MaxHeap 
{
    public int[] heap;
    public int index_to_last_element; 
    
    public MaxHeap(int[] arr) 
    {
    	// FILL IN
    	heap = new int[arr.length];
    	for(int i = 0; i < heap.length; i++) 
    	{
    		insert(arr[i]);
    	}
    }
    
    public int parent(int pos) {
    	return (pos-1)/2;
    } 
    
    public int leftchild(int pos) {
    	return 2*pos + 1;
    }

    public int rightchild(int pos) {
    	return 2*pos + 2;
    }   
    
    public boolean isLeaf(int pos)
    { return (pos >= index_to_last_element/2) && (pos < index_to_last_element); }

    public MaxHeap(int maxsize)
    {
    	heap = new int[maxsize];
    	index_to_last_element = 0;
    	for(int i = 0; i < maxsize; i++)
    	{
    		heap[i] = 0;
    	}
    }   
    
    public int removemax() 
    {
    	// FILL IN - DONOT RETURN -1 UNLESS NECESSARY
    	if(index_to_last_element == 0)
    	{
    		return -1;
    	}
    	else
    	{
    		int temp = heap[0];
    		int temp2 = heap[index_to_last_element-1];
    		heap[0] = temp2;
    		heap[index_to_last_element -1] = temp;
    		int index = 0;
    		while(heap[index] < heap[(index * 2) + 1] && index < heap.length - 1)
    		{
    			int temp3 = heap[index];
    			int temp4 = heap[(index * 2) + 1];
    			heap[index] = temp4;
    			heap[(index * 2) + 1] = temp3;
    			index = (index * 2) + 1;
    		}
    		heap[index_to_last_element - 1] = 0;
    		index_to_last_element--;
    		return temp;
    	}
    	
    }
    
    
    public void insert(int element)
    {
    	// FILL IN
    	heap[index_to_last_element] = element;
    	if(index_to_last_element == 0)
    	{
    		index_to_last_element++;
    	}
    	else
    	{
    		int index = index_to_last_element;
    		
    		while(heap[index] > heap[(index - 1) / 2])
    		{
    			int temp = heap[index];
    			int temp2 = heap[(index - 1) / 2];
    			heap[index] = temp2;
    			heap[(index - 1) / 2] = temp;
    			index = (index -1) / 2;
    		}
    		index_to_last_element++;
    	}
    	
    	
    } 

    // This function implements the heap sort
    public void sort() 
    { 
    	int n = heap.length;
    	
    	for(int i = n/2 -1; i>=0; i--)
    		heapify(i);
    	
    	for(int i = n-1; i >=0; i--)
    	{
    		int temp = heap[0];
    		heap[0] = heap[i];
    		heap[i] = temp;
    		heapify(0);
    		index_to_last_element--;
    	}
    } 
    
    
    public void heapify(int i) 
    {
    	int largest = i;
    	int left = 2 * i + 1;  			
    	int r = 2 * i + 2;       			
    	int tmp;
      	if(left < index_to_last_element && heap[left] > heap[i])		
         		largest = left;             	

      	if(r < index_to_last_element && heap[r] > heap[largest])
      		largest = r;           		
      	
      	if(largest != i)	 			
      	{
          		tmp = heap[i];      		
          		heap[i] = heap[largest];
          		heap[largest] = tmp;
          		heapify(largest); 			

         	}
    }

	// DO NOT CHANGE THIS FUNCTION!
	public void printArray(){
		for (int i = 0; i < heap.length; i++)
			System.out.print(heap[i] + ", ");
		System.out.println();
	} 
	
	// DO NOT CHANGE THIS FUNCTION!
	// post: prints the tree contents, one per line, following an inorder traversal and using indentation to 
	//indicate node depth; prints right to left so that it looks correct when the output is rotated.
	public void printSideways(){
		printSideways(0, 0);
	}
	
	// DO NOT CHANGE THIS FUNCTION!
	// post: prints in reversed preorder the tree with given root, indenting each line to the given level
	private void printSideways(int root_indx, int level){
		if (root_indx < heap.length){
			printSideways(rightchild(root_indx), level+1);
			for (int i = 0; i < level; i++){
				System.out.print("       ");
			}
			System.out.println(heap[root_indx]);
			printSideways(leftchild(root_indx), level+1);
		}
	}
	
	
	// DO NOT CHANGE THIS FUNCTION!
	public boolean IsEqual(int[] arr){
		if (arr.length != heap.length)
			return false;

		if (arr.length == 0)
			return true;
		
		for (int i = 0; i < arr.length; i++)
			if (arr[i] != heap[i])
				return false;
		
		return true;
	}
    
    public static void main(String[] arg)
    {
    	// ********************* TESTS FOR LAB ****************************//
    	
         MaxHeap maxHeap = new MaxHeap(15);
         
         int[] arr1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         if (!maxHeap.IsEqual(arr1))
        	System.err.println("TEST FAILED: insert 0");
        
         maxHeap.insert(5);
         
         int[] arr2 = {5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         if (!maxHeap.IsEqual(arr2))
        	System.err.println("TEST FAILED: insert 1");
         
         maxHeap.insert(3);
         
         int[] arr3 = {5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         if (!maxHeap.IsEqual(arr3))
        	System.err.println("TEST FAILED: insert 2");
          
         maxHeap.insert(17);
         
         int[] arr4 = {17, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         if (!maxHeap.IsEqual(arr4))
        	System.err.println("TEST FAILED: insert 3");
         
         maxHeap.insert(10);
         int[] arr5 = {17, 10, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         if (!maxHeap.IsEqual(arr5))
        	System.err.println("TEST FAILED: insert 4");
         
         maxHeap.insert(84);
         int[] arr6 = {84, 17, 5, 3, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         if (!maxHeap.IsEqual(arr6))
        	System.err.println("TEST FAILED: insert 5");
         
         maxHeap.insert(19);
         int[] arr7 = {84, 17, 19, 3, 10, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         if (!maxHeap.IsEqual(arr7))
        	System.err.println("TEST FAILED: insert 6");
         
         maxHeap.insert(6);
         int[] arr8 = {84, 17, 19, 3, 10, 5, 6, 0, 0, 0, 0, 0, 0, 0, 0};
         if (!maxHeap.IsEqual(arr8))
        	System.err.println("TEST FAILED: insert 7");
         
         maxHeap.insert(22);
         int[] arr9 = {84, 22, 19, 17, 10, 5, 6, 3, 0, 0, 0, 0, 0, 0, 0};
         if (!maxHeap.IsEqual(arr9))
        	System.err.println("TEST FAILED: insert 8");
         
         maxHeap.insert(9);
         int[] arr10 = {84, 22, 19, 17, 10, 5, 6, 3, 9, 0, 0, 0, 0, 0, 0};
         if (!maxHeap.IsEqual(arr10))
        	System.err.println("TEST FAILED: insert 9");
         
         MaxHeap maxHeap1 = new MaxHeap(15);
         
         maxHeap1.insert(97);
         maxHeap1.insert(93);
         maxHeap1.insert(87);
         maxHeap1.insert(90);
         maxHeap1.insert(89);
         maxHeap1.insert(83);
         
         int[] arr11 = {97, 93, 87, 90, 89, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         if (!maxHeap1.IsEqual(arr11))
        	System.err.println("TEST FAILED: insert 10");
         
         // remove tests
         int maxVal1 = maxHeap1.removemax();
         
         int[] arr12 = {93, 90, 87, 83, 89, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         if (maxVal1 != 97 || !maxHeap1.IsEqual(arr12))
        	System.err.println("TEST FAILED: remove 1");
         
         int maxVal2 = maxHeap1.removemax();
         
         int[] arr13 = {90, 89, 87, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         if (maxVal2 != 93 || !maxHeap1.IsEqual(arr13))
        	System.err.println("TEST FAILED: remove 2");
         
         MaxHeap maxHeap2 = new MaxHeap(15);
         if (maxHeap2.removemax() != -1)
        	System.err.println("TEST FAILED: remove 0"); 
         System.out.println("Testing Done (lab) !!!");
        
        
     // ********************* TESTS FOR ASSIGNMENT ****************************//
        
         int[] arr14 = {};
         MaxHeap maxHeap3 = new MaxHeap(arr14);
         
         if (!maxHeap3.IsEqual(arr14))
        	System.err.println("TEST FAILED: constructor 0");
         
         int[] arr15 = {3};
         MaxHeap maxHeap4 = new MaxHeap(arr15);
         if (!maxHeap4.IsEqual(arr15))
        	System.err.println("TEST FAILED: constructor 1");
         
         int[] arr16 = {22, 3};
         int[] arr16_2 = {3, 22};
         MaxHeap maxHeap5 = new MaxHeap(arr16_2);
         if (!maxHeap5.IsEqual(arr16))
        	System.err.println("TEST FAILED: constructor 2");
         
         int[] arr17 = {84, 22, 19, 17, 10, 5, 6, 3, 9};
         int[] arr17_2 = {5, 3, 17, 10, 84, 19, 6, 22, 9};
         MaxHeap maxHeap6 = new MaxHeap(arr17_2);
         
         if (!maxHeap6.IsEqual(arr17))
        	System.err.println("TEST FAILED: constructor 3");
         
         MaxHeap maxHeap7 = new MaxHeap(0);
         maxHeap7.heap = arr15;
         maxHeap7.index_to_last_element = 0;
         maxHeap7.sort();
         if (!maxHeap7.IsEqual(arr15))
        	System.err.println("TEST FAILED: sort 1");
         
         MaxHeap maxHeap8 = new MaxHeap(2);
         maxHeap8.heap = arr16;
         maxHeap8.index_to_last_element = arr16.length-1;
         maxHeap8.sort();
         if (!maxHeap8.IsEqual(arr16_2))
        	System.err.println("TEST FAILED: sort 2");
         
         MaxHeap maxHeap9 = new MaxHeap(9);
         maxHeap9.heap = arr17_2;
         maxHeap9.index_to_last_element = arr17_2.length-1;
         maxHeap9.sort();
         int[] arr18 = {3, 5, 6, 9, 10, 17, 19, 22, 84};
         if (!maxHeap9.IsEqual(arr18))
        	System.err.println("TEST FAILED: sort 3");
        
        System.out.println("Testing Done (assignment) !!!");
        
                
    }
}

