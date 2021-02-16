//package _0217;
//
//import java.util.Scanner;
//
//public class 실버5_수정렬하기2 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int maxnum = 2000001;
//
//		int N = sc.nextInt();
//		boolean[] num = new boolean[maxnum];
//
//		for (int i = 0; i < N; i++)
//			num[sc.nextInt() + 1000000] = true;
//		// 마이너스도 있음 ㅇㅇ
//
//		for (int i = 0; i < maxnum; i++) {
//			if (num[i]) System.out.println(i - 1000000);
//		}
//	}
//}
package _0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 실버5_수정렬하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int maxnum = 2000001;

		int N = Integer.parseInt(br.readLine());
		boolean[] num = new boolean[maxnum];

		for (int i = 0; i < N; i++)
			num[Integer.parseInt(br.readLine()) + 1000000] = true;
		// 마이너스도 있음 ㅇㅇ

		for (int i = 0; i < maxnum; i++)
			if(num[i]) sb.append((i - 1000000)).append('\n');
		System.out.print(sb);
	}
}
