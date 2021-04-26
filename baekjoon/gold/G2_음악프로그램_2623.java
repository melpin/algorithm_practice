package _0423;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class G2_음악프로그램_2623 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		int[][] adj = new int[N+1][N+1];
		int[] indegree = new int[N+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 0; i < M;i++) {
			int K = sc.nextInt();
			int from = sc.nextInt();
			for(int k = 1; k < K; k++){
				int to = sc.nextInt();
				if(adj[from][to] == 0){ // duplicate
					adj[from][to] = 1;
					indegree[to]++;
				}
				from = to;
			}
		}
		
		for(int i = 1; i <= N; i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			sb.append(node).append("\n");
			for(int i = 1; i <= N; i++) {
                if(adj[node][i] == 1) {
                    indegree[i]--;
                    if(indegree[i] == 0)
                        queue.add(i);
                }
            }
		}
		for(int i = 1; i <= N; i++) {
			if(indegree[i] != 0) {
				sb = new StringBuilder();
				sb.append(0);
			}
		}
		System.out.println(sb);
	}
}
