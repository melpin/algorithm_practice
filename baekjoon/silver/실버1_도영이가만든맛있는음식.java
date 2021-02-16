import java.util.Scanner;

public class 실버1_도영이가만든맛있는음식 {
	static boolean[] isSelected;
	static int[] S;
	static int[] B;
	static int N;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		isSelected = new boolean[N];
		S = new int[N];
		B = new int[N];
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			S[i] = sc.nextInt();
			B[i] = sc.nextInt();
		}
		recur(0, 0);
		System.out.println(ans);
	}

	static void recur(int idx, int start) {
		if (idx == N) {
			int tmpS = 1;
			int tmpB = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					tmpS *= S[i];
					tmpB += B[i];
				}
			}
			if(tmpS == 1 && tmpB ==0) // 전부 false
				return;
			ans = Integer.min(ans, tmpS > tmpB ? tmpS - tmpB : tmpB - tmpS);
			return;
		}

		for (int i = start; i < N; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				recur(idx + 1, i + 1);
				isSelected[i] = false;
				recur(idx + 1, i + 1);
			}
		}
	}
}
