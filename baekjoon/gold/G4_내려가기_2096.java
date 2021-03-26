package others;

import java.util.Scanner;

public class G4_내려가기_2096 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int [][]map = new int[N][3];
		int [][]minslide = new int[2][3];
		int [][]maxslide = new int[2][3];
		
		for(int i = 0; i < N; i ++) {
			for(int j = 0; j < 3; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int j = 0; j < 3; j++) {
			minslide[0][j] = map[0][j];
			maxslide[0][j] = map[0][j];
		}
		
		for(int i = 1; i < N; i ++) {
			minslide[i%2][0] = Integer.min(minslide[(i-1)%2][0], minslide[(i-1)%2][1]) + map[i][0];
			minslide[i%2][1] = Integer.min(Integer.min(minslide[(i-1)%2][0], minslide[(i-1)%2][1]), minslide[(i-1)%2][2]) + map[i][1];
			minslide[i%2][2] = Integer.min(minslide[(i-1)%2][1], minslide[(i-1)%2][2]) + map[i][2];
			
			maxslide[i%2][0] = Integer.max(maxslide[(i-1)%2][0], maxslide[(i-1)%2][1]) + map[i][0];
			maxslide[i%2][1] = Integer.max(Integer.max(maxslide[(i-1)%2][0], maxslide[(i-1)%2][1]), maxslide[(i-1)%2][2]) + map[i][1];
			maxslide[i%2][2] = Integer.max(maxslide[(i-1)%2][1], maxslide[(i-1)%2][2]) + map[i][2];
		}
		
		int maxans = Integer.max(Integer.max(maxslide[(N-1)%2][0], maxslide[(N-1)%2][1]), maxslide[(N-1)%2][2]);
		int minans = Integer.min(Integer.min(minslide[(N-1)%2][0], minslide[(N-1)%2][1]), minslide[(N-1)%2][2]);
		
		System.out.println(maxans+" "+minans);
	}

}
