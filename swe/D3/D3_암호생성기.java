import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D3_암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int T = 10;
		
		for(int tc = 1; tc<=T; tc++) {
			Queue<Integer> q = new LinkedList<Integer>();
			sc.nextInt();
			for(int i =0; i<8; i++) 
				q.offer(sc.nextInt());
			
			while(true) {
				int tmp = 0;
				for(int i = 1; i <=5; i++) {
					tmp = q.poll() - i;
					if (tmp <= 0) {
						tmp = 0;
						break;
					}
					q.offer(tmp);
				}
				if(tmp == 0) {
					q.offer(tmp);
					break;
				}
			}
			System.out.printf("#%d ", tc);
			int len = q.size();
			for(int i =0 ;i< len;i++)
				System.out.print(q.poll()+" ");
			
		}
	}
}
