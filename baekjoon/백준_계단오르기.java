package _0210;

import java.util.Scanner;

public class 백준_계단오르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] stair = new int[N+1];
		int[][] sum = new int[N+1][2];

		for(int i = 1; i<=N; i++)
			stair[i] = sc.nextInt();
		
		sum[1][0] = stair[1];
		
		for(int i = 2; i<=N; i++) {
			sum[i][1] = sum[i-1][0] + stair[i];
			sum[i][0] = Integer.max(sum[i-2][0] + stair[i], sum[i-2][1] + stair[i]);
			//두칸갈꺼임 기존값, 모든경우에서 2칸 갈 수 있기 때문에
			//[i][0] i번째 칸에 이전에서 2칸씩 건너 올라온 경우
			//[i][1] i번째 칸에 이전에서 1칸올라와, 2칸 연속인 경우
		}
		System.out.println(Integer.max(sum[N][0], sum[N][1]));
	}

}
