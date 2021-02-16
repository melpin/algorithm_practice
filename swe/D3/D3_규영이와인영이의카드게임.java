import java.util.Scanner;

public class D3_규영이와인영이의카드게임 {
	static int gyugamepoint;
	static int ingamepoint;
	static int gyuscore;
	static int inscore;
	static int[] gyucard;
	static int[] incard;
	static boolean[] selected;
	static int cardnumber = 9;
	
	
	static void game(int idx, int resum) {
		if(gyuscore > inscore + resum) {
			int tmp = 1;
			for(int i = cardnumber - idx; i>0; i--)
				tmp *=i;
			gyugamepoint += tmp;
			return;
		}else if((gyuscore  + resum < inscore)) {
			int tmp = 1;
			for(int i = cardnumber - idx; i>0; i--)
				tmp *=i;
			ingamepoint += tmp;
			return;
		}
		
		if (idx == cardnumber) {
			if(gyuscore > inscore)
				gyugamepoint ++;
			else if(gyuscore < inscore)
				gyugamepoint ++;
			return;
		}

		for (int i = 0; i < cardnumber; i++) {
			if (!selected[i]) {
				selected[i] = true;
				gyuscore += gyucard[idx] > incard[i]? gyucard[idx] + incard[i] : 0;
				inscore += gyucard[idx] < incard[i]? gyucard[idx] + incard[i] : 0;
				game(idx + 1, resum - gyucard[idx] - incard[i]);
				selected[i] = false;
				gyuscore -= gyucard[idx] > incard[i]? gyucard[idx] + incard[i] : 0;
				inscore -= gyucard[idx] < incard[i]? gyucard[idx] + incard[i] : 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			gyucard = new int[9];
			incard = new int[9];
			selected = new boolean[9];
			gyuscore = 0;
			inscore = 0;
			gyugamepoint = 0;
			ingamepoint = 0;

			for (int i = 0; i < 9; i++)
				gyucard[i] = sc.nextInt();
			// 규영이 카드 입력 받음

			int idx = 0;
			int sum = 0; // 모든 카드뭉치의 합
			boolean pass = true;
			for (int i = 1; i <= 18; i++) {
				pass = false;
				sum += i;
				for (int j = 0; j < 9; j++) {
					if (gyucard[j] == i) {
						pass = true;
						break;
					}
				}
				if (!pass)
					incard[idx++] = i;
			}
			// 인영이 카드 설정

			game(0, sum);
			System.out.printf("#%d %d %d\n", tc, gyugamepoint, ingamepoint);
		}

	}

}
