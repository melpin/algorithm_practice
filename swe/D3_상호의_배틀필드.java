import java.util.Scanner;

public class D3_상호의_배틀필드 {
	static char map[][];
	static int d[][] = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
	//L, R, U, D
	static int H;
	static int W;
	static int x;
	static int y;

	static boolean rc(int i, int j) {
		if (i >= 0 && i < H && j >= 0 && j < W)
			return true;
		return false;
	}

	static void shoot(int dir) {
		int shoot_x = x;
		int shoot_y = y;
		while (true) {
			shoot_x += d[dir][0];
			shoot_y += d[dir][1];
			if (!rc(shoot_x, shoot_y)) // 범위안에없으면 브레이크
				break;
			else if (map[shoot_x][shoot_y] == '*') { // 벽돌은 부서진다
				map[shoot_x][shoot_y] = '.';
				break;
			} else if (map[shoot_x][shoot_y] == '#')// 강철은 아무일도 일어나지않음
				break;
		}
	}

	static void move(char tank, int dir) {
		// 전차가 바라보는 방향을 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
		int tmp_x = x + d[dir][0];
		int tmp_y = y + d[dir][1];
		if (rc(tmp_x, tmp_y) && map[tmp_x][tmp_y] == '.') {
			map[x][y] = '.';
			x = tmp_x;
			y = tmp_y;
			map[x][y] = tank;
		} else {
			map[x][y] = tank;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();

			x = 0;
			y = 0;
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String tmp = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = tmp.charAt(j);
					//시작지점 찾기
					if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == 'v' || map[i][j] == '^') {
						x = i;
						y = j;
					}
				}
			}

			int N = sc.nextInt();
			char move[] = new char[N];
			String moves = sc.next();
			for (int i = 0; i < N; i++) {
				move[i] = moves.charAt(i);
			}
			// R, L, U, D

			for (char m : move) {
				char tank = map[x][y];
				int dir = 0;
				if (m == 'S') {
					if (tank == '<')
						dir = 0;
					else if (tank == '>')
						dir = 1;
					else if (tank == '^')
						dir = 2;
					else if (tank == 'v')
						dir = 3;
					shoot(dir);
				} else {
					if (m == 'L') {
						tank = '<';
						dir = 0;
					} else if (m == 'R') {
						tank = '>';
						dir = 1;
					} else if (m == 'U') {
						tank = '^';
						dir = 2;
					} else if (m == 'D') {
						tank = 'v';
						dir = 3;
					}
					move(tank, dir);
				}
			}

			System.out.printf("#%d ", tc);
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
