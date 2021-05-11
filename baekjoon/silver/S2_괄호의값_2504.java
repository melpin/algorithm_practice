package _0504;

import java.util.Scanner;
import java.util.Stack;

public class S2_괄호의값_2504 {
	static String s;
	static Stack<String> stack;
	
	static int loopcheck(String matched, String notmatched, int value){
		int sum = 0;
		while(!stack.isEmpty()){
			String nc = stack.pop();
			if(nc.equals(matched)) {
				sum *= value;
				stack.push(Integer.toString(sum));
				return sum;
			}else if(nc.equals(notmatched)){
				return -1;
			}else {
				sum += Integer.parseInt(nc);
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		stack = new Stack<>();
		s = sc.next();
		
		boolean flag = true;
		for(int i = 0; i < s.length(); i++) {
			String c = s.substring(i, i+1);
			if(c.equals("(") || c.equals("["))
				stack.push(c);
			else if(!stack.isEmpty()){
				if(c.equals(")")) {
					if(stack.peek().equals("(")) {
						stack.pop();
						stack.push("2");
					}else {
						if(loopcheck("(", "[", 2) == -1) {
							flag = false;
							break;
						}
					}
				}else {
					if(stack.peek().equals("[")) {
						stack.pop();
						stack.push("3");
					}else {
						if(loopcheck("[", "(", 3) == -1) {
							flag = false;
							break;
						}
					}
				}
			}else {
				flag = false;
				break;
			}
		}
		int ans = 0;
		while(!stack.isEmpty()){ 
			String pop = stack.pop();
			if(pop.equals("(") || pop.equals("[")){
				flag = false;
				break;
			}
			ans += Integer.parseInt(pop);
		}
		if(flag) {
			System.out.println(ans);			
		}else {
			System.out.println(0);
		}
	}
}