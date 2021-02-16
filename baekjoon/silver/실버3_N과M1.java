import java.util.Scanner;

public class 실버3_N과M1 {
	static int n;
	static int m;
	static boolean[] arr;
	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		arr = new boolean[n + 1];
		m = sc.nextInt();
		result = new int[m];

		recur(0);
	}
	// idx 고른갯수, true 의 갯수와 같음
	// m 골라야할 갯수

	static void recur(int idx) {
		if (m == idx) {
			for (int i = 0; i < m; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++) {
			if(!arr[i]){
				arr[i] = true;
				result[idx] = i;
				recur(idx + 1);
				arr[i] = false;
			}
		}
	}
}
