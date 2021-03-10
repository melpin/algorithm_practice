package _0311;

import java.util.Arrays;
import java.util.Scanner;

public class S1_공유기설치_2110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int C = sc.nextInt();
		int[] house = new int [N];
		for(int i = 0; i < N; i ++) {
			house[i] = sc.nextInt();
		}
		Arrays.sort(house);
		
		long min = 1;
		long max = house[N-1] - house[0];
		long ans = 0;
		while(min <= max) {
			long move = (max + min) / 2;
			int cnt = 1;
			int currentpos = house[0];
			for(int i = 1; i < N; i ++) {
				if(currentpos + move <= house[i]) {
					currentpos = house[i];
					cnt++;
				}
			}
			
			if(cnt >= C) {
				ans = Long.max(ans, move);
				min = move+1;
			}else {
				max = move-1;
			}
		}
		System.out.println(ans);
		
	}

}
