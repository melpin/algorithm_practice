package _0217;

import java.util.Arrays;
import java.util.Scanner;

public class 실버4_카드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long [] arr = new long[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextLong();

		Arrays.sort(arr);

		int maxcnt = 1;
		long ans = arr[0];
		int cnt = 1;
		long currentNum = arr[0];
		for (int i = 1; i < N; i++) {
			if (arr[i] == currentNum) {
				cnt++;
			} else {
				if (cnt > maxcnt) {
					maxcnt = cnt;
					ans = currentNum;
				}
				currentNum = arr[i];
				cnt = 1;
			}
		}
		if (cnt > maxcnt) {
			ans = currentNum;
		}

		System.out.println(ans);

	}

}
