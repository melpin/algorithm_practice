import java.util.Scanner;

public class D2_최빈수구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			sc.nextInt(); // dumy
			int ans = 0;
			
			int []arr = new int [101];
			for(int i =0;i<101;i++)
				arr[i] = 0; 
			for(int i =0;i<1000;i++)
				arr[sc.nextInt()]++; 
			
			for(int i =0;i<101;i++) {
				if(arr[i] >= arr[ans])
					ans = i;
			}
			
			System.out.printf("#%d %d\n",tc, ans);
		}
	}

}
