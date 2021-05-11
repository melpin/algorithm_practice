package _0504;

import java.util.Scanner;

public class G5_빗물_14719 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int W = sc.nextInt();
		int []arr = new int[W];
		
		for(int i = 0;i < W; i++) {
			arr[i] = sc.nextInt();
		}
		
		int sum = 0;
		for(int i = 1; i < W - 1; i++) {
			int left = 0;
			int right = 0;
			for(int j = 0; j < i; j++) {
				left = Integer.max(left, arr[j]);
			}
			for(int j = i+1; j < W; j++) {
				right = Integer.max(right, arr[j]);
			}
			
			if(arr[i] < left && arr[i] < right) {
				sum += Integer.min(left, right) - arr[i];
			}
		}
		System.out.println(sum);
	}
}
