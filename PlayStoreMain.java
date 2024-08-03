package PlayStore;

import java.util.*;

/*
 * MINIPROJECT by->
 * 1. Isha Baviskar - UCE2022427
 * 2. Chaitrali Bhosale - UCE2022435
 * 3. Sukhada Bhagwat - UCE2022429
 */
public class PlayStoreMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("---------------------------------------------------");
		System.out.println("-------------WELCOME TO GAME PLAYSTORE-------------");
		System.out.println("---------------------------------------------------");
		int bye;
		int choice;
		do {
			System.out.println("\nGames you can play ->\n1.\tHangman.\n2.\tGuess the Number.\n3.\tTic Tac Toe\n");
			System.out.println("Choose the Game option you want to play ->");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				// Hangman
				System.out.println("---------------------------------------------------");
				System.out.println("----------------WELCOME TO HANGMAN!----------------\n");
				Scanner scanner = new Scanner(System.in);

				System.out.print("Enter the word to guess: ");
				String wordToGuess = scanner.nextLine().toLowerCase();

				HangmanGame game = new HangmanGame(wordToGuess, 6);
				HangmanGame.clearConsole();
				System.out.println("Welcome to Hangman!");
				while (!game.isGameOver()) {
					Nodeh currentWord = game.getCurrentWord();
					while (currentWord != null) {
						System.out.print(currentWord.letter + " ");
						currentWord = currentWord.next;
					}
					System.out.println("\nGuessed letters: " + game.guessedLetters.toString());
					System.out.print("Guess a letter: ");
					char guess = scanner.next().charAt(0);

					if (game.makeGuess(guess)) {
						System.out.println("Good guess!");
					} else {
						System.out.println("Wrong guess.");
					}
				}

				if (game.isWordGuessed()) {
					System.out.println("\nCongratulations! You've guessed the word: " + wordToGuess);
				} else {
					System.out.println("\nYou've run out of attempts. The word was: " + wordToGuess);
				}
				System.out.println("---------------------------------------------------");
				break;
			case 2:
				// Guess the Number
				System.out.println("---------------------------------------------------");
			     BST bst = new BST();
			        Random random = new Random();
			        int target = random.nextInt(100) + 1; // Random number between 1 and 100

			      //  Scanner sc = new Scanner(System.in);
			        int attempts = 0;

			        System.out.println("Guess the number between 1 and 100.");
			        while (true) {
			            System.out.print("\nEnter your guess: ");
			            int guess = sc.nextInt();
			            attempts++;

			            if (bst.search(guess)) {
			                System.out.println("You've already guessed that number.");
			            } else {
			                bst.insert(guess);

			                if (guess < target) {
			                    System.out.println("---Try a higher number.---");
			                } else if (guess > target) {
			                    System.out.println("---Try a lower number.---");
			                } else {
			                	System.out.println("\n\n\t\\(^_^)/\n");
			                    System.out.println("\nCongratulations! You guessed the number in " + attempts + " attempts.");
			                    break;
			                }
			            }
			        }
			        System.out.println("---------------------------------------------------");
				break;
			case 3:
				// Tic Tac Toe
				System.out.println("---------------------------------------------------");
				System.out.println("--------------WELCOME TO TIC TAC TOE!--------------\n");

				// creating tic tac toe board
				TicTacToe obj = new TicTacToe();
				char[][] board = new char[3][3];
				// Scanner sc = new Scanner(System.in);

				System.out.print("Enter the name of Player 1 -> ");
				String p1 = sc.nextLine();
				System.out.print("Enter the name of Player 2 -> ");
				String p2 = sc.nextLine();
				System.out.println();

				// creating empty board
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						board[i][j] = '-';
					}
				}

				System.out.println("-----NOTE-----\nThe positions are :>");
				int num = 1;
				for (int i = 0; i < 3; i++) {
					System.out.print("     \t   ");
					for (int j = 0; j < 3; j++) {
						System.out.print(num + " ");
						num++;
					}
					System.out.println();
				}

				System.out.println("\n----------LET's START----------");

				// prints the empty board initially and mg jase moves hotil tase
				obj.printBoard(board);
				System.out.println("");

				// pahile p1 chi turn, mg toh true
				boolean pl1 = true;

				// game end jhala tr true krych else false
				boolean gameend = false;

				// jevha paryant game end hot nahi toh paryant chaludya
				while (!gameend) {

					if (pl1) {
						System.out.println("--- " + p1 + "'s turn (x) ---");
					} else {
						System.out.println("--- " + p2 + "'s turn (o) ---");
					}

					// for assigning char to each player
					char ch = '-';
					if (pl1) {
						ch = 'x';
					} else {
						ch = 'o';
					}

					int row = 0;
					int col = 0;
					while (true) {

						System.out.println("Where you want to make a move -> ");
						System.out.println("Enter the position, 1 to 9 ->");
						int choicet = sc.nextInt();

						row = (choicet - 1) / 3;
						col = (choicet - 1) % 3;

						if (row < 0 || col < 0 || row >= 3 || col >= 3) {
							System.out.println("This position is off the bounds of the board! Try again.");

						} else if (board[row][col] != '-') {
							System.out.println("Someone has already made a move at this position! Try again.");

						} else {
							break;
						}
					}

					// Set the position on the board at row, col to c
					board[row][col] = ch;

					if (obj.playerWon(board) == 'x') {
						System.out.println("-------" + p1 + " Won !!-------");
						gameend = true;
					} else if (obj.playerWon(board) == 'o') {
						System.out.println("-------" + p2 + " Won !!-------");
						gameend = true;
					} else {
						if (obj.boardFull(board)) {
							System.out.println("-------It's a tie!-------");
							gameend = true;
						} else {
							pl1 = !pl1;
						}
					}

					obj.printBoard(board);
				}
				System.out.println("---------------------------------------------------");
				break;

			default:
				System.out.println("Please choose the correct Game number!");
			}

			System.out.println("\nEnter any key to play a New Game, '0' to exit playstore.");
			bye = sc.nextInt();
			if (bye == 0) {
				System.out.println("\n---------------------------------------------------");
				System.out.println("--------------Hope you enjoyed Gaming--------------");
				System.out.println("--------------Thank you, Visit again!--------------");
				System.out.println("---------------------------------------------------");
			}
		} while (bye != 0);

	}

}
