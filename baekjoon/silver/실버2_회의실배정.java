import java.util.Arrays;
import java.util.Scanner;

public class 실버2_회의실배정 {
	static class meet implements Comparable<meet>{
		int st;
		int end;
		meet(int st, int end){
			this.st=st;
			this.end=end;
		}
		@Override
		public int compareTo(meet o) {
			int end = this.end - o.end;
			if(end == 0)
				return this.st - o.st;
			return end;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		meet[] time = new meet[N];
		for(int i = 0; i <N;i++)
			time[i] = new meet(sc.nextInt(),sc.nextInt());
		
		Arrays.sort(time);
		
		int subst = 0;
		int cnt = 0;
		int i = 0;
		while(i<N) {
			if(time[i].st >= subst) {
				subst = time[i].end;
				cnt++;
			}
			i++;
		}
		System.out.println(cnt);
	}
}
