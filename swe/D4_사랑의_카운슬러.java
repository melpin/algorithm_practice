package _0203;

import java.util.Scanner;

public class D4_사랑의_카운슬러 {
	public static class Point {
		int X;
		int Y;
		Point(int X, int Y){
			this.X=X;
			this.Y=Y;
		}
	}
static boolean[] arr;
static Point[] parr;
	
	public static long recur(int idx) { // 3 이면 2^4승
		if(idx < 0) {
			long result = Long.MAX_VALUE;
			if(counter() == arr.length / 2) {
				long X = 0;
				long Y = 0;
				for(int i = 0; i < arr.length;i++) {
					X += arr[i] ? parr[i].X : -parr[i].X;
					Y += arr[i] ? parr[i].Y : -parr[i].Y;
					//true 면 +, false 면 -
				}
				result = X * X + Y * Y;
			}
			return result;
		}
		arr[idx] = false;
		long a = recur(idx -1);
		arr[idx] = true;
		long b = recur(idx -1);
		return Math.min(a, b);
	}
	
	static int counter() {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == true)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			long ans = 0;
			
			int N = sc.nextInt();
			parr = new Point[N];
			arr = new boolean[N];
			for (int i = 0; i < N; i++) {
				parr[i] = new Point(0,0);
				parr[i].X = sc.nextInt();
				parr[i].Y = sc.nextInt();
			}
			
			
			for(int i = 0; i < N; i++)
				arr[i] = false;
			ans = recur(N - 1);

			System.out.printf("#%d %s\n", tc, ans);
		}
	}
}
