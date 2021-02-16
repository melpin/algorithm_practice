import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 실버3_N과M3 {
	static int n;
	static int m;
	static int[] result;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String nm = br.readLine();
		StringTokenizer stkn = new StringTokenizer(nm, " ");
		n = Integer.parseInt(stkn.nextToken());
		m = Integer.parseInt(stkn.nextToken());
		result = new int[m];
		sb = new StringBuilder();

		comb(0);
		System.out.println(sb);
	}
	// idx 고른갯수, true 의 갯수와 같음
	// m 골라야할 갯수

	static void comb(int idx){
		if (m == idx) {
			
			for (int i = 0; i < m; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
				result[idx] = i;
				comb(idx + 1);
		}
	}
}
