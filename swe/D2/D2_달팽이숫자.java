import java.util.Scanner;

public class D2_달팽이숫자 {
	static boolean range_check(int i, int top, int bottom){
		if(bottom <= i && i < top)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int tc = 1; tc <=T; tc++) {
			int size = sc.nextInt();
			int arr[][] = new int [size][size];
			
			int idx = 1;
			int i = 0;
			int j = 0;
			int bottom = 0;
			int top = size;
			int maxidx = size * size;
			while(idx <= maxidx) {
				for(;range_check(j, top, bottom);j++)
					arr[i][j] = idx++;
				i++;
				j--;
				for(;range_check(i, top, bottom);i++)
					arr[i][j] = idx++;
				i--;
				j--;
				top--;
				for(;range_check(j, top, bottom);j--)
					arr[i][j] = idx++;
				i--;
				j++;
				bottom++;
				for(;range_check(i, top, bottom);i--)
					arr[i][j] = idx++;
				i++;
				j++;
			}
			System.out.println("#"+tc);
			for(i = 0; i < size; i++) {
				for(j = 0; j < size; j++)
					System.out.printf("%d ", arr[i][j]);
				System.out.println();
			}
		}
	}
}
