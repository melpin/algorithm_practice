package _0421;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class G3_maaaaaaaze_16985 {
	static int[][][][] maze;
	static int mazesize = 5;
	static boolean[] selected;
	static int[] selectnum;
	static int[] selectedcycle;
	static int ans;
	static int[]dx = {0,1,0,-1,0,0};
	static int[]dy = {-1,0,1,0,0,0};
	static int[]dz = {0,0,0,0,-1,1};
	static boolean[][][] visited;
	
	static class pos{
		int x;
		int y;
		int z;
		int cnt;
		pos(int x,int y,int z,int cnt){
			this.x=x;
			this.y=y;
			this.z=z;
			this.cnt=cnt;
		}
	}
	
	static boolean range(int x, int y, int z) {
		if(0<=x && x < mazesize && 0<=y && y < mazesize && 0<=z && z < mazesize)
			return true;
		return false;
	}
	
	static int[][] cyclemaze(int map[][]){
		int [][]cyclemap = new int[mazesize][mazesize];
		
		for(int i = 0;i < mazesize;i++) {
			for(int j = 0; j < mazesize;j++) {
				cyclemap[j][mazesize - i - 1] = map[i][j];
			}
		}
		return cyclemap;
	}
	
	static void permutation(int select){
		if(select == mazesize) {
			game();
			return;
		}
		
		for(int i = 0; i < mazesize; i++) {
			if(!selected[i]) {
				selected[i] = true;
				selectnum[select] = i;
				for(int c = 0; c <4; c++){
					selectedcycle[select] = c;
					permutation(select+1);
				}
				selected[i] = false;
			}
		}
	}
	
	static void deepcopy(int map[][][]){
		for(int i = 0; i < mazesize;i++) {
			for(int j = 0;j < mazesize;j++) {
				for(int k = 0; k < mazesize;k++) {
					map[i][j][k] = maze[selectnum[i]][selectedcycle[i]][j][k];
				}
			}
		}
	}
	
	static void game(){
		if(maze[selectnum[0]][selectedcycle[0]][0][0] == 1 && maze[selectnum[4]][selectedcycle[4]][4][4] == 1){
			int [][][]map = new int[mazesize][mazesize][mazesize];
			visited = new boolean[mazesize][mazesize][mazesize];
			deepcopy(map);
			bfs(0,0,0,0,map);
		}
	}
	
	static void bfs(int x, int y,int z, int cnt, int[][][] map) {
		Queue<pos> q = new LinkedList<pos>();
		
		visited[x][y][z] = true;
		q.add(new pos(x,y,z,cnt));
		
		while(!q.isEmpty()) {
			pos current = q.poll();
			
			if(current.x == 4&&current.y == 4&&current.z == 4) {
				if(ans == -1) {
					ans = current.cnt;
				}else {
					ans = Integer.min(ans, current.cnt);
				}
				break;
			}
			
			for(int d = 0; d < 6; d++) {
				int nx = current.x + dx[d];
				int ny = current.y + dy[d];
				int nz = current.z + dz[d];
				if(range(nx, ny, nz) && map[nx][ny][nz] == 1 && !visited[nx][ny][nz]){
					visited[nx][ny][nz] = true;
					q.add(new pos(nx,ny,nz,current.cnt+1));
				}
			}	
		}		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		maze = new int[mazesize][4][mazesize][mazesize];
		selected = new boolean[mazesize];
		selectnum = new int[mazesize];
		selectedcycle = new int[mazesize];
		ans = -1;
		for(int i = 0; i < mazesize;i++) {
			for(int j = 0;j < mazesize;j++) {
				for(int k = 0; k < mazesize;k++) {
					maze[i][0][j][k] = sc.nextInt();
				}
			}
		}
		
		for(int i = 0; i < mazesize; i++) {
			for(int c = 1;c <4; c++) {
				maze[i][c] = cyclemaze(maze[i][c-1]);
			}
		}
		permutation(0);
		System.out.println(ans);
	}
}