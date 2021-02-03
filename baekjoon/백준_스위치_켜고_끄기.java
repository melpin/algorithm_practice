import java.util.Scanner;

public class 백준_스위치_켜고_끄기 {
	static class people {
		int gender;
		int s_num;
	}

	public static int turn(int l) {
		return l == 1 ? 0 : 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int Switch = sc.nextInt();
		int sarr[] = new int[Switch];
		for (int i = 0; i < Switch; i++)
			sarr[i] = sc.nextInt();
		int p = sc.nextInt();

		people parr[] = new people[p];

		for (int i = 0; i < p; i++) {
			parr[i] = new people();
			parr[i].gender = sc.nextInt();
			parr[i].s_num = sc.nextInt();
			// 성별 숫자 남 1, 여 2
		}
		for (int i = 0; i < p; i++) {
			if (parr[i].gender == 1) {
				for (int j = parr[i].s_num - 1; j < Switch; j += parr[i].s_num) {
					sarr[j] = turn(sarr[j]);
				}
			} else {
				int mid = parr[i].s_num - 1;
				sarr[mid] = turn(sarr[mid]);
				int j = 1;
				try {
					while (true) {
						if (sarr[mid - j] == sarr[mid + j]) {
							sarr[mid - j] = turn(sarr[mid - j]);
							sarr[mid + j] = turn(sarr[mid + j]);
							j++;
						} else {
							break;
						}
					}
				} catch (Exception e) {

				}
			}
		}

		for(int i = 0; i < sarr.length; i++) {
			if(i != 0 && i % 20 == 0)
				System.out.println();
			System.out.print(sarr[i]+" ");
		}
	}
}