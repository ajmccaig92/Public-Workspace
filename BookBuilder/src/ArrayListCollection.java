// Fig. 7.24: ArrayListCollection.java
// Generic ArrayList collection demonstration.
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListCollection {
	public static void main(String[] args) {
		// Create empty ArrayList capable of holding references to String objects.
		// The following two lines are best written as one.
		// They are split only to explore issues using the debugger.
		ArrayList<String> listItems = null;
		listItems = new ArrayList<String>();
		// The following line is normally a better way to write the code. 
		// ArrayList<String> items = new ArrayList<String>();

		listItems.add("red"); // append an item to the list
		listItems.add(0, "yellow"); // insert the value at index 0

		System.out.print("Display list contents with counter-controlled loop:");

		// display the colors in the list
		for (int i = 0; i < listItems.size(); i++)
			System.out.printf(" %s", listItems.get(i));

		display(listItems, "\nDisplay list contents with enhanced for statement:");

		listItems.add("green"); // add "green" to the end of the list
		listItems.add("yellow"); // add "yellow" to the end of the list
		display(listItems, "List with two new elements:");

		listItems.remove("yellow"); // remove the first "yellow"
		display(listItems, "Remove first instance of yellow:");

		listItems.remove(1); // remove item at index 1
		display(listItems, "Remove second list element (green):");

		System.out.printf("\"red\" is %sin the list\n", listItems.contains("red") ? "" : "not ");

		System.out.printf("Size: %d\n", listItems.size());
		
		listItems.clear();
		System.out.printf("Size: %d\n", listItems.size());

		listItems.add("Jim");
		listItems.add("Jill");
		listItems.add("Janice");
		listItems.add("Jack");
		listItems.add("Jenn");
		listItems.add("Jerry");
		listItems.add("John");
		listItems.add("Jeff");
		listItems.add("Joey");
		listItems.add("Jake");
		listItems.add("Joan");
		listItems.add("James");

		display(listItems, "Set of names before sort:");
		Collections.sort(listItems);
		display(listItems, "Set of names after sort:");
	} // end main

	// display the ArrayList's elements on the console
	public static void display(ArrayList<String> items, String header) {
		System.out.print(header); // display header

		// display each element in items
		for (String item : items)
			System.out.printf(" %s", item);

		System.out.println(); // display end of line
	} // end method display
} // end class ArrayListCollection
