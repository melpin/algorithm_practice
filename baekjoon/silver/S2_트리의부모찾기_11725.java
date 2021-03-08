package _0308;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class S2_트리의부모찾기_11725 {
	static Map<Integer, LinkedList<Integer>> m;
	static void setParent(int currentVal){
		if(m.containsKey(currentVal)) {
			List l = m.get(currentVal);
			
			Iterator<Integer> itr = l.iterator();
			while(itr.hasNext()) {
				int childnum = itr.next();
				if(parent[childnum] == 0) {
					parent[childnum] = currentVal;
					setParent(childnum);
				}
			}
		}
	}
	
	static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		parent = new int[N+1];
		
		m = new HashMap<Integer, LinkedList<Integer>>();
		for(int i = 0; i < N-1; i++) {
			int val1 = sc.nextInt();
			int val2 = sc.nextInt();
			
			if(m.containsKey(val1))
				m.get(val1).add(val2);
			else {
				LinkedList<Integer> tmpl = new LinkedList<Integer>();
				tmpl.add(val2);
				m.put(val1, tmpl);
			}
			
			if(m.containsKey(val2))
				m.get(val2).add(val1);
			else {
				LinkedList<Integer> tmpl = new LinkedList<Integer>();
				tmpl.add(val1);
				m.put(val2, tmpl);
			}
		}
		
		setParent(1);
		for(int i = 2; i <= N; i++)
			System.out.println(parent[i]);
	}
}
