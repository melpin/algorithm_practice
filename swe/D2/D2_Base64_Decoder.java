package _0126;

import java.util.Scanner;

public class D2_Base64_Decoder {
	static int parsedata(int input) {
		if('A' <= input && input <= 'Z')
			return input - 'A';
		else if('a' <= input && input <= 'z')
			return input - 71;
		else if('0' <= input && input <= '9')
			return input + 4 ;
		else if (input == '+')
			return 62;
		else if(input == '/')
			return 63;
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		for(int tc = 1; tc <=T; tc++) {
			StringBuilder ans = new StringBuilder();
			StringBuilder buf = new StringBuilder();
			String input = sc.nextLine();
			
			for(int i = 0; i < input.length(); i++) {
				String s = String.format("%06d", 
					Integer.parseInt(
						Integer.toBinaryString(
							parsedata(input.charAt(i))
						)
					));
				buf.append(s);
				if(i % 4 == 3) {
					for(int j = 0; j < 24; j +=8) {
						int b = Integer.parseInt(buf.substring(j, j+8), 2);
						ans.append((char)b);
					}
					buf.delete(0, 24);
				}
			}
			System.out.printf("#%d %s\n",tc,ans);
		}
		
	}
}
