package others;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class G5_연구소_14502 {
	static int N;
	static int M;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	static class pos{
		int r;
		int c;
		pos(int r, int c){
			this.r=r;
			this.c=c;
		}
	}
	
	static boolean range(int i, int j) {
		if(0<=i &&i<N && 0<=j && j<M)
			return true;
		return false;
	}
	
	static int[][] deepcopy(int[][] arr){
		int [][]result = new int[N][M];
		for(int i = 0; i < N;i++) {
			for(int j = 0; j < M;j++) {
				result[i][j]=map[i][j];
			}
		}
		return result;
	}
	
	static int spraed(int arr[][]){
		Queue<pos> q = new LinkedList<pos>();
		int cnt = 0;
		for(int i = 0; i < N;i++) {
			for(int j = 0; j < M;j++) {
				if(arr[i][j] == 2)
					q.add(new pos(i,j));
				if(arr[i][j] == 0)
					cnt++;
			}
		}
		while(!q.isEmpty()) {
			pos current = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = current.r+dr[d];
				int nc = current.c+dc[d];
				if(range(nr,nc) && arr[nr][nc] == 0) {
					arr[nr][nc] = 2;
					cnt--;
					q.add(new pos(nr,nc));
				}
			}
		}
		return cnt;
	}
	
	static pos[] selectarr;
	static boolean []selected;
	static int []select;
	static int zerosize;
	static int ans;
	static void combination(int idx, int cnt){
		if(cnt == 3) {
			int[][] copymap = deepcopy(map);
			for(int i =0; i <3; i++) {
				copymap[selectarr[select[i]].r][selectarr[select[i]].c] = 1;
			}
			ans = Integer.max(ans, spraed(copymap));
			return;
		}
		
		for(int i =idx; i < zerosize;i++) {
			if(!selected[i]) {
				select[cnt] = i;
				selected[i] = true;
				combination(i, cnt+1);
				selected[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		ans = 0;
		List<pos> l = new ArrayList<pos>();
		
		for(int i = 0; i < N;i++) {
			for(int j = 0; j < M;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] ==0)
					l.add(new pos(i,j));
			}
		}
		
		zerosize = l.size();
		selectarr = l.toArray(new pos[zerosize]);
		selected = new boolean[zerosize];
		select = new int[3];
		
		combination(0,0);
		System.out.println(ans);
	}
}
