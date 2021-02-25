package others;

import java.util.Scanner;

public class S1_경비원_2564 {
	static int R; // 가로
	static int C; // 세로

	public static int go(int[] from, int[] to) {
		// 1 북 ,2 남, 3 서, 4 동
		// 북 남의경우 서쪽에서의 거리
		// 동 서의경우 북쪽에서의 거리
		if (from[0] == to[0]) // 같으면 거리 뺀것만큼 바로 리턴
			return Integer.max(from[1], to[1]) - Integer.min(from[1], to[1]);
		else if (from[0] == 1 || from[0] == 2) {
			if (to[0] == 1 || to[0] == 2) {
				return Integer.min(C + 2 * R - from[1] - to[1], C + from[1] + to[1]);
			} else if (from[0] == 1 && to[0] == 3) { // 북에서 서로갈땐 무조건 왼쪽으로 가는게 빠름
				return from[1] + to[1];
			} else if (from[0] == 2 && to[0] == 3) { // 남에서 서로갈땐 무조건 왼쪽
				return from[1] + C - to[1];
			} else if (from[0] == 1 && to[0] == 4) { // 북에서 동갈때 무조건 오른쪽
				return R - from[1] + to[1];
			} else if (from[0] == 2 && to[0] == 4) { // 남에서 동갈때 무조건 오른쪽
				return R - from[1] + C - to[1];
			}
		} else {
			if (to[0] == 3 || to[0] == 4) {
				return Integer.min(2 * C + R - from[1] - to[1], R + from[1] + to[1]);
			} else if (from[0] == 3 && to[0] == 1) { // 서에서 북으로갈때
				return from[1] + to[1];
			} else if (from[0] == 3 && to[0] == 2) { // 서에서 남으로갈때
				return C - from[1] + to[1];
			} else if (from[0] == 4 && to[0] == 1) { // 동에서 북갈때
				return from[1] + R - to[1];
			} else if (from[0] == 4 && to[0] == 2) { // 동에서 남갈때
				return C - from[1] + R - to[1];
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		int N = sc.nextInt();
		int[][] arr = new int[N + 1][2];
		for (int i = 1; i < N + 1; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		arr[0][0] = sc.nextInt();
		arr[0][1] = sc.nextInt();

		int sum = 0;
		for (int i = 1; i < N+1; i++) {
			sum += go(arr[0], arr[i]);
		}
		System.out.println(sum);

	}

}
