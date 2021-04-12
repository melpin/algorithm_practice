package _0408;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1_물통_2251 {
	static boolean[] ans;
	static boolean[][][] state;
	static Queue<bottle> q;
	static int A;
	static int B;
	static int C;

	static class bottle {
		int A;
		int B;
		int C;

		bottle(int a, int b, int c) {
			this.A = a;
			this.B = b;
			this.C = c;
		}
	}

	static void bfs() {
		while(!q.isEmpty()) {
			bottle cur = q.poll();
			if(state[cur.A][cur.B][cur.C])
				continue;
			state[cur.A][cur.B][cur.C] = true;
			if (cur.A == 0)
				ans[cur.C] = true;
			
			// c -> a
			if ((A - cur.A) <= cur.C) q.add(new bottle(A, cur.B, cur.C - (A - cur.A)));
			else  q.add(new bottle(cur.A + cur.C, cur.B, 0));
			// c -> b
			if ((B - cur.B) <= cur.C) q.add(new bottle(cur.A, B, cur.C - (B - cur.B)));
			else q.add(new bottle(cur.A, cur.B + cur.C, 0));
			// a -> b
			if ((B - cur.B) <= cur.A) q.add(new bottle(cur.A - (B - cur.B), B, cur.C));
			else  q.add(new bottle(0, cur.A + cur.B, cur.C));
			// a -> c
			if ((C - cur.C) <= cur.A) q.add(new bottle(cur.A - (C - cur.C), cur.B, C));
			else q.add(new bottle(0, cur.B, cur.A + cur.C));
			// b -> a
			if ((A - cur.A) <= cur.B) q.add(new bottle(A, cur.B - (A - cur.A), cur.C));
			else  q.add(new bottle(cur.A + cur.B, 0, cur.C));
			// b -> c
			if ((C - cur.C) <= cur.B) q.add(new bottle(cur.A, cur.B - (C - cur.C), C));
			else  q.add(new bottle(cur.A, 0, cur.B+cur.C));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		state = new boolean[201][201][201];
		ans = new boolean[201];

		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		q = new LinkedList<bottle>();
		q.add(new bottle(0, 0, C));
		bfs();

		for(int i =0; i <=200; i++)
			if(ans[i])
			System.out.print(i+" ");

	}

}
