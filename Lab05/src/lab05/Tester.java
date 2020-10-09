package lab05;

public class Tester {
	
	public static void main (String [] args)
	{
//		BinarySearchSet testlist = new BinarySearchSet();
//		System.out.println(testlist.isEmpty());
//		System.out.println(testlist.size());
//		testlist.sequential_add(30);
//		testlist.sequential_add(03);
//		testlist.sequential_add(5);
//		testlist.sequential_add(6);
//		testlist.sequential_add(9);
//		testlist.sequential_add(69);
//		testlist.sequential_add(70);
//		testlist.sequential_add(999);
//		testlist.sequential_add(666);
//		System.out.println("original test list: " + testlist ); // original one formed before removal
//		if((testlist.remove(70)== true) )
//		{
//			testlist.remove(70);
//			System.out.println("after removal modified test list: "+ testlist);
//			System.out.println("Congratulations you don't completely suck at programming"); //because why not
//		}
//		else
//		{
//			System.out.println("shitty preogram, you suck"); // kinda true
//		}
//		System.out.println(testlist.contains(56));
		BinarySearchSet testlist1 = new BinarySearchSet();
		testlist1.binary_add(5);
		System.out.println(testlist1.toString());
		testlist1.binary_add(2);

		System.out.println(testlist1.toString());
		testlist1.binary_add(7);
		System.out.println(testlist1.toString());
		testlist1.binary_add(9);
		System.out.println(testlist1.toString());
		testlist1.binary_add(5.5);
		System.out.println(testlist1.toString());
		testlist1.binary_add(5.6);
		System.out.println(testlist1.toString());
		
		testlist1.clear();
		System.out.println(testlist1);
		//testlist1.binary_add(7.0);
		//testlist1.sequential_add(999);
	//.binary_add(6.6);
		//testlist1.binary_add(8.9);
//		if(testlist1.binary_add(5.6))
//		{
//			testlist1.binary_add(5.6);
//			System.out.println(testlist1);
//			System.out.println("the binary add works");
//		}		
		
	}

}
