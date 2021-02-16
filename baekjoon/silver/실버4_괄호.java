package _0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 실버4_괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		for(int i =0;i<N;i++) {
			String commend = br.readLine();
			boolean ans = true;
			Stack<Character> s = new Stack<Character>();
			
			for(int j = 0;j<commend.length(); j++) {
				if(commend.charAt(j) == '(')
					s.push(commend.charAt(j));
				else if(commend.charAt(j) == ')' && s.empty()){
					ans = false;
					break;
				}else {
					s.pop();
				}
			}
			if(ans && s.empty())
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
