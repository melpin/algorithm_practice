package _0225;

import java.util.Scanner;
import java.util.Stack;

public class S5_BaseConversion_11576 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int N = sc.nextInt();
		int[] arr= new int[N];
		for(int i = 0; i <N;i++) {
			arr[i] = sc.nextInt();
		}
		
		int sum = 0;
		
		int sig =1; 
		for(int i = N-1; i >=0;i--) {
			sum += arr[i] * sig;
			sig *= A;
		}
		
		Stack<Integer> s = new Stack<Integer>();
		while(sum > 0) {
			s.push(sum % B);
			sum /= B;
		}
		while(!s.empty())
			System.out.print(s.pop()+" ");
	}

}
