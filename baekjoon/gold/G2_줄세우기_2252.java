package _0511;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class G2_줄세우기_2252 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		List<Integer>[] people = new LinkedList[N+1];
		int[] linkcnt = new int[N+1];
		for(int i = 1; i <= N; i++) {
			people[i] = new LinkedList<>();
		}
		
		for(int i = 0; i < M; i++) {
			int big = sc.nextInt();
			int small = sc.nextInt();
			people[big].add(small);
			linkcnt[small]++;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++) {
			if(linkcnt[i] == 0)
				q.add(i);
		}
		
		Queue<Integer> ans = new LinkedList<Integer>();
		while(!q.isEmpty()) {
			int current = q.poll();
			if(linkcnt[current] == 0) {
				ans.add(current);
			}
			
			Iterator<Integer> itr = people[current].iterator();
			while(itr.hasNext()) {
				int next = itr.next();
				linkcnt[next]--;
				if(linkcnt[next] == 0) {
					q.add(next);
				}
			}
		}
		Iterator<Integer> itr = ans.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
	}
}