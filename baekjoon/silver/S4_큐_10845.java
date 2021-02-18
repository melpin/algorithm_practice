package _0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_큐_10845 {

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[10000];
		int front = 0;
		int back = 0;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i ++) {
			String commend = br.readLine();
			
			if(commend.contains("push")) {
				StringTokenizer st = new StringTokenizer(commend, " ");
				st.nextToken();
				arr[back++] = Integer.parseInt(st.nextToken());
			}
			else if(commend.contains("pop")) {
				if(front != back) {
					System.out.println(arr[front++]);
				}else
					System.out.println(-1);
			}else if(commend.contains("size")) {
				System.out.println(back - front);
			}else if(commend.contains("empty")) {
				if(front == back)
					System.out.println(1);
				else
					System.out.println(0);
			}else if(commend.contains("front")) {
				if(front != back) {
					System.out.println(arr[front]);
				}else
					System.out.println(-1);
			}else if(commend.contains("back")) {
				if(front != back) {
					System.out.println(arr[back-1]);
				}else
					System.out.println(-1);
			}
			
		}
	}

}
