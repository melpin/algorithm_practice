import java.util.Scanner;

public class D3_한빈이와SpotMart {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc= 1; tc<=T; tc++) {
			int ans = -1;
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] snack = new int[N];
			for(int i =0;i<N;i++)
				snack[i] = sc.nextInt();
			
			for(int i = 0; i<N;i++) {
				for(int j = i+1; j < N; j++) {
					int tmpsum = snack[i] + snack[j];
					if(tmpsum <= M)
						ans = Integer.max(ans, tmpsum);
				}
			}
			
			System.out.printf("#%d %d\n", tc, ans);
		}
		
	}
}
