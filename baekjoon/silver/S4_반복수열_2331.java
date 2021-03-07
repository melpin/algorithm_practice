package _0304;

import java.util.Scanner;

public class S4_반복수열_2331 {

	static int recur(int nA, int P) {
		int sum = 0;
		while(nA > 0) {
			int cNum = nA % 10;
			nA /= 10;
			int sumNum = 1;
			for(int i = 0; i < P; i++) {
				sumNum *= cNum;
			}
			sum += sumNum;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int startA = sc.nextInt();
		int P = sc.nextInt();
		int[] arr = new int[1000000];
		
		int idx = 0;
		arr[0] = startA;
		int ans =0;
		done:while(true){
			arr[idx+1] = recur(arr[idx],P);
			for(int i = 0; i < idx; i++) {
				if(arr[idx+1] == arr[i]) {
					ans = i;
					break done;
				}
			}
			idx++;
		}
		System.out.println(ans);
	}

}
