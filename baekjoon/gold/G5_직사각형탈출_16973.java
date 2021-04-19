package _0415;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class G5_직사각형탈출_16973 {
	static int H;
	static int W;
	static int N;
	static int M;
	static boolean[][] visited;
	static Queue<pos> q;
	static List<pos> blocks;
	static pos target;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int ans;
	
	static class pos{
		int r;
		int c;
		int cnt;
		pos(int r,int c, int cnt){
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static boolean range(int r, int c) {
		if (1 <= r && r <= N && 1 <= c && c <= M)
			return true;
		return false;
	}

	static boolean square(int r, int c) {
		Iterator<pos> itr = blocks.iterator();
		while(itr.hasNext()) {
			pos block = itr.next();
			if(r <= block.r && block.r < r + H && c <= block.c && block.c < c+W)
				return false;
		}
		return true;
	}
	
	static void bfs() {
		while(!q.isEmpty()){
			pos current = q.poll();
			if(current.r == target.r && current.c == target.c) {
				ans = current.cnt;
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = current.r+dr[d];
				int nc = current.c+dc[d];
				
				if(range(nr,nc) && range(nr + H - 1,nc + W - 1) && square(nr, nc) && !visited[nr][nc]){
					visited[nr][nc] = true;
					q.add(new pos(nr,nc,current.cnt+1));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visited = new boolean[N + 1][M + 1];
		blocks = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(sc.nextInt() == 1) {
					blocks.add(new pos(i,j,-1));
				}
			}
		}
		q = new LinkedList<pos>();
		H = sc.nextInt();
		W = sc.nextInt();
		ans = -1;
		
		int startr = sc.nextInt();
		int startc = sc.nextInt();
		visited[startr][startc] = true;
		q.add(new pos(startr, startc, 0));
		target = new pos(sc.nextInt(), sc.nextInt(), -1);
		bfs();
		System.out.println(ans);
	}
}