package _0222;

import java.util.Scanner;

public class S3_쇠막대기_10799 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int stick = 0;
		int cnt = 0;
		
		String cmd = sc.next();
		int length = cmd.length();
		int i = 0;
		while(i < length) {
			if(cmd.charAt(i) == '(' && cmd.charAt(i+1) == ')') {
				cnt += stick;
				i += 2;
			}
			else if(cmd.charAt(i) == '(') {
				stick++; i++;
			}else if(cmd.charAt(i) == ')'){
				stick--;
				cnt++;
				i++;
			}
		}
		System.out.println(cnt);
		

	}

}
