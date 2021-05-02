package _0426;

import java.util.Scanner;

public class G1_피자판매_2632 {
	static void setarr(int[] arr, int[] sumarr) {
		int sum = 0;
		sumarr[0] = 1;
		for(int i =0; i < arr.length; i++)
			sum += arr[i];
		sumarr[sum]++;
		
		for(int i =0; i < arr.length; i++) {
			sum = 0;
			for(int j = 0;j < arr.length - 1; j++) {
				sum += arr[(i + j) % arr.length];
				sumarr[sum]++;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int An = sc.nextInt();
		int Bn = sc.nextInt();
		int cnt = 0;
		int []A = new int[An];
		int []Asum = new int[1000001];
		for(int i =0;i<An;i++)
			A[i] = sc.nextInt();
		
		int []B = new int[Bn];
		int []Bsum = new int[1000001];
		for(int i =0;i<Bn;i++)
			B[i] = sc.nextInt();
		
		setarr(A,Asum);
		setarr(B,Bsum);
		for(int i = 0; i <= T; i++) {
			cnt += (Asum[i] * Bsum[T - i]);
		}
		System.out.println(cnt);
	}
}