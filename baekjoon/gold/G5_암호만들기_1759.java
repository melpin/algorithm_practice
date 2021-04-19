package _0419;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class G5_암호만들기_1759 {
	static boolean[] select;
	static int L;
	static char[] result;
	static int C;
	static char[] chars;
	static List<String> l;
	
	static void permutation(int sidx, int idx) {
		if(idx == L) {
			int aeiou = 0;
			int other = 0;
			for(int i =0; i < L; i++) {
				if(result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u')
					aeiou++;
				else
					other++;
			}
			
			if(aeiou >= 1 && other >= 2){
				StringBuilder sb = new StringBuilder();
				char[] s = new char[L];
				for(int i =0; i < L; i++) {
					s[i] = result[i];
				}
				Arrays.sort(s);
				for(int i =0; i < L; i++) {
					sb.append(s[i]);
				}
				l.add(sb.toString());
			}
			return;
		}
		
		for(int i= sidx; i < C; i++) {
			if(!select[i]) {
				select[i] = true;
				result[idx] = chars[i];
				permutation(i+1, idx+1);
				select[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		l = new LinkedList<String>();
		
		result = new char[L];
		select = new boolean[C];
		chars = new char[C];
		for(int i =0; i < C;i++) {
			chars[i] = sc.next().charAt(0);
		}
		permutation(0, 0);
		Collections.sort(l);
		for(String item : l) {
			System.out.println(item);
		}
	}
}
