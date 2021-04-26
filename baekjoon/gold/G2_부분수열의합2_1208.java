package _0426;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class G2_부분수열의합2_1208 {
	static Map<Long, Long> m;
	static long[] arr;
	static long S;
	static long cnt;
	static int half;
	static int N;
	static void splitLeft(int idx,long sum) {
		if(idx == half) {
			if(m.containsKey(sum))
				m.put(sum, m.get(sum)+1);
			else
				m.put(sum, (long) 1);
			return;
		}
		splitLeft(idx+1, sum);
		splitLeft(idx+1, sum+arr[idx]);
	}
	
	static void splitRight(int idx,long sum) {
		if(idx == N) {
			if(m.containsKey(S-sum))
				cnt += m.get(S-sum);
			return;
		}
		splitRight(idx+1, sum);
		splitRight(idx+1, sum+arr[idx]);
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextLong();
		arr  = new long[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextLong();
		}
		m = new HashMap<Long, Long>();
		half = N /2;
		splitLeft(0,0);
		splitRight(half,0);
		
		if(S == 0) cnt--;
		System.out.println(cnt);
	}
}