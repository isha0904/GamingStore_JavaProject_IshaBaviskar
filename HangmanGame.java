package PlayStore;
import java.util.LinkedList;
import java.util.Scanner;

class Nodeh {
    char letter;
    Nodeh next;

    public Nodeh(char letter) {
        this.letter = letter;
        this.next = null;
    }
}

public class HangmanGame {
    private LinkedList<Character> wordToGuess;
    LinkedList<Character> guessedLetters;
    private int maxAttempts;
    private int incorrectGuesses;

    public HangmanGame(String wordToGuess, int maxAttempts) {
        this.wordToGuess = new LinkedList<>();
        for (char letter : wordToGuess.toCharArray()) {
            this.wordToGuess.add(letter);
        }
        this.guessedLetters = new LinkedList<>();
        this.maxAttempts = maxAttempts;
        this.incorrectGuesses = 0;
    }

    public boolean isGameOver() {
        return incorrectGuesses >= maxAttempts || isWordGuessed();
    }

    public boolean isWordGuessed() {
        for (char letter : wordToGuess) {
            if (!guessedLetters.contains(letter)) {
                return false;
            }
        }
        return true;
    }

    public boolean makeGuess(char letter) {
        letter = Character.toLowerCase(letter);
        if (guessedLetters.contains(letter)) {
            return false; // Letter has already been guessed.
        }

        guessedLetters.add(letter);
        if (!wordToGuess.contains(letter)) {
            incorrectGuesses++;
            drawHangman(incorrectGuesses);
        }

        return true;
    }
    

    public Nodeh getCurrentWord() {
        Nodeh display = null;
        Nodeh tail = null;

        for (char letter : wordToGuess) {
            Nodeh newNode = new Nodeh('_');
            if (guessedLetters.contains(letter)) {
                newNode.letter = letter;
            }

            if (display == null) {
                display = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return display;
    }

        public static void drawHangman(int incorrectGuesses) {
    switch (incorrectGuesses) {
        case 1:
            System.out.println("  ____ ");
            System.out.println(" |    |");
            System.out.println(" |    O");
            System.out.println(" |      ");
            System.out.println(" |      ");
            System.out.println(" |      ");
            break;
        case 2:
            System.out.println("  ____ ");
            System.out.println(" |    |");
            System.out.println(" |    O");
            System.out.println(" |    | ");
            System.out.println(" |      ");
            System.out.println(" |      ");
            break;
        case 3:
            System.out.println("  ____ ");
            System.out.println(" |    |");
            System.out.println(" |    O");
            System.out.println(" |   /| ");
            System.out.println(" |      ");
            System.out.println(" |      ");
            break;
        case 4:
            System.out.println("  ____ ");
            System.out.println(" |    |");
            System.out.println(" |    O");
            System.out.println(" |   /|\\");
            System.out.println(" |      ");
            System.out.println(" |      ");
            break;
        case 5:
            System.out.println("  ____ ");
            System.out.println(" |    |");
            System.out.println(" |    O");
            System.out.println(" |   /|\\");
            System.out.println(" |   /  ");
            System.out.println(" |      ");
            break;
        case 6:
            System.out.println("  ____ ");
            System.out.println(" |    |");
            System.out.println(" |    O");
            System.out.println(" |   /|\\");
            System.out.println(" |   / \\");
            System.out.println(" |      ");
            break;
    }
}

    static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}