package org.examples;

import java.util.Scanner;

public class SingleDimesionArray {

	public static boolean canWin(int leap, int[] game) {
		return canWinAtIndex(0, leap, game, 0);
	}

	private static boolean canWinAtIndex(int index, int leap, int[] game, int prevMaxIndex) {

		boolean canWin = false;
		if (index >= game.length - 1 || index + leap >= game.length) {
			canWin = true;
		} else {

			if (!canWin && leap>0 && game[index + leap] == 0 && index + leap > prevMaxIndex) {
				canWin = canWinAtIndex(index + leap, leap, game, Math.max(index + leap, prevMaxIndex));
			}

			if (!canWin && index + 1 < game.length && game[index + 1] == 0 && (index + 1) > prevMaxIndex) {
				canWin = canWinAtIndex(index + 1, leap, game, Math.max(index + 1, prevMaxIndex));
			}

			if (!canWin && (index - 1) >= 0 && game[index - 1] == 0) {
				canWin = canWinAtIndex(index - 1, leap, game, Math.max(index - 1, prevMaxIndex));
			}
		}
		return canWin;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		while (q-- > 0) {
			int n = scan.nextInt();
			int leap = scan.nextInt();

			int[] game = new int[n];
			for (int i = 0; i < n; i++) {
				game[i] = scan.nextInt();
			}
			try {
				System.out.print("Processing test case " + q);
				System.out.print(", leap " + leap + ", ");
				System.out.println(", game [" + toString(game) + "].");

				System.out.println((canWin(leap, game)) ? "YES" : "NO");
			} catch (Throwable th) {
				th.printStackTrace();
			}
		}
		scan.close();
	}

	private static String toString(int[] gameArr) {
		StringBuilder sb = new StringBuilder();
		for (int i : gameArr) {
			sb.append(i).append(',');
		}
		return sb.toString();
	}

}
