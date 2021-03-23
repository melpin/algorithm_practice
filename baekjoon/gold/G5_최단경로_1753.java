package others;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class G5_최단경로_1753 {
	
	static class Li implements Comparable<Li>{
		int node;
		int dis;
		Li(int node, int dis){
			this.node = node;
			this.dis = dis;
		}
		
		@Override
		public int compareTo(Li o) {
			return this.dis - o.dis;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		LinkedList<Li> []K = new LinkedList[V];
		int start = sc.nextInt() - 1;
		
		for (int i = 0; i < V; i++){
			K[i] = new LinkedList<Li>();
		}
		
		
		for(int i = 0; i < E; i++) {
			K[sc.nextInt()-1].add(new Li(sc.nextInt()-1, sc.nextInt()));
		}

		int[] D = new int[V];
		for (int i = 0; i < V; i++){
			if(i != start)
				D[i] = Integer.MAX_VALUE;
		}
		
		boolean[] visited = new boolean[V];
		PriorityQueue<Li> q= new PriorityQueue<>();
		q.add(new Li(start, 0));

		while(!q.isEmpty()) {
			Li info = q.poll();
			
			
			if(info.dis > D[info.node])
				continue;

			LinkedList<Li> currentlist = K[info.node];
			while(!currentlist.isEmpty()) {
				Li currente = currentlist.poll();
				if(D[currente.node] > D[info.node] + currente.dis){
					D[currente.node] = D[info.node] + currente.dis;
					q.add(new Li(currente.node, D[currente.node]));
				}
			}
		}
		
		for (int i = 0; i < V; i++) {
			if(D[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(D[i]);
		}
	}
}
