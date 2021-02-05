package _0210;

import java.util.Scanner;

public class 백준_오르막수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[10];
		int[] tmp = new int[10];
		
		for (int i = 0; i < 10; i++)
			arr[i] = 1;
		//첫자리에 나올수있는 경우의 수
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++)
				tmp[j] = 0;
			//j로 끝나는 조합의 갯수를 저장하기위해 초기화
			
			for(int j=0;j<10;j++) {//시작자리수
				for(int k = 0; k < 10 - j; k++) {//다음자리수
					tmp[j+k] = (tmp[j+k] + arr[j]) % 10007;
				}
			}
			for (int j = 0;  j< 10; j++)
				arr[j] = tmp[j];
		}
		long ans = 0;
		for(long a : arr)
			ans = (ans + a) % 10007;

		System.out.println(ans);
	}
}
