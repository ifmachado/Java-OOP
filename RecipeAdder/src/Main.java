
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// ArraList will store all recipe objects added by user.
		ArrayList<Recipe> allRecipes = new ArrayList<Recipe>();

		// while user doesn't quit program, run this loop.
		while (true) {
			// prints menu options.
			Menu();

			// gets user input and validates if it's an int and whiting the menu range
			String input = scan.next();
			int option = validateInput(input, 0, 3);

			// option 0 breaks loop and leaves recipe adder
			if (option == 0) {
				System.out.println("Leaving recipe adder...");
				break;
			}

			// option 1 calls addRecipe method to add a new recipe

			else if (option == 1) {
				Recipe newRecipe = addRecipe();
				allRecipes.add(newRecipe);
				System.out.println("Recipe successfuly added.");
			}

			// option 1 calls recipeChecker method to check recipe ingredients.

			else if (option == 2) {
				recipeChecker(allRecipes);

			}

			else if (option == 3) {
				// sort recipe by ingredients through overridden compareTo method
				Collections.sort(allRecipes);

				// print recipes in Arraylist
				printRecipes(allRecipes);
			}

		}
	}

	// print menu
	public static void Menu() {
		System.out.println("Select an option:");
		System.out.println("    0: Leave recipe adder");
		System.out.println("    1: Add a recipe");
		System.out.println("    2: Check if a recipe has an ingredient");
		System.out.println("    3: Print all recipes");

	}

	public static Recipe addRecipe() {
		Scanner scan = new Scanner(System.in);
		// initializing boolean variables that will indicate if an ingredient is present
		// or not
		boolean bdairy;
		boolean bmeat;
		boolean bgluten;

		// get user input for recipe name
		System.out.println("What is the recipe's name?");
		String name = scan.next();

		// get user input regarding dairy presence in recipe. bdairy will be set to true
		// if answer from user is "y"
		// and to false is answer is "n"
		System.out.println("Does it have dairy? y/n");
		String dairy = scan.next();
		if (dairy.equalsIgnoreCase("y")) {
			bdairy = true;
		}

		else {
			bdairy = false;
		}

		// get user input regarding meat presence in recipe. bmeat will be set to true
		// if answer from user is "y"
		// and to false is answer is "n"
		System.out.println("Does it have meat? y/n");
		String meat = scan.next();
		if (meat.equalsIgnoreCase("y")) {
			bmeat = true;
		}

		else {
			bmeat = false;
		}

		// get user input regarding gluten presence in recipe. bgluten will be set to
		// true if answer from user is "y"
		// and to false is answer is "n"
		System.out.println("Does it have gluten? y/n");
		String gluten = scan.next();
		if (gluten.equalsIgnoreCase("y")) {
			bgluten = true;
		}

		else {
			bgluten = false;
		}

		// creates a new Recipe objects with values supplied by user.
		Recipe newRecipe = new Recipe(name, bdairy, bmeat, bgluten);
		return newRecipe;

	}

	public static void recipeChecker(ArrayList<Recipe> recipes) {
		Scanner scan = new Scanner(System.in);

		// gets user choice from vegan and veggie
		System.out.println("Would you like yo check if the recipe is vegan or vegetarian?");
		String option = scan.next();

		// gets recipe name from user
		System.out.println("Enter the recipe's name:");
		String name = scan.next();

		// loops through all Recipe object contained in the passed arrayList
		for (Recipe recipe : recipes) {
			// gets the name of the recipe from Recipe's class method get name and compares
			// it with name inputed by user.
			if (recipe.getName().equalsIgnoreCase(name)) {
				// checks option chosen from user from vegan and vegetarian options.
				if (option.equalsIgnoreCase("vegan")) {
					// uses Recipe's class methods hasDairy and hasMeat to check if recipe is vegan
					// or not.
					// recipes will only be vegan if both returned values from the method calls is
					// false.
					if (recipe.hasDairy() == false & recipe.hasMeat() == false) {
						System.out.println(name + " is a vegan recipe.");
					} else {
						System.out.println(name + " is not a vegan recipe.");
					}
				}
				// checks option chosen from user from vegan and vegetarian options.
				// recipes will only be vegetarian the returned value from the method call is
				// false.
				else if (option.equalsIgnoreCase("vegetarian")) {
					// uses Recipe's class method hasMeat to check if recipe is vegetarian or not.
					if (recipe.hasMeat() == false) {
						System.out.println(name + " is a vegetarian recipe.");
					} else {
						System.out.println(name + " is not a vegetarian recipe.");
					}
				}
				// will enter the else loop if user typed anything other than vegan or
				// vegetarian
				else {
					System.out.println("This option is not valid. Try again...");

				}

			}
			// if users input a name that is not inside the recipe ArrayList, offers the
			// option for user to add a new recipe by calling addRecipe method.
			else {
				System.out.println("This recipe is not in the system yet. Would you like to add it? y/n");
				String addOption = scan.next();
				if (addOption.equalsIgnoreCase("y")) {
					addRecipe();
				}

				else {
					System.out.println("Returning to menu...");
				}
			}
		}
	}

	// validate integers
	public static int validateInput(String userOption, int min, int max) {
		Scanner myScan = new Scanner(System.in);
		// REGEX - check if a string only contains numbers
		if (userOption.matches("^[0-9]+$")) {
			// converting userOption from String to int
			int userinput = Integer.parseInt(userOption);

			// checking if in Menu range
			if (userinput < min || userinput > max) {
				System.out.println("This is not a valid input.Please re-enter:");
				String next = myScan.next();
				return validateInput(next, min, max);
			}

			return userinput;
		}
		// if doesn't contain numbers, ask for new input
		else {
			System.out.println("This is not a valid input.Please re-enter:");
			String next = myScan.next();
			return validateInput(next, min, max);
		}
	}

	// method to print recipe objects in arrayList. output will be name only.
	public static void printRecipes(ArrayList<Recipe> list) {
		for (Recipe item : list) {
			System.out.println(item.getName());
		}
	}
}
