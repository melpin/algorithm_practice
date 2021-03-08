package _0308;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class G3_트리의지름_1167 {
	static class info {
		int nodeNum;
		int weight;

		info(int nodeNum, int weight) {
			this.nodeNum = nodeNum;
			this.weight = weight;
		}
	}

	static int dfs(int nodeNum) {
		if (!m.containsKey(nodeNum))
			return 0;
		List<info> l = m.get(nodeNum);
		visit[nodeNum] = true;

		Iterator<info> itr = l.iterator();
		List<Integer> sumlist = new LinkedList<Integer>();
		while (itr.hasNext()) {
			info cinfo = itr.next();
			if(!visit[cinfo.nodeNum])
				sumlist.add(dfs(cinfo.nodeNum) + cinfo.weight);
		}

		int[] arr = new int[sumlist.size()];
		int idx = 0;
		Iterator<Integer> itr2 = sumlist.iterator();
		
		if(arr.length == 0) return 0; // 더이상 자식 방문한게 없을때
		while (itr2.hasNext()) {
			arr[idx++] = itr2.next();
		}
		Arrays.sort(arr);

		if (arr.length < 2)
			maxans = Integer.max(maxans, arr[arr.length - 1]);
		else
			maxans = Integer.max(maxans, arr[arr.length - 1] + arr[arr.length - 2]);
		return arr[arr.length - 1];
	}

	static int maxans;
	static boolean[] visit;

	static Map<Integer, LinkedList<info>> m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		m = new HashMap<Integer, LinkedList<info>>();
		visit = new boolean[N+1];
		maxans = 0;
		for (int i = 1; i <= N; i++) {
			int from = sc.nextInt();

			int to = 0;
			int weight = 0;
			while (true) {
				to = sc.nextInt();
				if(to == -1) break;
				weight = sc.nextInt();
				if (m.containsKey(from)) {
					m.get(from).add(new info(to, weight));
				} else {
					LinkedList<info> tmpl = new LinkedList<info>();
					tmpl.add(new info(to, weight));
					m.put(from, tmpl);
				}
				if (m.containsKey(to)) {
					m.get(to).add(new info(from, weight));
				} else {
					LinkedList<info> tmpl = new LinkedList<info>();
					tmpl.add(new info(from, weight));
					m.put(to, tmpl);
				}
			}
		}

		dfs(1);
		System.out.println(maxans);
	}

}
