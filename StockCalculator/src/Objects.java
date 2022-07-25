
import java.lang.Math;
import java.util.Scanner;

class Objects {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// create an array of 10 new Item objects.
		Item[] objectsList = new Item[10];

		// create 10 new Item objects and set a random value from 1-20 for price and 0-6
		// for stock.
		for (int i = 0; i < objectsList.length; i++) {
			int price = (int) ((Math.random() * 20) + 1);
			int stock = (int) (Math.random() * 6);
			objectsList[i] = new Item();
			objectsList[i].setPrice(price);
			objectsList[i].setStock(stock);

		}

		// print Item index, price (using Item class getter) and stock (using Item class
		// getter).
		System.out.println("Index | Price | Stock");
		for (int i = 0; i < objectsList.length; i++) {
			String index = Integer.toString(i + 1);
			String price = Integer.toString(objectsList[i].getPrice());
			String stock = Integer.toString(objectsList[i].getStock());
			System.out.printf("%3s %8s %6s %n", index, price, stock);
		}

		System.out.println("Type the item bought:");
		int itemNumber = scan.nextInt();

		System.out.println("Type item quantity:");
		int quantity = scan.nextInt();

		// calling buyItem method on object list and replacing the objectList array so
		// stock value of bought item is updated.
		objectsList = buyItem(objectsList, itemNumber, quantity);

		// print value of leftover merchandise
		totalPrice(objectsList);

	}

	public static Item[] buyItem(Item[] list, int i, int amount) {

		int stock = list[i - 1].getStock();
		int price = list[i - 1].getPrice();
		// check if amount used on method call is bigger than stock.
		if (amount > stock) {
			System.out.println("Not enough stock.");
		}

		else {
			// calculate total price.
			int total = price * amount;

			// calculate new stock.
			int newstock = stock - amount;

			// set new stock value to item.s
			list[i].setStock(newstock);

			// print total purchase price.
			System.out.println("The total price is: " + Integer.toString(total));
			System.out.println("Leftover stock is: " + Integer.toString(newstock));

		}

		// return the array with new stock value for bought item.
		return list;
	}

	public static void totalPrice(Item[] list) {
		int total = 0;
		// loop through array of Item objects and get stock and price using class
		// getters.
		for (int i = 0; i < list.length; i++) {
			int stock = list[i].getStock();
			int price = list[i].getPrice();
			// calculate total purchase price.
			total += price * stock;
		}

		// print total purchase price.
		System.out.println("The total price of left mechandise is: " + Integer.toString(total));
	}
}
