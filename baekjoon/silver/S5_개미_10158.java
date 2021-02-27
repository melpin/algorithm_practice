package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_개미_10158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int W = Integer.parseInt(stk.nextToken());
		int H = Integer.parseInt(stk.nextToken());
		stk = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(stk.nextToken());
		int q = Integer.parseInt(stk.nextToken());
		int t = Integer.parseInt(br.readLine());

		int x = (p + t) % (2 * W);
		int y = (q + t) % (2 * H);
		if (x > W)
			x = 2 * W - x;
		if (y > H)
			y = 2 * H - y;
		StringBuilder sb = new StringBuilder();
		sb.append(x).append(" ").append(y);
		
		System.out.println(sb);
	}
}
