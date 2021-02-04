import java.util.Arrays;
import java.util.Scanner;

public class D3_진기의_최고급_붕어빵 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc =1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			String result = "Possible";
			
			int times[] = new int[N];
			for(int i=0; i < N; i++) {
				times[i] = sc.nextInt();
			}
			Arrays.sort(times);
			
			
			for(int i = 0; i<N;i++){
				int tmp = times[i] / M;
				tmp = tmp * K - (i + 1);
				if(tmp < 0) {
					result = "Impossible";
					break;
				}
			}
			
			System.out.printf("#%d %s\n", tc, result);
		}
	}
}
