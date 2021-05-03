package se.kth.iv1350.dbHandler;

import java.util.*;

import se.kth.iv1350.model.Item;
import se.kth.iv1350.model.DTO.RecieptDTO;

public class ExternalInventory {

	private ArrayList<Item> listOfItems;

	public Item getExistingItem(int itemIdentifier) throws Exception {

		Item foundItem = null;
		for (Item searchedItem : listOfItems){
			if(searchedItem.itemIdentifier == itemIdentifier){
				foundItem = searchedItem;
			}
		}
		if (foundItem == null){
			throw new Exception("The identifier does not exist" + itemIdentifier);
		}

		foundItem.quantity = 0;

		return foundItem;
	}

	public void updateInventory(RecieptDTO printReci) {

	}

	public ExternalInventory () {
		listOfItems = new ArrayList<>();
		Item tomato = new Item("Tomato", 0, 1.12, 6, 450);
		Item egg = new Item("Egg", 1, 1.12, 2, 400);
		Item prosciutto = new Item("Prosciutto", 2, 1.12, 60, 100);
		Item meatballs = new Item("Meatballs", 3, 1.12, 30, 150);
		Item mustard = new Item("Mustard", 4, 1.12, 23, 0);
		Item redCabbage = new Item("Red cabbage", 5, 1.12, 10, 63);
		Item saltAndVinegarChips = new Item("Salt and Vinegar chips", 6, 1.12, 19, 20);
		Item coffeeMediumRoast = new Item("Coffee Medium Roast", 7, 1.12, 45, 34);
		Item toiletPaper = new Item("Toilet paper 6p", 8, 1.25, 40, 27);

		Collections.addAll(listOfItems, tomato, egg, prosciutto, meatballs, mustard,
				redCabbage, saltAndVinegarChips, coffeeMediumRoast, toiletPaper);
	}

}
