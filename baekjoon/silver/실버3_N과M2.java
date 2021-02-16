import java.util.Scanner;

public class 실버3_N과M2 {
	static int n;
	static int m;
	static boolean[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		arr = new boolean[n + 1];
		m = sc.nextInt();

		comb(0, 1);
	}
	// idx 고른갯수, true 의 갯수와 같음
	// m 골라야할 갯수

	static void comb(int idx, int stnum) {
		if (m == idx) {
			for (int i = 1; i <= n; i++) {
				if (arr[i]) System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for (int i = stnum; i <= n; i++) {
			if(!arr[i]){
				arr[i] = true;
				comb(idx + 1, i+1);
				arr[i] = false;
			}
		}
	}
}
