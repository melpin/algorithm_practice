package _0421;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class D4_키순서 {
	static people[] peoples;
	static boolean[] visited;
	static int N;
	
	static class people{
		int number;
		List<Integer> smaller;
		List<Integer> bigger;
		people(int n){
			this.number = n;
			smaller = new LinkedList<Integer>();
			bigger = new LinkedList<Integer>();
		}
	}
	
	static boolean search(int n){
		visited = new boolean[N+1];
		visited[n] = true;
		searchsmaller(n);
		searchbigger(n);
		for(int i = 1; i <=N; i++) {
			if(!visited[i]) {
				return false;
			}
		}
		return true;
	}
	
	static void searchsmaller(int n){
		Iterator<Integer> itr = peoples[n].smaller.iterator();
		while(itr.hasNext()) {
			int current = itr.next();
			if(!visited[current]) {
				visited[current] = true;
				searchsmaller(current);
			}
		}
	}
	
	static void searchbigger(int n){
		Iterator<Integer> itr = peoples[n].bigger.iterator();
		while(itr.hasNext()) {
			int current = itr.next();
			if(!visited[current]) {
				visited[current] = true;
				searchbigger(current);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <=T; tc++) {
			int ans = 0;
			N = sc.nextInt();
			int M = sc.nextInt();
			peoples = new people[N+1];
			for(int i = 1; i <=N; i++)
				peoples[i] = new people(i);
			
			for(int i = 0; i < M; i++){
				int a = sc.nextInt();
				int b = sc.nextInt();
				peoples[a].bigger.add(b);
				peoples[b].smaller.add(a);
			}
			
			for(int i = 1; i <=N; i++)
				if(search(i)) ans++;
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}
