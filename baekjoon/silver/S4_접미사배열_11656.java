package _0222;

import java.util.Arrays;
import java.util.Scanner;

public class S4_접미사배열_11656 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String s = sc.nextLine();
		String[] arr = new String[s.length()];
		
		for(int i = 0; i < s.length();i++)
			arr[i] = s.substring(i);
		
		Arrays.sort(arr);
		
		for(int i = 0; i < s.length();i++)
			System.out.println(arr[i]);
	}
}
