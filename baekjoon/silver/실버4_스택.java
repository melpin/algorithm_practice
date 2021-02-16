package _0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 실버4_스택 {

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[10000];
		int idx = 0;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i ++) {
			String commend = br.readLine();
			
			if(commend.contains("push")) {
				StringTokenizer st = new StringTokenizer(commend, " ");
				st.nextToken();
				arr[idx++] = Integer.parseInt(st.nextToken());
			}
			else if(commend.contains("pop")) {
				if(idx > 0) {
					System.out.println(arr[--idx]);
				}else
					System.out.println(-1);
			}else if(commend.contains("size")) {
				System.out.println(idx);
			}else if(commend.contains("empty")) {
				if(idx == 0)
					System.out.println(1);
				else
					System.out.println(0);
			}else if(commend.contains("top")) {
				if(idx > 0) {
					System.out.println(arr[idx - 1]);
				}else
					System.out.println(-1);
			}
		}
	}

}
