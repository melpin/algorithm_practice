package _0308;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class G4_트리의지름_1967 {
	static class info{
		int nodeNum;
		int weight;
		info(int nodeNum, int weight){
			this.nodeNum = nodeNum;
			this.weight = weight;
		}
	}
	
	static int dfs(int nodeNum){
		if(!m.containsKey(nodeNum))
			return 0;
		List<info> l = m.get(nodeNum);
		
		Iterator<info> itr = l.iterator();
		List<Integer> sumlist = new LinkedList<Integer>();
		while(itr.hasNext()) {
			info cinfo = itr.next();
			sumlist.add(dfs(cinfo.nodeNum) + cinfo.weight);
		}
		
		int[] arr = new int[sumlist.size()];
		int idx = 0;
		Iterator<Integer> itr2 = sumlist.iterator();
		while(itr2.hasNext()) {
			arr[idx++] = itr2.next();
		}
		Arrays.sort(arr);
		
		if(arr.length <2) maxans = Integer.max(maxans, arr[arr.length-1]);
		else maxans = Integer.max(maxans, arr[arr.length-1] + arr[arr.length-2]);
		return arr[arr.length-1]; 
	}
	static int maxans;
	
	static Map<Integer, LinkedList<info>> m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		m = new HashMap<Integer, LinkedList<info>>();
		maxans = 0;
		for(int i =0; i < N-1; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			
			if(m.containsKey(from)) {
				info tmp = new info(to, weight);
				m.get(from).add(tmp);
			}
			else {
				LinkedList<info> tmpl = new LinkedList<info>();
				info tmp = new info(to, weight);
				tmpl.add(tmp);
				m.put(from, tmpl);
			}
		}
		
		dfs(1);
		System.out.println(maxans);
	}

}
