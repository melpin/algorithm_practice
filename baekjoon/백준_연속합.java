package _0210;

import java.util.Scanner;

public class 백준_연속합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		int sum = arr[0];
		for (int i = 1; i < N; i++) {
			arr[i] = Integer.max(arr[i], arr[i] + arr[i - 1]);
			sum = Integer.max(sum, arr[i]);
			//이전숫자랑 지금 더해서 지금수보다 더 크다면 수열늘어난걸로 생각
			//음수부분도 크게 고려할 필요가 없음, 그 다음자리 숫자가 크면 갱신이 안되니
			//늘어난 수열값 계속 갱신
			
		}
		System.out.println(sum);
	}

}
