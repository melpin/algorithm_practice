package _0304;

import java.util.Scanner;

public class G4_텀프로젝트_9466 {
	static int[] map;
	static int[] CycleCount;
	static boolean[] visited;
	static int N;
	static int cnt;
	
	static int DFS(int from) {
		CycleCount[from]++;
		if(CycleCount[from] == 2){
			cnt--;
			visited[from] = true;
			return from;
		}
		
		int CycleNode = 0;
		if(!visited[map[from]]) {
			 CycleNode = DFS(map[from]);
			 visited[map[from]] = true;
		}
		
		if(CycleNode != 0 && CycleNode != from){
			cnt --;
			visited[from] = true;
			return CycleNode;
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			N = sc.nextInt();

			map = new int[N + 1];
			CycleCount = new int[N + 1];
			visited = new boolean[N + 1];

			for (int i = 1; i <= N; i++) {
				map[i] = sc.nextInt();
			}

			cnt = N;
			for (int i = 1; i <= N; i++) {
				if (!visited[i]){
					DFS(i);
					visited[i] = true;
				}
			}
			System.out.println(cnt);
		}
	}

}
