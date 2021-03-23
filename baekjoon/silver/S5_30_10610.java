package _0318;

import java.util.Arrays;
import java.util.Scanner;

public class S5_30_10610 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder ans = new StringBuilder();
		String N = sc.next();
		int[] arr = new int[N.length()];
		long sum = 0;
		boolean containzero = false;
		for(int i = 0; i < arr.length; i++){
			char c = N.charAt(i);
			arr[i] = c - '0'; 
			if(arr[i] == 0)
				containzero = true;
			sum += arr[i];
		}
		if(sum % 3 != 0 || !containzero)
			ans.append(-1);
		else {
			Arrays.sort(arr);
			for(int i = arr.length-1; i >=0; i--)
				ans.append(arr[i]);
			//내림차순 정렬
		}
		System.out.println(ans);
	}
}
