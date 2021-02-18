package _0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_덱_10866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[20001];
		int front = 10000;
		int back = 10000;

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String commend = br.readLine();

			if (commend.contains("push_front")) {
				StringTokenizer st = new StringTokenizer(commend, " ");
				st.nextToken();
				arr[--front] = Integer.parseInt(st.nextToken());
			} else if (commend.contains("push_back")) {
				StringTokenizer st = new StringTokenizer(commend, " ");
				st.nextToken();
				arr[back++] = Integer.parseInt(st.nextToken());
			} else if (commend.contains("pop_front")) {
				if (front != back) {
					System.out.println(arr[front++]);
				} else
					System.out.println(-1);
			} else if (commend.contains("pop_back")) {
				if (front != back) {
					System.out.println(arr[--back]);
				} else
					System.out.println(-1);
			} else if (commend.contains("size")) {
				System.out.println(back - front);
			} else if (commend.contains("empty")) {
				if (front == back)
					System.out.println(1);
				else
					System.out.println(0);
			} else if (commend.contains("front")) {
				if (front != back) {
					System.out.println(arr[front]);
				} else
					System.out.println(-1);
			} else if (commend.contains("back")) {
				if (front != back) {
					System.out.println(arr[back - 1]);
				} else
					System.out.println(-1);
			}

		}
	}

}
