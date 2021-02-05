import java.util.Scanner;

public class D4_정사각형방 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int [][] arr;
	static int [][] darr;
	static int N;
	
	static boolean range(int i, int j) {
		if(i >=0 && i < N &&
			j >=0 && j < N)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new int [N][N];
			darr = new int [N][N];
			
			for(int i = 0; i< N; i++) {
				for(int j = 0; j < N;j++) {
					arr[i][j] = sc.nextInt();
					darr[i][j] = -1;
				}
			}
			
			for(int i = 0; i< N; i++) {
				for(int j = 0; j < N;j++) {
					for(int d =0; d<4;d++) {
						int tmr = i + dr[d];
						int tmc = j + dc[d];
						if(range(tmr,tmc) && arr[tmr][tmc] == arr[i][j] + 1){
							darr[i][j] = d; 
							// 어느쪽으로 가야하는지 체크
							//갈 방향없으면 -1 그대로
						}
					}
				}
			}
			
			int ans = 0;
			int startnum = N*N;
			for(int i = 0; i< N; i++) {
				for(int j = 0; j < N;j++) {
					int count = 1;
					int cr = i;
					int cc = j;
					
					while(true) {
						int nd = darr[cr][cc];
						if(nd == -1) // 더이상 갈곳이없으면 break
							break;
						cr += dr[nd];
						cc += dc[nd];
						count++;
					}
					
					if(count > ans){
						ans = count;
						startnum = arr[i][j];
					}else if(count == ans) {
						startnum = Integer.min(startnum, arr[i][j]);
					}
				}
			}
			
			System.out.printf("#%d %d %d\n",tc, startnum, ans);
			//움직인 방 갯수, 시작하는 방 번호
		}
	}
}
