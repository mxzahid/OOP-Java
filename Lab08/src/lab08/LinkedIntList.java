package lab08;


//modified version of Chapter 16 LinkedIntList class (page 990)
public class LinkedIntList {
	public ListNode front; // first value in the list
	

	// post: constructs an empty list
	public LinkedIntList(){
		front = null;
	}
	

	public LinkedIntList(int[] arr){
		this();
		

		for (int i = 0; i < arr.length; i++)
			add(arr[i]);
	}
	

	// post: returns the current number of elements in the lists
	public int size(){
		int count = 0;
		ListNode current = front;
		while (current != null){
			current = current.next;
			count++;
		}
		return count;
	}
	

	// post: return comma-separated, bracketed version of the list
	public String toString(){
		if (front == null){
			return "[]";
		}else{
			String result = "[" + front.data;
			ListNode current = front.next;
			while (current != null){
				result += ", " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}
	

	// post: appends the given value to the end of the list
	public void add(int value){
		if (front == null){
			front = new ListNode(value);
		}else{
			ListNode current = front;
			while(current.next != null){
				current = current.next;
			}
			current.next = new ListNode(value);	
		}
	}
	

	

	// pre: 0 <= index < size()
	// post: returns a reference to the node at the given index
	private ListNode nodeAt(int index){
		ListNode current = front;
		for (int i = 0; i < index; i++){
			current = current.next;
		}
		return current;
	}
	

	// pre: 0 <= index <= size()
	// post: inserts the given value at the given index
	public void add(int index, int value){
		if (index == 0){
			front = new ListNode(value, front);
		}else if (index == size()){
			add(value);
		}else if (index > size()){
			return;
		}else{
			ListNode current = nodeAt(index-1);
			current.next = new ListNode(value, current.next);
		}
	}
	

	//*************************************************
	

	// This method accepts an integer value as a parameter and returns the index in the list of 
	// the last occurrence of that value, or -1 if the value is not found in the list.
	public int lastIndexOf(int value){
		//* FILL IN - DO NOT RETURN -1
		

		int index = 0;
		int lastIndexOf = -1;
		

		if(front == null) {
			return lastIndexOf;
		}
		else {
			ListNode current = front;
			while(current != null) {
				if(current.data == value) {
					lastIndexOf = index;
				}
				index++;
				current = current.next;
				}
			}
		return lastIndexOf;
	

	}
	

	// This method should remove all occurrence of a particular value.
	public void removeAll(int value){
		// @TA: There are many ways to do this. A cleaner way to do this is to write a helper function to find index first and then delete
		//* FILL IN
		

		while(front.data == value) {
			front = front.next;
		}
		

		ListNode head = front;
		ListNode current = front.next;
		

		while(current.data != value) {
			current = current.next;
			head = head.next;
		}
		

		while(current.data == value) {
			head.next = current.next;
			current = current.next;
		}
		

		while(current.next != null) {
			if(current.next.data == value) {
				current.next = current.next.next;
			}
			else {
				current = current.next;
			}
		}
	}	
	

	// This method will rearrange the elements of a list of integers by moving to the end of the list all 
	// values that are in odd-numbered positions and otherwise preserving list order. Remember, it does not 
	// matter whether the value itself is odd or even; what matters is whether the value appears in an odd
	// index. Also, the original order of the elements of the list should otherwise be preserved. 
	// You may not construct any new nodes nor use any auxiliary data structures to solve this problem. 
	// You also may not change any data fields of the nodes; you must solve this problem by rearranging the 
	// links of the list.
	public void shift(){
		//* FILL IN
		

		ListNode current = front;
		ListNode tail;
		int size = size()/2;
		

		if(current == null) {
			return;
		}
		else {
			while(current.next != null) {
				current = current.next;
			}
			tail = current;
			current = front;
			for(int i = 0; i < size; i++) {
				tail.next = current.next;
				tail = tail.next;
				current.next = current.next.next;
				current = current.next;
			}
			tail.next = null;
	}
	}
	

	// This method will double the size of the list by replacing every integer 
	// in the list with two of that integer.
	// if the list is empty simply return
	public void stutter(){
		//* FILL IN
		

		ListNode current = front;
		

		if(current == null) {
			return;
		}
		else {
	    while (current != null) {
	        current.next = new ListNode(current.data, current.next);
	        current = current.next.next;
	    }
	}
	}
}

