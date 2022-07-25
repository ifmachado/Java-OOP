import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		// var words will hold the string used throughout the game.
		String word = "yarns";
		// number of turns.
		int turns = 10;
		System.out.println("Welcome to hangman!");
		// Output length of word.
		System.out.println("The word has 5 letters.");
		// String list will hold the temp dashes that will the replaced by word
		// characters depending on guesses.
		String[] wordList = { "_ ", "_ ", "_ ", "_ ", "_ " };
		// Loop though wordList to print the dashes.
		for (String character : wordList) {
			System.out.print(character);
		}
		// do while loop will run until user has no more guesses.
		do {
			System.out.println("");
			System.out.println("Guess a letter: ");
			String userinput = myScan.next();
			// validating user input through validateInput method. To check if it's an
			// alphabetic character.
			String input = validateInput(userinput);

			// loop through the characters in word.
			for (int i = 0; i < wordList.length; i++) {
				// creating a string to change the datatype from character to string so
				// equalsIgnoreCase can be used and also because wordList is a list of Strings,
				// not characters.
				String ch = String.valueOf(word.charAt(i));
				// if a character from the word matches the user input, replace the dash in
				// wordList for the character.
				if (ch.equalsIgnoreCase(input)) {
					wordList[i] = ch;
				}
			}

			for (String character : wordList) {
				System.out.print(character);
			}
			// Check if there are any dashes left in the wordList array.
			boolean test = Arrays.asList(wordList).contains("_ ");
			// if no dashes are in the list, user has won, so game must end.
			if (test == false) {
				System.out.println("");
				System.out.println("You won! The word was \"yarns\".");
				System.exit(0);
			}

			// reduce number of turns each iteration of this loop.
			turns = turns - 1;
			System.out.println("");
			// print number of guesses left.
			System.out.println("You have " + Integer.toString(turns) + " guesses");

		} while (turns > 0);
		// no guesses left, end of game.
		System.out.println("Out of guesses. The word was \"yarns\". ");

	}

	public static String validateInput(String input) {
		Scanner myScan = new Scanner(System.in);
		// REGEX to check if the user input is an alphabetic character.
		if (input.matches("[A-Za-z]")) {
			// if so return the value of that String.
			return input;
		}
		// if not, ask for a new input and call this method again until there's a valid
		// input.
		else {
			System.out.println("This is not a letter. Please try again...");
			String next = myScan.next();
			return validateInput(next);
		}
	}
}
