package com.viafoura;

import java.util.Scanner;

/**
 * @author Ujju
 *
 */
public class Anagram_Strings {
	
	/**
	 * @param first
	 * @param second
	 * @return
	 * 
	 * 
	 * The below method takes up two string arguments and checks whether they are anagrams of each other
	 * 
	 * If they are anagrams then returns true or false
	 */
	public static boolean checkAnagram(String first, String second){
	char[] characters = first.toCharArray();
	StringBuilder sbSecond = new StringBuilder(second);
	for(char ch : characters)
	{
		int index = sbSecond.indexOf("" + ch);
		if(index != -1){sbSecond.deleteCharAt(index);
		}
		else
		{
			return false;
		}
		}
	return sbSecond.length()==0 ? true : false;
}
	
	/**
	 * @param args
	 */
	/*public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int count=Integer.parseInt(sc.nextLine());
		for(int i=0;i<count;i++)
		{
		String first=sc.nextLine();
		String second=sc.nextLine();
		System.out.println(first+second);
		boolean val=Anagram_Strings.checkAnagram(first, second);
		System.out.println(val);
		}
		sc.close();
	}*/
}
