import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Math();
	}

	// random generator
	public static int randomGenerator()

	{
		Random rand = new Random(); // instance of random class
		// generate random values from 0-20
		int random = rand.nextInt(20);
		return random;
	}

	public static void Math() {
		Scanner scan = new Scanner(System.in);

		// calls randomGenerator method to get a random int between 0 and 20.
		int num = randomGenerator();

		int rounds = 5;

		// new HashSet object to store user guesses that were incorrect.
		HashSet<Integer> guesses = new HashSet<Integer>();

		// loop will continue until user guest the right answer.
		while (rounds > 0) {
			System.out.println("You have " + rounds + " rounds.");
			System.out.println("Guess a number between 0-20:");
			// gets user input
			int input = scan.nextInt();

			// compares with generated random int.
			// breaks loop when user guesses it right

			if (num == input) {
				System.out.println("You've won!");
				break;
			}
			// continues asking for guesses and add wrong guess to HashSet
			else {
				System.out.println("Wrong. Try again...");
				guesses.add(input);
				rounds--;
			}
			// prints all number already guessed by printing HashSet.
			System.out.println("You've already guesses these numbers.");
			System.out.println(guesses);

		}
		System.out.println("GAME OVER");
		System.out.println("The number was " + num + ".");

	}

}
