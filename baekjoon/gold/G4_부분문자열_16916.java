package _0511;

import java.util.Scanner;

public class G4_부분문자열_16916 {
	
	static int[] getpi(String p) {
		int []pi = new int[p.length()];
		int j = 0;
		
		for(int i = 1; i < p.length();i++) {
			while(j > 0 && p.charAt(i) != p.charAt(j)) {
				j = pi[j-1];
			}
			if(p.charAt(i) == p.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}
	
	
	static boolean kmp(String s, String p){
		int []pi = getpi(p);
		
		int n = s.length();
		int m = p.length();
		int j = 0;
		for(int i = 0; i < n; i++) {
			while(j >0 && s.charAt(i) != p.charAt(j)) {
				j = pi[j-1];
			}
			
			if(s.charAt(i) == p.charAt(j)) {
				if(j == m - 1) {
					return true;
				}
				else {
					j++;
				}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		String P = sc.next();
		if(kmp(S, P)) System.out.println(1);
		else System.out.println(0);
	}

}
