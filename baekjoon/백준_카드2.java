import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++)
			q.offer(i);
		
		while(true) {
			if(q.size() == 1)
				break;
			q.poll();
			q.offer(q.poll());
		}
		System.out.println(q.poll());
	}
}
