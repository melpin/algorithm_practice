import java.util.Scanner;

public class D3_민석이의_과제_체크하기 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// 수강생 수
			int K = sc.nextInt();// 과제제출 수

			boolean[] student = new boolean[N + 1];
			for (int i = 1; i < N + 1; i++)
				student[i] = false;
			//학생수만큼 배열 초기화
			
			for (int i = 0; i < K; i++) 
				student[sc.nextInt()] = true;
			//과제제출한 학생 수만큼 돌면서 체크

			System.out.print("#"+ tc+" ");
			for (int i = 1; i < N + 1; i++) {
				if(!student[i])
					System.out.print(i+" ");
			}

		}
	}

}
