package _0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 실버4_국영수 {
	static class score implements Comparable<score>{
		int lang;
		int eng;
		int math;
		String name;
		
		public score(String name,int lang, int eng, int math) {
			this.lang = lang;
			this.eng = eng;
			this.math = math;
			this.name = name;
		}


		@Override
		public String toString() {
			return name;
		}


		@Override
		public int compareTo(score o) {
			int ldiff = o.lang - this.lang;
			if(ldiff != 0) return ldiff;
			int ediff = this.eng - o.eng;
			if(ediff != 0) return ediff;
			int mdiff = o.math - this.math;
			if(mdiff != 0) return mdiff;
			return this.name.compareTo(o.name);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<score> q = new PriorityQueue<score>();
		for(int i = 0; i < N; i++) {
			String info = br.readLine();
			StringTokenizer stk = new StringTokenizer(info, " ");
			q.add(new score(stk.nextToken(), 
					Integer.parseInt(stk.nextToken()), 
					Integer.parseInt(stk.nextToken()),
					Integer.parseInt(stk.nextToken())));
		}
		while(!q.isEmpty())
			System.out.println(q.poll());

	}

}
