import java.util.Scanner;

public class D4_Ladder1 {
	static int lader[][];
	static int pos[][] = {{0,1}, {0,-1}, {-1,0}};
	static int range = 10;
	//0 오른쪽 1 왼쪽 , 2 위로
	
	static boolean range_check(int i, int j) {
		if (i >= 0 && i < range && j >= 0 && j  < range)
			return true;
		return false;
	}
	
	static int search_lader(int idx) {
		int i = range - 1;
		int j = idx;
		int arrow = 2;
		
		while(true) {
			for(int af = 0; af < 3; af++) {
				int x = i + pos[af][0];
				int y = j + pos[af][1];
				if (range_check(x, y) && lader[x][y] == 1 && arrow != af) {
					arrow = af;
					break;
				}
			}
			if(arrow != 2) {
				while(true) {
					int x = i + pos[arrow][0];
					int y = j + pos[arrow][1];
					if (range_check(x, y) && lader[x][y] == 1) {
						i = x;
						j = y;
					}
					else {
						arrow = (arrow == 1) ? 0 : 1;
						break;
					}
				}
			}else {
				i = i + pos[arrow][0];
				j = j + pos[arrow][1];
			}
			
			if(i == 0) {
				return j;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int tc = 1; tc <= 1; tc++) {
			sc.nextInt();
			int ans = 0;
			lader = new int[range][range];
			
			for(int i = 0; i<range; i++) {
				for(int j = 0; j <range;j++) {
					lader[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i<range; i++) {
				if(lader[range - 1][i] == 2)
					ans = search_lader(i);
			}
			
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
