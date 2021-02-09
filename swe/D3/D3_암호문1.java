import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class D3_암호문1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();

			List<Integer> crypto = new LinkedList<Integer>();

			for (int i = 0; i < N; i++)
				crypto.add(sc.nextInt());

			int C = sc.nextInt();

			sc.nextLine();
			String commands = sc.nextLine();
			String[] command = commands.split("I");
			String[] sub;
			for (int i = 1; i <= C; i++) {
				sub = command[i].split(" ");

				int idx = Integer.parseInt(sub[1]);
				int time = Integer.parseInt(sub[2]);
				for (int j = 3; j < time+3; j++)
					crypto.add(idx++, Integer.parseInt(sub[j]));
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < 10; i++)
				System.out.print(crypto.get(i) + " ");
			System.out.println();
		}

	}

}
