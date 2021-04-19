package _0419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_스도쿠_2580{
	static int N = 9;
	static int[][] sudoku;

	public static boolean RowCheck(int i, int val) {
		for (int j = 0; j < N; j++)
			if (sudoku[i][j] == val)
				return false;
		return true;
	}

	public static boolean ColCheck(int j, int val) {
		for (int i = 0; i < N; i++)
			if (sudoku[i][j] == val)
				return false;
		return true;
	}

	public static boolean squarecheck(int i, int j, int val) {
		int RowRange = 0;
		int ColRange = 0;

		for (int ri = 0; ri < N; ri += 3) {
			if (i < ri + 3) {
				RowRange = ri;
				break;
			}
		}
		for (int rj = 0; rj < N; rj += 3) {
			if (j < rj + 3) {
				ColRange = rj;
				break;
			}
		}

		for (int k = RowRange; k < RowRange + 3; k++) {
			for (int l = ColRange; l < ColRange + 3; l++) {
				if (sudoku[k][l] == val)
					return false;
			}
		}
		return true;
	}

	static boolean sudokuRun(int i, int j) {
		if (i == 9 && j == 0)
			return true;

		if (sudoku[i][j] == 0) {
			for (int num = 1; num <= N; num++) {
				if (!RowCheck(i, num))
					continue;
				if (!ColCheck(j, num))
					continue;
				if (!squarecheck(i, j, num))
					continue;
				sudoku[i][j] = num;
				if (sudokuRun(i + (j + 1) / 9, (j + 1) % 9))
					return true;
				sudoku[i][j] = 0;
			}
		} else {
			if (sudokuRun(i + (j + 1) / 9, (j + 1) % 9))
				return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sudoku = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				sudoku[i][j] = stk.nextToken().charAt(0) - '0';
			}
		}
		sudokuRun(0, 0);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(sudoku[i][j]+" ");
			}
			System.out.println();
		}

	}
}
