import java.util.Arrays;
import java.util.Scanner;

public class 백준_일곱난쟁이 {
	static int[] arr;
	static boolean[] selected;
	static int N = 9;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		arr = new int[N];
		selected = new boolean[N];
		for(int i =0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		recur(0);
	}
	
	static void recur(int idx) {
		if(idx == arr.length) {
			int cnt = 0;
			int sum = 0;
			int[] tmp = new int[N];
			for(int i =0;i<arr.length;i++) {
				if(selected[i]) {
					tmp[i] = arr[i];
					sum += arr[i];
					cnt ++;
				}
			}
			if(cnt == 7 && sum == 100) {
				Arrays.sort(tmp);
				for(int i =2;i<arr.length;i++) {
					System.out.println(tmp[i]);
				}
				System.exit(0);
			}
			return;
		}
		selected[idx] = true;
		recur(idx+1);
		selected[idx] = false;
		recur(idx+1);
	}
}
