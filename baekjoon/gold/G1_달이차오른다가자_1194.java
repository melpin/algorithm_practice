package _0419;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class G1_달이차오른다가자_1194 {
	static int N;
	static int M;
	static char[][] map;
	static boolean[][][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	static class info{
		int r;
		int c;
		int cnt;
		int state;
		info(int r, int c,int cnt, int state){
			this.r=r;
			this.c=c;
			this.cnt=cnt;
			this.state=state;
		}
	}
	
	static boolean range(int r, int c) {
		if(0<= r && r < N && 0<= c && c < M)
			return true;
		return false;
	}
	
	static void bfs(int sr, int sc) {
		Queue<info> q = new LinkedList<info>();
		visited[sr][sc][0] = true;
		q.add(new info(sr,sc,0,0));
		
		while(!q.isEmpty()) {
			info cinfo = q.poll();
			
			for(int d =0; d< 4; d++) {
				int nr = cinfo.r+ dr[d];
				int nc = cinfo.c+ dc[d];
				if(range(nr, nc) && !visited[nr][nc][cinfo.state]){
					switch (map[nr][nc]) {
					case '.':
						visited[nr][nc][cinfo.state] = true;
						q.add(new info(nr,nc,cinfo.cnt+1,cinfo.state));
						break;
					case '1':
						System.out.println(cinfo.cnt+1);
						System.exit(0);
						break;
					case '#':
						break;
					default:
						if(Character.isLowerCase(map[nr][nc])) {
							int nstate = cinfo.state | (1 << (map[nr][nc] - 'a'));
							visited[nr][nc][nstate] = true;
							q.add(new info(nr,nc, cinfo.cnt+1, nstate));
						}else {
							if((cinfo.state & (1 << (map[nr][nc] - 'A'))) >= 1){
								visited[nr][nc][cinfo.state] = true;
								q.add(new info(nr,nc, cinfo.cnt+1, cinfo.state));
							}
						}
						break;
					}
				}
			}
		}
		System.out.println(-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int r = 0;
		int c = 0;
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		visited = new boolean[N][M][64]; // all key b0011 1111 63
		for(int i =0; i <N; i++) {
			String s = sc.next();
			for(int j =0; j < M;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == '0') {
					r = i;
					c = j;
					map[i][j]='.';
				}
			}
		}
		bfs(r,c);
	}
}
