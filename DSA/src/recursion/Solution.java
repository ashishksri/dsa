package recursion;

public class Solution {

	String[][] board = new String[3][3];

	public static void main(String[] args) {

		int[][] moves = { { 0, 0 }, { 1, 1 } };

		Solution solution = new Solution();

		System.out.println(solution.tictactoe(moves));

	}

	public String tictactoe(int[][] moves) {

		int output = fillBoard(moves);

		if (output == -1) {

			if (moves.length < 9) {

				return "Pending";

			} else {

				return "Draw";

			}

		}

		return output == 0 ? "A" : "B";

	}

	public int fillBoard(int[][] moves) {

		int i = 0;

		int output = -1;

		for (int[] move : moves) {

			if (i % 2 == 0) {

				board[move[0]][move[1]] = "X";

			} else {

				board[move[0]][move[1]] = "O";

			}

			output = findOutput(move, i);

			if (output != -1) {

				return output;

			}

			i++;

		}

		return output;

	}

	public int findOutput(int[] move, int i) {

		String var = i % 2 == 0 ? "X" : "O";

		for (int j = 0; j < 3; j++) {

			if (board[move[0]][j] != var) {

				break;

			} else {

				if (j == 2) {

					return i % 2;

				}

				continue;

			}

		}

		for (int k = 0; k < 3; k++) {

			if (board[k][move[1]] != var) {

				break;

			} else {

				if (k == 2) {

					return i % 2;

				}

				continue;

			}

		}

//first diagonal

		if ((move[0] == move[1])) {

			for (int j = 0; j < 3; j++) {

				if (board[j][j] != var) {

					break;

				} else {

					if (j == 2) {

						return i % 2;

					}

					continue;

				}

			}

		}

		if (move[0] + move[1] == 2) {

			for (int j = 0; j < 3; j++) {

				if (board[2 - j][j] != var) {

					break;

				} else {

					if (j == 2) {

						return i % 2;

					}

					continue;

				}

			}

		}

		return -1;

	}

}
