package others;

import java.util.Scanner;

public class D3_01Knapsack_3282 {
	static class item{
		int V;
		int C;
		item(int V, int C){
			this.V = V;
			this.C=C;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1 ;tc <=T; tc++) {
			int ans = 0;
			int N = sc.nextInt();
			int K = sc.nextInt();
			item []items = new item[N];
			int[][] knapsack = new int[K+1][N]; // k무게 
			
			
			for(int i = 0 ; i < N; i++) {
				items[i] = new item(sc.nextInt(), sc.nextInt());
			}
			
			for(int i=1; i < K+1; i++) {
				if(i >=items[0].V)
					knapsack[i][0] = items[0].C;
				for(int j = 1; j <N; j++){
					if(0<=i - items[j].V)
						knapsack[i][j] = Integer.max(items[j].C +knapsack[i - items[j].V][j-1] ,knapsack[i][j-1]);
					else
						knapsack[i][j] = knapsack[i][j-1];
				}
			}
			ans = knapsack[K][N-1];
			
			System.out.printf("#%d %d\n", tc, ans);
		}

	}

}
