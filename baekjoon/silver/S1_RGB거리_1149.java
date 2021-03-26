package others;

import java.util.Scanner;

public class S1_RGB거리_1149 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] color = new int[N][3];
		int[][] painted = new int[N][3];
		
		for(int i = 0; i < N;i++) {
			color[i][0] = sc.nextInt(); // r
			color[i][1] = sc.nextInt(); // g
			color[i][2] = sc.nextInt(); // b
		}
		
		painted[0][0] = color[0][0];
		painted[0][1] = color[0][1];
		painted[0][2] = color[0][2];
		for(int i = 1;i<N;i++) {
			painted[i][0] =  color[i][0] +Integer.min(painted[i-1][1], painted[i-1][2]);
			painted[i][1] =  color[i][1] +Integer.min(painted[i-1][0], painted[i-1][2]);
			painted[i][2] =  color[i][2] +Integer.min(painted[i-1][0], painted[i-1][1]);
		}
		
		System.out.println(Integer.min(Integer.min(painted[N-1][0], painted[N-1][1]), painted[N-1][2]));
	}
}
