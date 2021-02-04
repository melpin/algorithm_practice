import java.util.Arrays;
import java.util.Scanner;

public class D3_flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int dump = sc.nextInt();
			int[] arr = new int[100];

			for (int i = 0; i < 100; i++)
				arr[i] = sc.nextInt();
			
			while(dump-- > 0) {
				Arrays.sort(arr);
				arr[99]--;
				arr[0]++;
			}
			Arrays.sort(arr);
			int ans = arr[99] - arr[0];
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
