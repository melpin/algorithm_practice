package _0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 실버5_좌표정렬하기 {
	static class point implements Comparable<point>{
		int x;
		int y;
		point(int x, int y){
			this.x = x;
			this.y= y;
		}
		@Override
		public String toString() {
			return x + " " + y;
		}
		@Override
		public int compareTo(point o) {
			int resultx = Integer.compare(this.x, o.x);
			if(resultx == 0)
				return Integer.compare(this.y, o.y);
			return resultx;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<point> q = new PriorityQueue<point>();
		for(int i = 0; i < n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			point tmp = new point(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
			q.add(tmp);
		}
		while(!q.isEmpty())
			System.out.println(q.poll());

	}

}
