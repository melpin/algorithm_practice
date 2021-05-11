package _0504;

import java.util.Scanner;

public class B2_피보나치수5_10870 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] fib = new int[21];
		fib[1] = 1;
		for(int i =2; i <= 20; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		System.out.println(fib[sc.nextInt()]);
	}

}
