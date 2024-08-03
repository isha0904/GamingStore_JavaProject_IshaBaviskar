package PlayStore;

import java.util.*;

public class TicTacToe {

	void printBoard(char board[][]) {
		for (int i = 0; i < 3; i++) {
			System.out.print("     \t   ");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	char playerWon(char board[][]) {

		// checking for row
//		boolean inRow = true; // true if row has all same

		for (int i = 0; i < board.length; i++) {
			boolean inRow = true;
			char row_val = board[i][0];

			if (row_val == '-') {
				inRow = false;
			} else {
				// checking for each clm of a row if 1st position is not empty
				for (int j = 1; j < board[i].length; j++) {
					if (board[i][j] != row_val) {
						inRow = false;
						break;
					}
				}
			}

			if (inRow) {
				return row_val;
			}
		}

		// checking for column
//		boolean inClm = true; // true if clm has all same

		for (int i = 0; i < board[0].length; i++) {
			boolean inClm = true;
			char clm_val = board[0][i];

			if (clm_val == '-') {
				inClm = false;
			} else {
				// checking for each row of a clm if 1st position is not empty
				for (int j = 1; j < board.length; j++) {
					if (board[j][i] != clm_val) {
						// jar equal nasel tr false.
						inClm = false;
						break;
					}
				}
			}

			if (inClm) {
				return clm_val;
			}
		}

		// checking for left diagonal -> (0,0), (1,1), ...
		boolean inDiag1 = true;

		char diag1_val = board[0][0];

		if (diag1_val == '-') {
			inDiag1 = false;
		} else {
			for (int i = 1; i < board.length; i++) {
				if (board[i][i] != diag1_val) {
					inDiag1 = false;
					break;
				}
			}
		}

		if (inDiag1) {
			return diag1_val;
		}

		// checking for right diagonal
		boolean inDiag2 = true;

		char diag2_val = board[0][board.length - 1];

		if (diag2_val == '-') {
			inDiag2 = false;
		} else {
			for (int i = 1; i < board.length; i++) {
				if (board[i][board.length - 1 - i] != diag2_val) {
					inDiag2 = false;
					break;
				}
			}
		}

		if (inDiag2) {
			return diag2_val;
		}

		// if no one won, return empty char
		return ' ';
	}

	// check if board is full
	boolean boardFull(char board[][]) {
		// boolean full = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == '-') {
					return false;
				}
			}
		}
		return true;
	}
}
