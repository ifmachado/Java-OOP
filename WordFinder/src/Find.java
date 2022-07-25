
import java.util.Scanner;

public class Find {
	// main method
	public static void main(String[] args) {
		String text = """
				Encapsulation is an object-oriented programming concept that binds together the data
				and functions that manipulate the data, and that keeps both safe from outside
				interference and misuse. Data encapsulation led to the important OOP concept of data
				hiding. If a class does not allow calling code to access internal object data and permits
				access through methods only, this is a strong form of abstraction or information hiding
				known as encapsulation. Some languages (Java, for example) let classes enforce access
				restrictions explicitly, for example denoting internal data with the private keyword and
				designating methods intended for use by code outside the class with the public keyword.""";

		System.out.println(text);
		// initiating Java scanner
		Scanner myScan = new Scanner(System.in);
		// this loop will run indefinitely, however the validateInput method will
		// terminate program if Q is entered.
		do {
			//remove all special characters from text.
			text=text.replaceAll("[,()]","");			
			
			System.out.println("__________________");
			System.out.println("Enter a word to find or \"q\" to exit - program is case sensitive: ");
			// variable input is only used as a temp save for the input, so it can serve as
			// a parameter for the validateInput method.
			String input = myScan.next();
			// validateInput method is called here and its returned value will be stored as
			// the searchWord.
			String searchWord = validateInput(input);
						
			// split the text into an array of words.
			String[] wordList = text.split(" ");
						// initializing the totalWords variable so it can be used inside the loop as a
			// word counter.
			int totalWords = 0;
			// loop through all words in wordList
			for (int i = 0; i < wordList.length; i++) {
				//check if word matches any words in wordlist with or without punctuation at the end.
				if (wordList[i].equals(searchWord) || wordList[i].equals(searchWord + "."))

				{
					// if word is encountered, add 1 to word counter.
					totalWords++;
				}

			}

			// if word was found counter will be more than zero. therefore word and found
			// message will be printed.
			if (totalWords > 0) {
				System.out.println(searchWord + " was found in paragraph.");
			}
			// word not found - counter = 0.
			else {

				System.out.println(searchWord + " was not found in paragraph.");
			}

			// split the text into an array of strings (lines) using "." as a separator.
			String[] lineList = text.split("\\.");

			// loop through all lines in lineList
			for (int j = 0; j < lineList.length; j++) {
				// check if string (line) was a substring (word) that matches the searchWord.
				if (lineList[j].contains(searchWord)) {
					// print the index of the line in which the word was found.
					System.out.println("and found in line " + Integer.toString(j+1));
				}

			}
		} while (true);

	}

	public static String validateInput(String input) {
		Scanner myScan = new Scanner(System.in);
		// REGEX to check if the user input is an alphanumeric character. Searching
		// through all characters in the input.
		if (input.matches("^[a-zA-Z0-9]*$")) {
			// if the input is equal to "q", ignoring case, leave the program.
			if (input.equalsIgnoreCase("q")) {
				System.out.println("Leaving the program...");
				System.exit(0);
			}
			// returning the input value if it matches the alphanumeric criteria.
			return input;
		}
		// if non-alphanumeric characters were found, it will ask the user for another
		// input until it matches the alphanumeric criteria.
		else {
			System.out.println("This is not an alphanumeric value. Please try again...");
			String next = myScan.next();
			return validateInput(next);
		}
	}

}
