package _0325;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1_숨바꼭질_1697 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		int max = 100001;
		int[] arr = new int[max];
		boolean[] visit = new boolean[max];

		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(N);
		visit[N] = true;
		int target = 0;
		while (!visit[K]){
			int cnum = q.poll();
			
			target = cnum+1;
			if (0<= target && target < max && !visit[target]){
				arr[target] = arr[cnum] + 1;
				visit[target] = true;
				q.add(target);
			}
			target = cnum-1;
			if (0<= target && target < max && !visit[target]){
				arr[target] = arr[cnum] + 1;
				visit[target] = true;
				q.add(target);
			}
			target = cnum*2;
			if (0<= target && target < max && !visit[target]){
				arr[target] = arr[cnum] + 1;
				visit[target] = true;
				q.add(target);
			}
		}
		System.out.println(arr[K]);
	}
}
