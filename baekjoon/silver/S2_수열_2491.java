package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_수열_2491 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] decseq = new int[N];
		int[] incseq = new int[N];
		for(int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		
		incseq[N-1] = 1;
		decseq[N-1] = 1;
		for(int i = N-2; i >= 0;i--){
			if (arr[i] <= arr[i+1]) {
				incseq[i] += incseq[i+1] + 1;
			}else {
				incseq[i] += 1;
			}
			
			if (arr[i] >= arr[i+1]) {
				decseq[i] += decseq[i+1] + 1;
			}else {
				decseq[i] += 1;
			}
		}
		int ans = 0;
		for(int i = 0; i < N; i++) {
			ans = Integer.max(ans,Integer.max(incseq[i], decseq[i]));
		}
		System.out.println(ans);
	}

}
