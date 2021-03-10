package _0311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S4_숫자카드2_10816 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N; i++) {
			int input = Integer.parseInt(stk.nextToken());
			if(m.containsKey(input))
				m.put(input, m.get(input) + 1);
			else
				m.put(input, 1);
		}
		int M = Integer.parseInt(br.readLine());
		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			int input = Integer.parseInt(stk.nextToken());
			if(m.containsKey(input))
				sb.append(m.get(input)).append(" ");
			else
				sb.append(0).append(" ");
		}
		System.out.println(sb);
	}

}
