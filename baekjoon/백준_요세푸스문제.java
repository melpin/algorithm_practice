import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 백준_요세푸스문제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt() - 1;
		List<Integer> list = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++)
			list.add(i);
		int idx = 0;
		System.out.print("<");
		while(list.size() != 1){
			idx =  (idx + K) % list.size();
			int a = list.remove(idx);
			System.out.print(a+", ");
		}
		System.out.println(list.remove(0)+">");
	}
}
