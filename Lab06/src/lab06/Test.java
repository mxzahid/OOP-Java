package lab06;

import java.util.Arrays;

public class Test {

	public static void main (String [] args)
	{
	String a1 = "badcfehg";
	System.out.println(AnagramUtil.sort(a1)); // if a1 comes out abcdefgh then sort works.
	
	String s1 = "melon";
	String s2 = "lemon";
	System.out.println(AnagramUtil.areAnagrams(s1, s2));
	String d1 = "Abdullah";
	String d2 = "Zahid";
	String d3 = "halludba";
	System.out.println(AnagramUtil.areAnagrams(d1, d2));
	System.out.println(AnagramUtil.areAnagrams(d1, d3));
	String nullone = null;
	System.out.println(AnagramUtil.areAnagrams(d1, nullone)); // areAnagrams works with null string
	System.out.println(AnagramUtil.sort(nullone)); // sort works with null string
	String [] t1 = {"joy", "ski", "fed", "cat"};
	AnagramUtil.insertionSort(t1);
	System.out.println(Arrays.toString(t1)); // the insertion sort method work
	}
}

