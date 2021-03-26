package _0325;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class G5_DSLR_9019 {
	
	static int D(int num) {
		return (num *2) % 10000;
	}
	static int S(int num) {
		int result = num - 1;
		if (result == -1)
			result = 9999;
		return result;
	}
	static int L(int num) {
		return (num % 1000) * 10 + num / 1000;
	}
	static int R(int num) {
		return num / 10 + (num % 10) * 1000;
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int tc= 0; tc<T; tc++) {
			Map<Integer, String> m = new HashMap<Integer, String>();
			Queue<Integer> q = new LinkedList<Integer>();
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			m.put(A, "");
			q.add(A);
			
			while(!q.isEmpty()) {
				int currentnum = q.poll();
				if(currentnum == B)
					break;
				String command = m.get(currentnum);
				
				int result = D(currentnum);
				if(!m.containsKey(result)) {
					m.put(result, command+"D");
					q.add(result);
				}
				result = S(currentnum);
				if(!m.containsKey(result)) {
					m.put(result, command+"S");
					q.add(result);
				}
				result = L(currentnum);
				if(!m.containsKey(result)) {
					m.put(result, command+"L");
					q.add(result);
				}
				result = R(currentnum);
				if(!m.containsKey(result)) {
					m.put(result, command+"R");
					q.add(result);
				}
			}
			
			System.out.println(m.get(B));
		}
	}

}
