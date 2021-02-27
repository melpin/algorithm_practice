package _0302;

import java.util.Scanner;

public class S4_소인수분해_11653 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N =sc.nextInt();
		int i = 2;
		while(N > 1) {
			if(N % i == 0) {
				System.out.println(i);
				N = N / i;
			}else {
				i++;
			}
		}
	}
}
