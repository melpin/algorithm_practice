package others;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class G4_캐슬디펜스_17135 {
	static int N;
	static int M;
	static int D;
	static int[][] map;
	static boolean[] archer;
	static int maxkill;
	static int enemy;

	public static void selectArcher(int select, int idx) {
		if (select == 3) {
			startgame();
			return;
		}
		// 궁수 3 선택

		for (int i = idx; i < M; i++) {
			if (!archer[i]) {
				archer[i] = true;
				selectArcher(select + 1, i);
				archer[i] = false;
			}
		}
	}

	static class target {
		int i;
		int j;
		int distance;

		target(int i, int j, int distance) {
			this.i = i;
			this.j = j;
			this.distance = distance;
		}
	}

	public static void startgame() {
		int Currentline = N;
		int Currentenemy = enemy;
		int kill = 0;
		int[][] clonemap = new int[N][M];
		Queue<target> tlist = new LinkedList<target>();
		Queue<target> finalshot = new LinkedList<target>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				clonemap[i][j] = map[i][j];
			}
		}

		while (Currentenemy > 0) {
			for (int i = 0; i < M; i++) {
				if (archer[i]) {
					for (int line = Currentline - 1; line >= Currentline - D; line--) {
						for (int r = i - D; r < i + D + 1; r++) {
							int dis = getDistance(Currentline, i, line, r);
							if (range(line, r) && dis <= D && clonemap[line][r] == 1) {
								tlist.add(new target(line, r, dis));
								// 바로 죽이면 안되고 쏠수있는 애들중 왼쪽선택해서 죽이기
							}
						}
					}

					if (!tlist.isEmpty()) {
						target min_target = new target(N, M, D);
						while (!tlist.isEmpty()) {
							target t = tlist.poll();
							if ((min_target.distance > t.distance)
									|| min_target.distance == t.distance && min_target.j > t.j) {
								min_target = t;
							}
						}
						//한라인에 동시에 쏴야해서 저장, 같은 대상을 지정할수도 있음
						finalshot.add(min_target);
					}
				}
			}
			
			while (!finalshot.isEmpty()) {
				target t = finalshot.poll();
				if(clonemap[t.i][t.j] == 1) {
					clonemap[t.i][t.j] = 0;
					Currentenemy--;
					kill++;
				}
			}
			//이번라인에서 타겟을 선정했다면 한번에 쏘기
			
			Currentline--;
			for (int i = 0; i < M; i++) {
				if (clonemap[Currentline][i] == 1) {
					clonemap[Currentline][i] = 0;
					Currentenemy--;
				}
				// 한줄당김, 성이있는칸으로가면 게임 제외
			}
		}
		maxkill = Integer.max(maxkill, kill);
	}

	static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	static boolean range(int i, int j) {
		if (0 <= i && i < N && 0 <= j && j < M)
			return true;
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		archer = new boolean[M];
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1)
					enemy++;
			}
		}
		selectArcher(0, 0);
		System.out.println(maxkill);
	}

}
