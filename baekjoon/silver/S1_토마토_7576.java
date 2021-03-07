package _0308;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1_토마토_7576 {
	static int R;
	static int C;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};

	static boolean range(int i, int j) {
		if (0 <= i && i < R&& 0 <= j && j < C)
			return true;
		return false;
	}
	
	static class pos{
		int i;
		int j;
		pos(int i, int j){
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();
		map = new int[R][C];
		
		Queue<pos> s = new LinkedList<pos>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					s.add(new pos(i, j));
				}
			}
		}
		
		while(!s.isEmpty()){
			pos current = s.poll();
			for(int d = 0; d < 4; d++) {
				int tmpi =  current.i + dr[d];
				int tmpj = current.j + dc[d];
				if(range(tmpi, tmpj) && map[tmpi][tmpj] == 0){
					map[tmpi][tmpj] = map[current.i][current.j]+1;
					s.add(new pos(tmpi, tmpj));
				}
			}
		}
		
		int maxans = 0;
		FalseBreak:for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				maxans = Integer.max(maxans, map[i][j]);
				if(map[i][j] == 0) {
					maxans = 0;
					break FalseBreak;
				}
			}
		}
		
		System.out.println(maxans -1);

	}

}
