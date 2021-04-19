package _0419;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class G3_소수의연속합_1644 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		boolean[] sieve = new boolean[N+1];
		List<Integer> l = new LinkedList<Integer>();
		for(int i = 2; i <= N;i++) {
			if(!sieve[i]) {
				l.add(i);
				int k = 1;
				while(i * k <= N) {
					sieve[i*k] = true;
					k++;
				}
			}
		}
		
		
		int sum = 0;
		int cnt = 0;
		Iterator<Integer> fromitr = l.iterator();
		Iterator<Integer> toitr = l.iterator();
		while(fromitr.hasNext()){
			if(sum == N) {
				cnt++;
				sum -= fromitr.next();
			}else if(sum > N) {
				sum -= fromitr.next();
			}else if(sum < N && toitr.hasNext()){
				sum += toitr.next();
			}else if(sum < N && !toitr.hasNext()){
				break;
			}
		}
		System.out.println(cnt);
	}
}
