package tictactoepkg;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author MeneXia (Xavi Ablaza)
 *
 */
public class MainTicTacToe {
	static Scanner in;
	
	static String turn;

	public static void main(String[] args) {
		 String[] board;
		in = new Scanner(System.in);
		board = new String[9];
		turn = "X";
		String winner = null;
		populateEmptyBoard(board);

		System.out.println("Welcome to 2 Player Tic Tac Toe.");
		System.out.println("--------------------------------");
		printBoard(board);
		System.out.println("X's will play first. Enter a slot number to place X in:");

		while (winner == null) {
			String numInputFromUser;
			try {
				numInputFromUser = in.nextLine();
				
				if (!(numInputFromUser.matches("[0-9]+"))) {
					System.out.println("Invalid input; re-enter slot number:");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input; re-enter slot number:");
				continue;
			}
			int numInput=Integer.parseInt(numInputFromUser);
			if (board[numInput-1].equals(String.valueOf(numInput))) {
				board[numInput-1] = turn;
				if (turn.equals("X")) {
					turn = "0";
				} else {
					turn = "X";
				}
				printBoard(board);
				winner = checkWinner(board);
			} else {
				System.out.println("Slot already taken; re-enter slot number:");
				continue;
			}
		}
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println("It's a draw! Thanks for playing.");
		} else {
			System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
		}
	}

	static String checkWinner(String[] board) {
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			if (line.equals("XXX")) {
				return "X";
			} else if (line.equals("000")) {
				return "0";
			}
		}

		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(String.valueOf(a+1))) {
				break;
			}
			else if (a == 8) return "draw";
		}

		System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
		return null;
	}

	static void printBoard(String[] board) {
		System.out.println("/---|---|---\\");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("/---|---|---\\");
	}

	static void populateEmptyBoard(String[] board) {
		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a+1);
		}
	}
}