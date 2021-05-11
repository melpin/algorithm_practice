package _0504;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class B3_약수구하기_2501 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		List<Integer> l = new LinkedList<Integer>();
		for(int i = 1; i <=N; i++) {
			if(N % i == 0)
				l.add(i);
		}
		if(K > l.size())
			System.out.println(0);
		else
			System.out.println(l.get(K-1));
	}

}
