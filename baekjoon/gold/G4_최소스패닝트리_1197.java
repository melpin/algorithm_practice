package _0511;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class G4_최소스패닝트리_1197 {

	static class line implements Comparable<line>{
		int from;
		int to;
		int val;
		line(int from, int to, int val){
			this.from = from;
			this.to = to;
			this.val = val;
		}
		@Override
		public int compareTo(line o) {
			if(this.val > o.val)
				return 1;
			else if(this.val < o.val)
				return -1;
			return 0;
		}
	}
	
	static int V;
	static int[] parent = new int[V+1];
	static int getParent(int i){
		while(parent[i] != i) {
			i = parent[i];
		}
		return i;
	}
	
	static void setParent(int i, int j){
		int iParent = getParent(i);
		int jParent = getParent(j);
		if(iParent < jParent) {
			parent[jParent] = iParent;
		}else {
			parent[iParent] = jParent;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int ans = 0;
		
		parent = new int[V+1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		Queue<line> q = new PriorityQueue<line>();
		for(int i = 0; i < E; i ++) {
			q.add(new line(sc.nextInt(),sc.nextInt(),sc.nextInt()));
		}
		
		while(!q.isEmpty()) {
			line curent = q.poll();
			if(getParent(curent.to) == getParent(curent.from))
				continue;
			setParent(curent.to, curent.from);
			ans += curent.val;
		}
		System.out.println(ans);
	}
}
