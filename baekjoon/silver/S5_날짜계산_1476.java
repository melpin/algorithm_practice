package _0322;

import java.util.Scanner;

public class S5_날짜계산_1476 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		int ecnt = 1;
		int scnt = 1;
		int mcnt = 1;
		int range = 15 * 28 * 19;
		
		int ans = 0;
		int i = 1;
		while(true){
			if(ecnt == E && scnt == S && mcnt == M) {
				ans = i;
				break;
			}
			ecnt++;
			scnt++;
			mcnt++;
			i++;
			if(ecnt == 16) ecnt = 1;
			if(scnt == 29) scnt = 1;
			if(mcnt == 20) mcnt = 1;
		}
		System.out.println(ans);
	}

}
