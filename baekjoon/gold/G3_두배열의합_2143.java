package _0426;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class G3_두배열의합_2143 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long T = sc.nextLong();
		long ans = 0;
		
		int A = sc.nextInt();		
		long[] Aarr = new long[A];
		for(int i =0; i < A; i++) 
			Aarr[i] = sc.nextLong();
		int B = sc.nextInt();
		long[] Barr = new long[B];
		for(int i =0; i < B; i++)
			Barr[i]  = sc.nextLong();
		
		List<Long> Alist = new LinkedList<Long>();
		for(int i = 0; i < A; i++) {
			long asum = 0;
			for(int j = i; j < A; j++) {
				asum += Aarr[j];
				Alist.add(asum);
			}
		}
		
		List<Long> Blist = new LinkedList<Long>();
		for(int i = 0; i < B; i++) {
			long bsum = 0;
			for(int j = i; j < B; j++) {
				bsum += Barr[j];
				Blist.add(bsum);
			}
		}
		Alist.sort(null);
		Blist.sort(null);
		
		int idx = 0;
		Iterator<Long> aitr = Alist.iterator();
		Aarr = new long[Alist.size()];
		while(aitr.hasNext())
			Aarr[idx++] = aitr.next();
		
		idx = 0;
		Iterator<Long> bitr = Blist.iterator();
		Barr = new long[Blist.size()];
		while(bitr.hasNext())
			Barr[idx++] = bitr.next();
		
		int aidx = 0;
		int bidx = Barr.length-1;
		while(true) {
			if(Aarr[aidx]+Barr[bidx] < T)
				aidx++;
			else if(Aarr[aidx]+Barr[bidx] > T)
				bidx--;
			else if(Aarr[aidx]+Barr[bidx] == T) {
				long acnt = 1;
				long bcnt = 1;
				while(aidx+1 < Aarr.length && Aarr[aidx] == Aarr[aidx+1]) {
					acnt++;
					aidx++;
				}
				while(bidx-1 >= 0 && Barr[bidx] == Barr[bidx-1]) {
					bcnt++;
					bidx--;
				}
				ans += acnt * bcnt;
				aidx++;
				bidx--;
			}
			if(aidx >= Aarr.length || bidx <0)
				break;
		}
		System.out.println(ans);
	}
}
