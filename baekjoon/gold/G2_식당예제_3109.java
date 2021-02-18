import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2_식당예제_3109 {
	static int[] dr = { -1, 0, 1 };
	static int[] dc = { 1, 1, 1 };
	static int R;
	static int C;
	static boolean[][] used;
	static int cnt;

	static boolean check(int i, int j) {
		if (0 <= i && i < R && !used[i][j])
			return true;
		return false;
	}

	static boolean search(int i, int j) {
		boolean searchResult = false;
		if (j == C - 1) {
			cnt++;
			return true;
		}
		
		int go= 0;
		for (int d = 0; d < 3; d++) {
			int tmpi = i + dr[d];
			int tmpj = j + dc[d];
			if (check(tmpi, tmpj))
				searchResult = search(tmpi, tmpj);
			else
				go++;
			if (searchResult) {
				used[tmpi][tmpj] = true;
				break;
			}
		}
		if(go == 3)
			used[i][j] = true;
		return searchResult;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		used = new boolean[R][C];
		cnt = 0;
		
		String s;
		for (int i = 0; i < R; i++) {
			s = br.readLine();
			for (int j = 0; j < C; j++) {
				if (s.charAt(j) == 'x')
					used[i][j] = true;
			}
		}
		for (int i = 0; i < R; i++) {
			search(i, 0);
		}

		System.out.println(cnt);
	}

}
