package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 골드1_구간합구하기_2042 {
	public static long init(long[] tree, long[] arr, int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
			return tree[node];
		}

		int mid = (start + end) / 2;
		tree[node] = init(tree, arr, node * 2, start, mid) + init(tree, arr, node * 2 + 1, mid + 1, end);
		return tree[node];
	}

	public static void update(long[] tree, int node, int start, int end, int modIdx, long diff) {
		if (!(start <= modIdx && modIdx <= end)) {
			return;
		}
		tree[node] += diff;
		if (start != end) { // 같으면 마지막노드이므로 더 들어갈 필요 없음
			int mid = (start + end) / 2;
			update(tree, node * 2, start, mid, modIdx, diff);
			update(tree, node * 2 + 1, mid + 1, end, modIdx, diff);
		}
	}

	public static long sum(long[] tree, int node, int start, int end, int left, int right) {
		if (left > end || right < start) { // 검색범위 밖이면 검색안함
			return 0;
		}

		if (left <= start && end <= right) {// 검색 범위 안의 노드이면 합중 일부이므로 바로 반환
			return tree[node];
		}
		int mid = (start + end) / 2;
		return sum(tree, node * 2, start, mid, left, right) + sum(tree, node * 2 + 1, mid + 1, end, left, right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());

		long[] arr = new long[N + 1];

		int treesize = 1;
		while (true) {
			treesize *= 2;
			if (treesize > N) {
				treesize *= 2;
				break;
			}
		}
		long[] tree = new long[treesize];
		// N max 2^20 >= 1000000 -> tree size maximum 2^21;

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		init(tree, arr, 1, 1, N);

		for (int i = 0; i < M + K; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int commend = Integer.parseInt(stk.nextToken());
			if (commend == 1) {
				int modIdx = Integer.parseInt(stk.nextToken());
				long change = Long.parseLong(stk.nextToken());
				update(tree, 1, 1, N, modIdx, change - arr[modIdx]);
				arr[modIdx] = change; // 다음번에 이 노드를 또 수정하게된다면 위에 계산이 잘못될수있기때문에 수정 
			} else {
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				System.out.println(sum(tree, 1, 1, N, a, b));
			}
		}
	}
}
