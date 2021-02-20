package _0222;

import java.util.Scanner;

public class P4_요세푸스문제2_1168 {
	
	public static int init(int[][] tree, int[] arr, int node, int start, int end) {
		if (start == end) {
			tree[node][0] = 1;
			tree[node][1] = arr[start];
			return tree[node][0];
		}
		int mid = (start + end) / 2;
		tree[node][0] = init(tree, arr, node * 2, start, mid) + init(tree, arr, node * 2 + 1, mid + 1, end);
		return tree[node][0];
	}

	public static void update(int[][] tree, int node, int start, int end, int pIdx) {
		tree[node][0] -= 1;
		if (start == end) {
			return;
		}
		
		int mid = (start + end) / 2;
		if (tree[node * 2][0] < pIdx) {
			update(tree, node * 2 + 1, mid + 1, end, pIdx - tree[node * 2][0]);
			return;
		}
		update(tree, node * 2, start, mid, pIdx);
		
		
	}

	public static int searchNext(int tree[][], int node, int start, int end, int sIdx) {
		if (start == end)
			return tree[node][1];

		if (tree[node * 2][0] < sIdx) {
			return searchNext(tree, node * 2 + 1, (start + end) / 2 + 1, end, sIdx - tree[node * 2][0]);
		}
		return searchNext(tree, node * 2, start, (start + end) / 2, sIdx);
	}

	public static void yosep(int[][] tree, int N, int K) {
		int idx = 1;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = N; i > 0; i--) {
			idx = (idx + K - 1) % (i + 1) + ((idx + K - 1) / (i + 1));
			while(idx / (i+1)>0) {
				idx = idx % (i + 1) + (idx / (i + 1));
			}
			// 모듈러한 갯수만큼 더해주고 모듈러하면 다음위치를 정확히 찾음
			// 더한값이 또 크면 계속나눠줌
			sb.append(searchNext(tree, 1, 1, N, idx)+", ");
			update(tree, 1, 1, N, idx);
			//dprint(tree);
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.deleteCharAt(sb.lastIndexOf(" "));
		sb.append(">");
		System.out.println(sb);
	}

	public static void dprint(int[][] tree) {
		int line = 1;
		for (int j = 1; j < tree.length; j++) {
			if (j == line) {
				System.out.println();
				for (int k = tree.length; k > line; k /= 2)
					System.out.print("\t");
				line *= 2;
			}
			System.out.print(tree[j][0] + "\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = i;
		int treesize = 1;
		while (true) {
			treesize *= 2;
			if (treesize >= N) {
				treesize *= 2;
				break;
			}
		}
		int[][] tree = new int[treesize][2]; // 0 count, 1 num
		init(tree, arr, 1, 1, N);
		yosep(tree, N, K);

	}
}
