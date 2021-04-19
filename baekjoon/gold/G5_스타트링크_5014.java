package _0419;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class G5_스타트링크_5014 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int F = sc.nextInt();// total
		int []floor = new int[F+1];
		Arrays.fill(floor, -1);
		int S = sc.nextInt();
		int G = sc.nextInt();
		int U = sc.nextInt();
		int D = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(S);
		floor[S] = 0;
		
		while(!q.isEmpty() && floor[G] == -1){
			int current = q.poll();
			
			if(current+U <= F && floor[current+U] == -1){
				q.add(current+U);
				floor[current+U] = floor[current]+1;
			}
			
			if(current-D >= 1 && floor[current-D] == -1){
				q.add(current-D);
				floor[current-D] = floor[current]+1;
			}
		}
		if(floor[G] == -1) {
			System.out.println("use the stairs");
		}else {
			System.out.println(floor[G]);
		}
	}
}
