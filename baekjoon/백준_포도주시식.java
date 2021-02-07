package _0210;

import java.util.Scanner;

public class 백준_포도주시식 {
	static int[] gp;
	static int[][] sumarr;
	static int N;

	static int max(int arr[]) {
		if(arr[0] >= arr[1] && arr[0] >= arr[2])
			return arr[0];
		else if(arr[1] >= arr[0] && arr[1] >= arr[2])
			return arr[1];
		else if(arr[2] >= arr[0] && arr[2] >= arr[1])
			return arr[2];
		return 1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int [] gp = new int[N+1];
		sumarr = new int [N+1][3];
		//idx번째를 안먹는 경우, 2칸 전에 먹어서 idx를 먹을경우, 1칸전에만 먹어서 먹을경우
		
		for(int i = 1; i < N+1; i++) 
			gp[i] = sc.nextInt();
		
		sumarr[1][1] = gp[1];
		
		for(int i = 2; i < N+1; i++) {
			sumarr[i][0] = max(sumarr[i-1]);
			sumarr[i][1] = max(sumarr[i-2]) + gp[i];
			sumarr[i][2] = sumarr[i-1][1] + gp[i];
		}
		System.out.println(max(sumarr[N]));
		
	}

}
