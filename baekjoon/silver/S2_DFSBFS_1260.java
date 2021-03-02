package _0302;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S2_DFSBFS_1260 {
	
	static boolean[] visit;
	static StringBuilder sb;
	static int[][] arr;
	static int N;
	
	public static void DFS(int from){
		sb.append(from).append(" ");
		visit[from] = true;
		
		for(int i = 1; i < N+1; i++) {
			if(arr[from][i] == 1 && !visit[i]){
				DFS(i);
			}
		}
	}
	
	static Queue<Integer> q;
	public static void BFS(){
		int from = 0;
		while(!q.isEmpty()){
			from = q.poll();
			sb.append(from).append(" ");
			for(int i = 1; i < N+1; i++) {
				if(arr[from][i] == 1 && !visit[i]){
					q.add(i);
					visit[i] = true;
				}
			}
			
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		arr= new int [N+1][N+1];
		
		for(int i = 0; i < M; i++){
			int a = sc.nextInt();
			int b= sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		sb = new StringBuilder();
		visit = new boolean[N+1];
		DFS(V);
		System.out.println(sb);
		
		sb = new StringBuilder();
		visit = new boolean[N+1];
		q = new LinkedList<Integer>();
		q.add(V);
		visit[V] = true;
		BFS();
		System.out.println(sb);
	}

}
