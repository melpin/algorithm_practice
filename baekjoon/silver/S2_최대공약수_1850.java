package _0225;

import java.util.Scanner;

public class S2_최대공약수_1850 {
	static long gcd(long a, long b) {
		long tmp;
		if(a < b) {
			tmp = b;
			b = a;
			a = tmp;
		}
		while(b > 0) {
			a %= b;
			tmp = b;
			b = a;
			a = tmp;
		}
		return a;
	}
	
	//a, b는 각각 1의 갯수임
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < gcd(a,b); i++) {
			sb.append("1");
		}
		System.out.println(sb);
	}

}
