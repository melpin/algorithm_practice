package _0302;
import java.util.Scanner;

public class S3_팩토리얼0의개수_1676 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long ans = 1;
		int cnt = 0;
		while (N > 1) {
			ans = (ans *N--) % 100000000;
			if(ans % 10 == 0) {
				cnt++;
				ans /= 10;
			}
		}
		if(ans % 10 == 0) {
			cnt++;
			ans /= 10;
		}
		System.out.println(cnt);
	}
}