package _0302;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class S1_골드바흐의추측_6588 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		List<Integer> l = new ArrayList<Integer>();
		boolean[] grap = new boolean[1000001];
		grap[1] = true;
		for (int i = 2; i < 1000001; i++) {
			if (!grap[i]) {
				l.add(i);
				for (int j = 2; i * j < 1000001; j++) {
					grap[i * j] = true;
				}
			}
		}
		
		
		while (N != 0) {
			boolean goldbach = false;
			StringBuilder sb = new StringBuilder();
			
			for (Iterator<Integer> itr = l.iterator();itr.hasNext();) {
				int i = itr.next();
				if(i > N/2)
					break;
				if (!grap[N - i]) {
					sb.append(N).append(" = ").append(i).append(" + ").append(N-i);
					System.out.println(sb);
					goldbach = true;
					break;
				}
			}
			if(!goldbach) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
			
			N = sc.nextInt();
		}
	}

}
