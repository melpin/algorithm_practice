package _0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class S3_에디터_1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> Fronts = new Stack<Character>();
		Stack<Character> backs = new Stack<Character>();
		for(char c:br.readLine().toCharArray())
			Fronts.add(c);
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			String cmd = br.readLine();
			if(cmd.equals("L")) { // left move
				if(!Fronts.empty())
					backs.push(Fronts.pop());
			}else if(cmd.equals("D")) { // right move
				if(!backs.empty())
					Fronts.push(backs.pop());
			}else if(cmd.equals("B")) { // delete
				if(!Fronts.empty())
					Fronts.pop();
			}else {
				StringTokenizer stk = new StringTokenizer(cmd, " ");
				stk.nextToken(); // P
				Fronts.push(stk.nextToken().charAt(0));
			}
		}
		
		StringBuffer sb = new StringBuffer();
		while(!Fronts.empty())
			backs.push(Fronts.pop());
		while(!backs.empty())
			sb.append(backs.pop());
		
		System.out.println(sb);
	}

}
