package _0504;

import java.util.Arrays;
import java.util.Scanner;

public class S5_N번째로큰수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			int[] arr = new int[10];
			for(int j =0 ; j < 10; j++) {
				arr[j] = sc.nextInt();
			}
			Arrays.sort(arr);
			System.out.println(arr[7]);
		}
	}
}
