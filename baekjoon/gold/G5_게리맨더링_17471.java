package other;

import java.util.Scanner;

public class G5_게리맨더링_17471 {
	static int N;
	static int []people;
	static int [][] map;
	static int ans;
	static boolean[] group;
	static boolean []visited;
	static int visitcnt;
	
	static void visitcheck() {
		visited = new boolean[N+1];
		visitcnt = 0;
		int astart = -1;
		int bstart = -1;
		for(int i = 1; i <= N;i++) {
			if(group[i]) {
				astart = i;
				break;
			}
		}
		
		for(int i = 1; i <= N;i++) {
			if(!group[i]) {
				bstart = i;
				break;
			}
		}
		
		visit(astart);
		visit(bstart);
		if(visitcnt == N){
			int asum = 0;
			int bsum = 0;
			for(int i =1; i <= N; i++) {
				if(group[i]) {
					asum += people[i];
				}else {
					bsum += people[i];
				}
			}
			ans = Math.min(ans, Math.abs(asum - bsum));
		}
	}
	
	static void visit(int from){
		visited[from] = true;
		visitcnt++;
		for(int i = 0; i < map[from].length; i++) {
			int to = map[from][i];
			if(!visited[to] && group[from] == group[to]) {
				visit(to);
			}
		}
	}
	
	static void groupping(int sidx, int agroup){
		if(0<agroup && agroup < N) {
			visitcheck();
		}
		
		for(int i = sidx; i < N; i++) {
			if(!group[i]) {
				group[i] = true;
				groupping(i+1, agroup+1);
				group[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		people = new int[N+1];
		map = new int[N+1][];
		ans = Integer.MAX_VALUE;
		
		for(int i=1; i <= N; i++) {
			people[i] = sc.nextInt();
		}
		
		for(int i=1; i <= N; i++) {
			int len = sc.nextInt();
			map[i] = new int[len];
			for(int j = 0; j < len; j++) {
				map[i][j] =sc.nextInt();
			}
		}
		
		group = new boolean[N+1];
		groupping(1, 0);
		if(ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}
}
