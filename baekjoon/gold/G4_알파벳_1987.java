package _0419;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class G4_알파벳_1987 {
	static int R;
	static int C;
	static int ans;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static char [][] map;
	
	static boolean range(int r,int c) {
		if(0<= r && r < R && 0<= c && c < C)
			return true;
		return false;
	}
	
	
	static void dfs(int r, int c, Set<Character> set, int cnt){
		ans = Integer.max(ans, cnt);
		
		for(int d= 0; d < 4;d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(range(nr,nc) && !set.contains(map[nr][nc])){
				set.add(map[nr][nc]);
				dfs(nr,nc,set, cnt + 1);
				set.remove(map[nr][nc]);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		Set<Character> set = new HashSet<>();
		
		for(int i =0; i <R; i++) {
			String s = sc.next();
			for(int j =0; j <C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		set.add(map[0][0]);
		dfs(0,0, set, 1);
		
		System.out.println(ans);
	}

}
