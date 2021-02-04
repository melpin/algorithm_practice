import java.util.Scanner;
import java.util.Stack;

public class D4_괄호짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		for(int tc = 1; tc<=10; tc++) {
			int ans = 1;
			
			Stack<Character> s = new Stack<Character>();
			sc.nextInt();
			String str = sc.next();
			for(int i = 0; i < str.length();i++) {
				char c = str.charAt(i);
				if(c == ')') {
					char peek = s.pop();
					if(peek != '(') {
						ans = 0;
						break;
					}
				}
				else if(c == ']') {
					char peek = s.pop();
					if(peek != '[') {
						ans = 0;
						break;
					}
				}
				else if(c == '>') {
					char peek = s.pop();
					if(peek != '<') {
						ans = 0;
						break;
					}
				}
				else if(c == '}') {
					char peek = s.pop();
					if(peek != '{') {
						ans = 0;
						break;
					}
				}
				else {
					s.push(c);
				}
				// '()', '[]', '{}', '<>'
			}
			
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
