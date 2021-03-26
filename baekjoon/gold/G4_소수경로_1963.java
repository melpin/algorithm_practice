package _0325;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class G4_소수경로_1963 {
	static int zipnumber(int[] list) {
		return list[0] * 1000 + list[1] * 100 + list[2] *10 + list[3];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int range = 10000;
		boolean[] arset = new boolean[range];
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		for(int i = 2; i < range; i++) {
			if(!arset[i]){
				int k = 1;
				if(i>=1000)
					m.put(i, 1);
				while(i * k < range) {
					arset[i*k] = true;
					k++;
				}
			}
		}
	
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int ans = 0;
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(A);
			Map<Integer, Integer> used = new HashMap<Integer, Integer>();
			used.put(A, 0);
			
			while(true){
				int Current = q.poll();
				if(Current == B) {
					break;
				}
				int[] splitnum = {(Current/1000)% 10, (Current/100)% 10,(Current/10)% 10, (Current)% 10};
				int count = used.get(Current);
				
				for(int i = 0; i < 4; i++) {
					for(int n = 0; n < 10; n++) {
						int [] copynum = {splitnum[0],splitnum[1],splitnum[2],splitnum[3]};
						copynum[i] = n;
						int zipsum = zipnumber(copynum);
						if(m.containsKey(zipsum) && !used.containsKey(zipsum)){
							used.put(zipsum, count+1);
							q.add(zipsum);
						}
					}
				}
			}
			
			System.out.println(used.get(B));
		}
	}

}
