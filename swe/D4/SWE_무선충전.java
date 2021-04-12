package _0412_course;

import java.util.Scanner;

public class SWE_무선충전 {
	static int[] dr = { 0, -1, 0, 1, 0 };
	static int[] dc = { 0, 0, 1, 0, -1 };
	static int A;
	static int anssum;
	static userinfo userA;
	static userinfo userB;
	static adapter[] adapters;

	static class userinfo {
		int r;
		int c;
		int[] moves;

		public userinfo(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class adapter {
		int r;
		int c;
		int range;
		int power;

		public adapter(int c, int r, int range, int power) {
			this.r = r;
			this.c = c;
			this.range = range;
			this.power = power;
		}
	}

	static int getdistance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}

	static void charge() {
		boolean[] connectedA = new boolean[A];
		boolean[] connectedB = new boolean[A];

		for (int i = 0; i < A; i++) {
			if (adapters[i].range >= getdistance(adapters[i].r, adapters[i].c, userA.r, userA.c))
				connectedA[i] = true;
			if (adapters[i].range >= getdistance(adapters[i].r, adapters[i].c, userB.r, userB.c))
				connectedB[i] = true;
		}

		int maxsum = 0;
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < A; j++) {
				if (i == j && connectedA[i] && connectedB[j])
					maxsum = Integer.max(maxsum, adapters[i].power);
				else
					maxsum = Integer.max(maxsum,
							(connectedA[i] ? adapters[i].power : 0) + 
							(connectedB[j] ? adapters[j].power : 0));
			}
		}
		anssum += maxsum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int M = sc.nextInt(); // move
			A = sc.nextInt(); // adapter
			anssum = 0;
			adapters = new adapter[A];
			userA = new userinfo(1, 1);
			userB = new userinfo(10, 10);
			userA.moves = new int[M];
			userB.moves = new int[M];
			for (int i = 0; i < M; i++)
				userA.moves[i] = sc.nextInt();
			for (int i = 0; i < M; i++)
				userB.moves[i] = sc.nextInt();
			for (int i = 0; i < A; i++)
				adapters[i] = new adapter(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());

			charge();
			for (int t = 0; t < M; t++) {
				userA.r += dr[userA.moves[t]];
				userA.c += dc[userA.moves[t]];

				userB.r += dr[userB.moves[t]];
				userB.c += dc[userB.moves[t]];

				charge();
			}

			System.out.printf("#%d %d\n", tc, anssum);
		}

	}

}
