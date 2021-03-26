package others;

import java.util.Scanner;

public class D6_사람네트워크2_1263 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc<= T; tc++) {
			int ans = Integer.MAX_VALUE;
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 0)
						map[i][j] = 456654456;
				}
			}
			
			
			for(int k =0; k <N; k++) {
				for(int i =0; i <N;i++) {
					if(k == i)
						continue;
					for(int j =0; j <N; j++) {
						if(k==j || i == j)
							continue;
						map[i][j] = Integer.min(map[i][k] + map[k][j], map[i][j]);
					}
				}
			}

			for(int i = 0 ; i < N; i++) {
				int tmpsum = 0;
				for(int j = 0 ; j < N; j++) {
					if(i == j)
						continue;
					tmpsum +=map[i][j];
				}
				if(ans > tmpsum){
					ans = tmpsum;
				}
			}
			
			System.out.printf("#%d %d\n",tc,ans);
		}

	}

}
