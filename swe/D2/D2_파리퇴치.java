import java.util.Scanner;

public class D2_파리퇴치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int [][]arr = new int[N][N];
			int ans = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i <= N - M; i++) {
				for(int j = 0; j <= N - M; j++) {
					int sum = 0;
					for(int k = i; k < i + M; k++) {
						for(int l = j; l < j + M; l++) {
							sum+= arr[k][l];
						}
					}
					if(sum > ans) ans = sum;
					
				}
			}
			
			System.out.printf("#%d %d\n",tc, ans);
		}
	}
}
