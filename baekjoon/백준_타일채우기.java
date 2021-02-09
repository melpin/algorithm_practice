package _0210;

import java.util.Scanner;

public class 백준_타일채우기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int arr[] = new int[40];
		arr[0] = 1;

		for (int i = 2; i <= N; i += 2) {
			arr[i] = arr[i - 2] * 3;
			for(int j = i - 4; j >=0; j-=2) {
				arr[i] += arr[j] * 2;
			}
		}
		//홀수는 계산못함
		//2칸전에 조합에 1,2,, 2,1 두가지 경우의 수가 올수있고
		//4칸전의 조합에 1,2,1,2 로 하는 두가지경우 수가 올 수 있음

		System.out.println(arr[N]);
	}
}
