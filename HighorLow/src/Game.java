
import java.util.Scanner;
import java.util.Random;

public class Game {

	public static void main(String[] args) {
		int minBet = 5;
		int balance = 100;
		int winCount = 0;
		Scanner myScan = new Scanner(System.in);

		System.out.println("Welcome to High or Low!");
		System.out.println("Your current balance is: " + Integer.toString(BalanceCalculator(balance, 0, winCount)));

		do {
			System.out.println("Enter your bet, minimum: " + minBet + " gold, maximum: " + balance / 2 + " gold");

			String firstInput = myScan.next();
			int bet = betVerifier(minBet, balance, firstInput);
			boolean win = PlayGame();

			if (win == true) {
				winCount += 1;
				gameBlock: do {
					System.out.println("Enter D if you want to try and double your bet or enter C and cash out");
					String secondInput = myScan.next();
					String userOption = validateInput(secondInput);

					if (userOption.equalsIgnoreCase("d")) {
						win = PlayGame();

						if (win == true) {
							winCount += 1;
							System.out.println(winCount);
							continue gameBlock;
						} else {
							winCount = 0;
							balance = BalanceCalculator(balance, bet, winCount);
							System.out.println("Your current balance is: " + Integer.toString(balance));
							break gameBlock;
						}
					} else if (userOption.equalsIgnoreCase("c")) {
						balance = BalanceCalculator(balance, bet, winCount);
						System.out.println("Your current balance is: " + Integer.toString(balance));
						winCount = 0;
						break gameBlock;
					}

				} while (true);

			} else {
				balance = BalanceCalculator(balance, bet, winCount);
				System.out.println("Your current balance is: " + Integer.toString(balance));
			}
		} while (balance / 2 > minBet);

		if (balance / 2 < minBet) {

			System.out.println("Your balance is too low. You lose");
			System.exit(0);
		}

	}

	public static int BalanceCalculator(int balance, int bet, int winCount) {
		if (winCount == 0) {
			balance -= bet;
		} else {
			balance += (bet * 2 * winCount);
		}
		return balance;
	}

	public static int betVerifier(int minBet, int balance, String userNumber) {
		Scanner myScan = new Scanner(System.in);

		if (userNumber.matches("^[0-9]+$")) {
			int bet = Integer.parseInt(userNumber);
			if (bet > balance / 2) {
				System.out.println("Your bet is too high, please enter a new bet - minimum: 5 gold, maximum: "
						+ balance / 2 + " gold");
				String next = myScan.next();
				return betVerifier(minBet, balance, next);
			} else if (bet < minBet) {
				System.out.println("Your bet is too low, please enter a new bet - minimum: 5 gold, maximum: "
						+ balance / 2 + " gold");
				String next = myScan.next();
				return betVerifier(minBet, balance, next);
			}
			return bet;
		}

		else if (userNumber.equalsIgnoreCase("q")) {
			System.out.println("Leaving the program...");
			System.exit(0);
			return 0;
		}

		else {
			System.out.println("This is not a number, please enter a new bet - minimum: 5 gold, maximum: " + balance / 2
					+ " gold");
			String next = myScan.next();
			return betVerifier(minBet, balance, next);
		}
	}

	public static String validateInput(String userOption) {
		Scanner myScan = new Scanner(System.in);
		if (userOption.matches("[A-Za-z]")) {

			if (!userOption.equalsIgnoreCase("h") && !userOption.equalsIgnoreCase("l")
					&& !userOption.equalsIgnoreCase("d") && !userOption.equalsIgnoreCase("c")
					&& !userOption.equalsIgnoreCase("q")) {
				System.out.println("The character you entered doesn't match the options. Please try again...");
				String next = myScan.next();
				return validateInput(next);
			}

			else if (userOption.equalsIgnoreCase("q")) {
				System.out.println("Leaving the program...");
				System.exit(0);
			}

			return userOption;
		} else {
			System.out.println("This is not a letter. Please try again...");
			String next = myScan.next();
			return validateInput(next);
		}
	}

	public static int GenerateRandom() {
		Random rand = new Random(); // instance of random class
		int upperbound = 11;
		// generate random values from 0-24
		int random = rand.nextInt(upperbound);

		return random;
	}

	public static boolean PlayGame() {
		boolean win = false;
		Scanner myScan = new Scanner(System.in);
		int numberOne = GenerateRandom();

		System.out.println("The number is:  " + Integer.toString(numberOne));
		System.out.println("Enter H if you think the number will be higher.");
		System.out.println("Enter L if you think the number will be lower.");

		String input = myScan.next();
		String highLow = validateInput(input);
		int numberTwo = GenerateRandom();
		do {
			numberTwo = GenerateRandom();
		} while (numberOne == numberTwo);

		System.out.println("The next number is:  " + Integer.toString(numberTwo));

		if (highLow.equalsIgnoreCase("h") && numberOne < numberTwo) {
			System.out.println("You are correct.");
			win = true;
		}

		else if (highLow.equalsIgnoreCase("l") && numberOne > numberTwo) {
			System.out.println("You are correct.");
			win = true;
		} else {
			System.out.println("You lose.");
			win = false;
		}
		return win;
	}
}
