import java.util.Scanner;
import java.util.Stack;

public class D4_계산기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int tc =1; tc<=T;tc++) {
			sc.nextInt();
			String s = sc.next();
			
			Stack<Integer> stackc = new Stack<Integer>();
			
			for(int i = 0; i<s.length();i++) {
				int c = s.charAt(i);
				if(0x30 <= c && c <= 0x39) {
					stackc.push((int)(c - 0x30));
				}
				else if(c == '*') {
					int a = stackc.pop();
					i++;
					c = s.charAt(i) - 0x30;
					int r = a * c;
					stackc.push(r);
				}else {
					stackc.push(c);
				}
			}
			
			int sum = 0;
			while(!stackc.isEmpty()){
				int t = stackc.pop();
				if(t =='+')
					continue;
				sum += t;
			}
			System.out.printf("#%d %d\n",tc, sum);
		}
	}
}
