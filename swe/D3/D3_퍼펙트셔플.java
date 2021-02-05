import java.util.Scanner;

public class D3_퍼펙트셔플 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			String[] sarr = new String[N];
			for (int i = 0; i < N; i++)
				sarr[i] = sc.next();

			int mid = N / 2;
			if (N % 2 == 1)
				mid += 1;

			System.out.print("#" + tc + " ");
			try {
				for (int i = 0; i < mid; i++) {
					System.out.print(sarr[i] + " ");
					System.out.print(sarr[i + mid] + " ");
				}
			} catch (Exception e) {
			}

			System.out.println();
		}
	}
}
