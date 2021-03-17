package _0315;

import java.util.Scanner;

public class SWE_수영장 {
	static int day;
	static int month;
	static int Tmonth;
	static int year;
	static int []Cal;
	
	static int calc(int current, int sum){
		if(current == 13)
			return sum;
		
		int r1 = Integer.MAX_VALUE;
		int r2 = Integer.MAX_VALUE;
		int r3 = Integer.MAX_VALUE;
		if(current + 3 <= 13){
			r1 = calc(current+3, sum + Tmonth);
		}
		if(current + 1 <= 13) {
			r2 = calc(current+1, sum + month);
			r3 = calc(current+1, sum + Cal[current] * day);
		}
		return Integer.min(r1, Integer.min(r2, r3));
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc<= T;tc++) {
			day = sc.nextInt();
			month = sc.nextInt();
			Tmonth = sc.nextInt();
			year = sc.nextInt();
			int ans = year;
			
			Cal = new int[13];
			for(int i =1; i <= 12; i++) {
				Cal[i] = sc.nextInt();
			}
			
			ans = Integer.min(ans, calc(1, 0));
			System.out.printf("#%d %d\n",tc, ans);
		}

	}

}
