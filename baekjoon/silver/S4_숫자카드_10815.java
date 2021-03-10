package _0311;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class S4_숫자카드_10815 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		for(int i = 0 ; i < N; i++) {
			int input = sc.nextInt();
			if(m.containsKey(input))
				m.put(input, m.get(input) + 1);
			else
				m.put(input, 1);
		}
		int M = sc.nextInt();
		
		for(int i = 0; i < M; i++) {
			int input = sc.nextInt();
			if(m.containsKey(input))
				System.out.print(1+" ");
			else
				System.out.print(0+" ");
		}
	}

}
