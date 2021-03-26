package others;

import java.util.PriorityQueue;
import java.util.Scanner;

public class D4_하나로_1251 {
	static class line implements Comparable<line>{
		int from;
		int to;
		double dis;
		
		line(){}
		line(int from, int to, double dis) {
			this.from = from;
			this.to = to;
			this.dis = dis;
		}
		@Override
		public int compareTo(line o) {
			if(this.dis > o.dis)
				return 1;
			else if(this.dis < o.dis)
				return -1;
			return 0;
		}
	}

	static double E;
	static double Escore(int p1x,int p1y,int p2x, int p2y) {
		return E * (Math.pow((p1x - p2x), 2) + Math.pow((p1y - p2y), 2));
	}
	
	static int N;
	static int[] parent = new int[N+1];
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
	

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			int[] islandx = new int[N+1];
			int[] islandy = new int[N+1];
			parent = new int[N+1];
			
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}
			for (int i = 1; i <= N; i++)
				islandx[i] = sc.nextInt();
			for (int i = 1; i <= N; i++)
				islandy[i] = sc.nextInt();
			E = sc.nextDouble();
			
			double ans = 0;
			PriorityQueue<line> q = new PriorityQueue<>();
			for(int i = 1 ; i <= N; i++) {
				for(int j = 1 ; j <= N; j++) {
					if(i == j)continue;
					if(parent[j] == parent[i]) continue;
					double score = Escore(islandx[i], islandy[i],islandx[j], islandy[j]);
					q.add(new line(i, j, score));
				}
			}
			
			while(!q.isEmpty()) {
				line current = q.poll();
				if(getParent(current.from) == getParent(current.to))
					continue;
				setParent(current.from, current.to);
				ans += current.dis;
			}

			System.out.printf("#%d %.0f\n", tc, ans);
		}

	}

}
