package _0416;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class G4_나무재테크_16235 {
	static int N;
	static int M;
	static int K;
	static int[][] map;
	static int[][] copymap;
	static PriorityQueue<tree> pq;
	static Queue<tree> deadtree;
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	static class tree implements Comparable<tree> {
		int r;
		int c;
		int age;

		tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(tree o) {
			return this.age - o.age;
		}
	}
	
	static boolean range(int r,int c) {
		if(1<=r && r <= N &&1<=c && c <= N)
			return true;
		return false;
	}

	static void spring() {
		PriorityQueue<tree> tmp = new PriorityQueue<>();
		while (!pq.isEmpty()) {
			tree current = pq.poll();
			if (copymap[current.r][current.c] >= current.age) {
				copymap[current.r][current.c] -= current.age;
				current.age++;
				tmp.add(current);
			} else {
				deadtree.add(current);
			}
		}
		pq = tmp;
	}

	static void summer() {
		while (!deadtree.isEmpty()) {
			tree current = deadtree.poll();
			copymap[current.r][current.c] += current.age / 2;
		}
	}

	static void fall() {
		PriorityQueue<tree> tmp = new PriorityQueue<>();
		
		while(!pq.isEmpty()) {
			tree current = pq.poll();
			tmp.add(current);
			if(current.age % 5 == 0) {
				for(int d = 0; d < 8; d++){
					int nr = current.r + dr[d];
					int nc = current.c + dc[d];
					if(range(nr, nc)){
						tmp.add(new tree(nr,nc,1));
					}
				}
			}
		}
		pq = tmp;
	}

	static void winter() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				copymap[i][j] += map[i][j];
			}
		}
	}

	static void year() {
		for (int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		pq = new PriorityQueue<>();
		deadtree = new LinkedList<tree>();
		map = new int[N + 1][N + 1];
		copymap = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				copymap[i][j] = 5;
			}
		}

		for (int i = 0; i < M; i++) {
			pq.add(new tree(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		year();
		System.out.println(pq.size());
	}
}