package _0210;

import java.util.Scanner;

public class 백준_더하기123 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int arr[] = new int[11];
			arr[1] = 1;
			arr[2] = 1;
			arr[3] = 1;

			for (int i = 1; i <= N; i++) {
				if (i + 1 < 11)
					arr[i + 1] += arr[i];
				if (i + 2 < 11)
					arr[i + 2] += arr[i];
				if (i + 3 < 11)
					arr[i + 3] += arr[i];
			}

			System.out.println(arr[N]);
		}
	}
}
