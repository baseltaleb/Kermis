import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;

public class View {
	
	private Scanner scan = new Scanner(System.in);
	private String lastInput;
	
	public String getLastInpu() {
		return lastInput;
	}

	public String showRideSelectionMenu(List<Attraction> rides) {
		System.out.println("Please select a ride: ");

		for(int i = 0; i < rides.size(); i++) {
			Attraction ride = rides.get(i);
			System.out.println(i + 1 + " " + ride.getName() 
				+ " for €" + ride.getPrice() );
		}
		lastInput = scan.next();
		return lastInput;
	}
	
	public String showRideActionMenu() {
		System.out.println("Please select an action: ");
		System.out.println("1. Buy ticket");
		System.out.println("2. Return to menu");
		return scan.next();
	}
	
	public void printInvalidSelectionMessage() {
		System.out.println("Selection invalid, please try again.../n");
	}

	public void printMessage(String message) {
		System.out.println(message);
	}
	
	public void printGoodBuyMessage(boolean transactionMade) {
		if(transactionMade)
			System.out.println("Please recieve your ticket from the slot below. Have fun.");
		else
			System.out.println("Thank you for visiting.");
	}

	public void printTransactionConfirmation(String transactionName) {
		System.out.println("You ordered " + transactionName + ".");
	}
	
}
