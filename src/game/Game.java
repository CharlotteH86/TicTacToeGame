package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

	static Scanner scan = new Scanner(System.in);
	static ArrayList<Integer> playerOnePos = new ArrayList<Integer>();
	static ArrayList<Integer> playerTwoPos = new ArrayList<Integer>();


	public static void main(String[] args) {
		
		//Spelbordet
		char[][] board = { 
				{ ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-' },
				{ ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-' },
				{ ' ', '|', ' ', '|', ' ' } };

		print(board);

		//Loop för spelare att mata in deras markörer samt känner av om de vunnit
		while (true) {

			Scanner scan = new Scanner(System.in);
			System.out.println("Spelare 1 markera en ruta mellan 1 och 9");
			int marker = scan.nextInt();

			marks(board, marker, "Player 1");
			String result = winner();
			if (result.length() > 0) {
				System.out.println(result);
				print(board);
				break;

			}

			System.out.println("Spelare 2 markera en ruta mellan 1 och 9");
			int markerTwo = scan.nextInt();
			marks(board, markerTwo, "Player 2");

			print(board);
			result = winner();
			if (result.length() > 0) {
				System.out.println(result);
				print(board);
				break;

			}

		}

	}

	//Printar up bordet i console
	public static void print(char[][] board) {
		for (char[] row : board) {
			for (char r : row) {
				System.out.print(r);

			}
			System.out.println();

		}

	}

	//Skapar markörer
	public static void marks(char[][] board, int marker, String player) {
		char symbol = ' ';

		if (player.equals("Player 1")) {
			symbol = 'x';
			playerOnePos.add(marker);
		} else if (player.equals("Player 2")) {
			symbol = 'O';
			playerTwoPos.add(marker);
		}

		switch (marker) {
		case 1:
			board[0][0] = symbol;
			break;
		case 2:
			board[0][2] = symbol;
			break;
		case 3:
			board[0][4] = symbol;
			break;
		case 4:
			board[2][0] = symbol;
			break;
		case 5:
			board[2][2] = symbol;
			break;
		case 6:
			board[2][4] = symbol;
			break;
		case 7:
			board[4][0] = symbol;
			break;
		case 8:
			board[4][2] = symbol;
			break;
		case 9:
			board[4][4] = symbol;
			break;
		default:
			break;
		}

	}

	//Villkor för hur man vinner
	public static String winner() {

		List top = Arrays.asList(1, 2, 3);
		List mid = Arrays.asList(4, 5, 6);
		List bot = Arrays.asList(7, 8, 9);

		List left = Arrays.asList(1, 4, 7);
		List midCol = Arrays.asList(2, 5, 8);
		List right = Arrays.asList(3, 6, 9);
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(7, 5, 3);

		List<List> winning = new ArrayList<List>();
		winning.add(top);
		winning.add(mid);
		winning.add(bot);
		winning.add(left);
		winning.add(midCol);
		winning.add(right);
		winning.add(cross1);
		winning.add(cross2);

		for (List l : winning) {
			if (playerOnePos.containsAll(l)) {
				
				return "Grats player 1";
			} else if (playerTwoPos.contains(l)) {
				
				return "Grats player 2";
			} else if (playerOnePos.size() + playerTwoPos.size() == 9) {
				
				return "tie..";
			}
		}

		return "";

	}
	
	//Denna metod skulle starta om spelet vid vinst/tie men jag fick det ej till att fungera
	private static void restart()
	{
	    main(null);
	}
	

	}

