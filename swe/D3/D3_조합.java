package _0419;

import java.util.Scanner;
import java.util.Stack;

public class D3_조합 {
	static int modnum = 1234567891;

	static long factorial(int to, int from) {
		long result = 1;
		for (int i = to; i <= from; i++)
			result = (result * i) % modnum;
		return result;
	}
	
	static long pow(long n, long p){
		if(p == 0)return 1;
		long pn = n;
		long result = 1;
		Stack<Long> s = new Stack<>();
		s.add((long)1);
		s.add(n);
		for (long i = 2; i <= p; i*= 2) {
			pn = (pn * pn) % modnum;
			s.add(i);
			s.add(pn);
		}
		while(!s.isEmpty() && p != 0) {
			long inum = s.pop();
			long pnum =s.pop();
			if(p >= pnum) {
				p -= pnum;
				result = (result * inum) % modnum;
			}
		}
		
		return result; 
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			long ans = 1;
			int N = sc.nextInt();
			int R = sc.nextInt();

			ans = factorial(N - R + 1, N) * pow(factorial(1,R), modnum-2) % modnum;
			System.out.printf("#%d %d\n", tc, ans);
		}

	}

}
