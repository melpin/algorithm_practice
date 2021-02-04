package _0203;

import java.util.Scanner;

public class D2_스도쿠_검증 {
	public static boolean Wcheck(int[][] sudoku) {
		int checksum;
		for (int i = 0; i < 9; i++) {
			checksum = 0;
			for (int j = 0; j < 9; j++) {
				checksum += sudoku[i][j];
			}
			if (checksum != 45)
				return false;
		}
		return true;
	}

	public static boolean Dcheck(int[][] sudoku) {
		int checksum;
		for (int i = 0; i < 9; i++) {
			checksum = 0;
			for (int j = 0; j < 9; j++) {
				checksum += sudoku[j][i];
			}
			if (checksum != 45)
				return false;
		}
		return true;
	}

	public static boolean squarecheck(int[][] sudoku) {
		int checksum;
		for (int i = 0; i < 9; i+=3) {
			for (int j = 0; j < 9; j+=3) {
				checksum = 0;
				for (int k = i; k < i+3; k++) {
					for (int l = j; l < j+3; l++) {
						checksum += sudoku[k][l];
					}
				}
				if (checksum != 45)
					return false;
			}
		}
		return true;
	}
	
	public static boolean sudokucheck(int [][]sudoku) {
		if(Wcheck(sudoku) == false)
			return false;
		if(Dcheck(sudoku) == false)
			return false;
		if(squarecheck(sudoku) == false)
			return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			int[][] sudoku = new int[9][9];

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}
			if(sudokucheck(sudoku))
				ans = 1;
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
