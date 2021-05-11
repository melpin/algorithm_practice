package _0504;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class G4_가르침_1062 {
	static int ans = 0;
	static Set<Character> defaults;
	static Set<Character>[] slist;
	
	static void comb(int idx, int start, Set<Character> currentset){
		if (idx == 0){
			Set<Character> result = new HashSet<>();
			result.addAll(defaults);
			result.addAll(currentset);
			int cnt = 0;
			for(Set<Character> s : slist){
				if(result.containsAll(s)){
					cnt++;
				}
			}
			ans = Integer.max(cnt, ans);
			return;
		}
		for(char c = (char)start; c <= 'z'; c++) {
			if(!defaults.contains(c)) {
				currentset.add(c);
				comb(idx -1, c+1, currentset);		
				currentset.remove(c);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		defaults = new HashSet<>();
		defaults.add('a');
		defaults.add('n');
		defaults.add('t');
		defaults.add('i');
		defaults.add('c');
		slist = new HashSet[N];
		for(int i = 0; i < N; i++) {
			slist[i] = new HashSet<>();
			String s = sc.next();
			s = s.substring(4, s.length()-4);
			for(char c : s.toCharArray()) {
				if(!defaults.contains(c))
					slist[i].add(c);
			}
		}
		
		if(K < 5) {
			System.out.println(0);
		}else {
			comb(K - 5, 'a', new HashSet<>());
			System.out.println(ans);
		}
	}
}