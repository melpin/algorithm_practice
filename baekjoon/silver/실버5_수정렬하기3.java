package _0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 실버5_수정렬하기3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int maxnum = 10001;

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[maxnum];

		for (int i = 0; i < N; i++)
			num[Integer.parseInt(br.readLine())]++;

		for (int i = 0; i < maxnum; i++) {
			for(int j = num[i]; j > 0; j --)
				sb.append(i+"\n");
		}
		System.out.print(sb);
	}
}