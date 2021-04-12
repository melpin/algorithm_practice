package others;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class G2_다리만들기2_17472 {
	static int N;
	static int M;
	static int[] islandParent;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] map;
	static PriorityQueue<line> pq;
	static int ans;
	static int islandcnt;
	
	static class pos{
		int i;
		int j;
		pos(int i,int j){
			this.i= i;
			this.j = j;
		}
	}
	
	static class line implements Comparable<line>{
		int from;
		int to;
		int distance;
		line(int from, int to, int distance){
			this.from=from;
			this.to=to;
			this.distance=distance;
		}
		@Override
		public int compareTo(line o) {
			return this.distance - o.distance;
		}
	}
	static boolean range(int r, int c) {
		if(0<=r && r<N && 0<=c && c<M)
			return true;
		return false;
	}
	
	static int getParent(int i){
		while(islandParent[i] != i) {
			i = islandParent[i];
		}
		return i;
	}
	
	static void setParent(int i, int j){
		int iParent = getParent(i);
		int jParent = getParent(j);
		if(iParent < jParent) {
			islandParent[jParent] = iParent;
		}else {
			islandParent[iParent] = jParent;
		}
	}
	
	static void searchisland() {
		islandcnt=0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1)
					setislandnumber(new pos(i,j), 2 + islandcnt++);
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0)
					searchline(new pos(i,j), map[i][j]);
			}
		}
		
		while(!pq.isEmpty()) {
			line currentline = pq.poll();
			if(getParent(currentline.from) == getParent(currentline.to))
				continue;
			setParent(currentline.from, currentline.to);
			ans += currentline.distance;
		}
		
		int parent = getParent(2);
		for(int i =2; i < 2+islandcnt; i++) {
			if(parent != getParent(i)) {
				ans=-1;
				break;
			}
		}
		//모든섬이 연결이 안되어있으면 -1
	}
	
	static void searchline(pos c, int start){
		for(int d = 0; d < 4; d++) {
			int nr = c.i;
			int nc = c.j;
			int length = 0;
			while(true){
				nr = nr + dr[d];
				nc = nc + dc[d];
				if(!range(nr,nc))
					break; // 연결없음
				if(map[nr][nc] != 0 && map[nr][nc] == start)
					break; // 자기사진의 섬
				if(map[nr][nc] != 0 && map[nr][nc] != start){
					if(length > 1)
						pq.add(new line(start, map[nr][nc], length));
					break; // 다른 섬을 찾음
				}
				length++;
			}
		}
	}
	
	static void setislandnumber(pos c, int number) {
		Queue<pos> q = new LinkedList<pos>();
		q.add(c);
		map[c.i][c.j] = number;
		while(!q.isEmpty()) {
			pos current = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = current.i + dr[d];
				int nc = current.j + dc[d];
				if(range(nr,nc) && map[nr][nc] == 1) {
					map[nr][nc] = number;
					q.add(new pos(nr,nc));
				}
			}
		}
	}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ans = 0;
		map = new int[N][M];
		islandParent = new int[8]; // 2 ~ 7번 사용
		pq = new PriorityQueue<>();
		for(int i =2; i <8;i++)
			islandParent[i]=i;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		searchisland();
		System.out.println(ans);
	}
}
