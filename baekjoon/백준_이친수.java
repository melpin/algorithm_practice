package _0210;

import java.util.Scanner;

public class 백준_이친수 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long [] arr = new long[91]; // N <= 90
		arr[0] = 1;
		arr[1] = 1;
		int N = sc.nextInt();
		
		for(int i =2;i<N; i++)
			arr[i] = arr[i-2] + arr[i-1];
		System.out.println(arr[N-1]);
	}	
		//피보나치 수열임
		//처음에 1의 갯수, 0의 갯수의 합인데 잘 계산해보면 1은 fib(N)개 만큼있고 0은 fib (N-1)개 만금있음
		//결국 합피면 fin(N+1)이 답
	
}
