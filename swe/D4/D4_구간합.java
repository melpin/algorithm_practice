package _0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class D4_구간합 {
	static Long A;
	static Long B;
	static Map<Long, Long> m;
	
	static long getv(long n) {
		long v= 10;
		while(n / v > 0) {
			v *= 10;
		}
		return v / 10;
	}

	static long calcf(long n) {
		if(m.containsKey(n)) {
			return m.get(n);
		}
		if (n < 10) {
			m.put(n, n * (n + 1) / 2);
			return m.get(n);
		}
		long v = getv(n);
		m.put(n, calcf(n - 1 - n % v) + calcg(n));
		return m.get(n);
	}

	static long calcg(long n) {
		long v = getv(n);
		return n / v * (n % v + 1) + calcf(n % v);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = new HashMap<>();
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			
			long ans = calcf(B) - calcf(A - 1);
			System.out.println("#"+tc+" "+ans);
		}
	}

}
