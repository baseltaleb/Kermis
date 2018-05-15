import java.util.*;

import org.w3c.dom.Attr;

public class Program {
	static List<Attraction> ridesList = new ArrayList<>();
	private CashDesk cashDesk;
	private View view;
	
	public static void main(String[] args) {
		Program program = new Program();
		program.start();
	}
	
	public void Quit() {
		view.printGoodBuyMessage(false);
		System.exit(0);
	}
	
	void start() {
		for(RideSelection rs : RideSelection.values()) {
			Attraction a = new Attraction(rs.getName(), rs.getPrice());
			ridesList.add(a);
		}
		cashDesk = new CashDesk();
		view = new View();
		boolean inMainMenu = true;
		do {
			String input = view.showRideSelectionMenu(ridesList);
			InputHandler ih = new InputHandler(view, input);
			if(ih.getResultType() == InputHandler.ResultType.Number)
			{
				if(ih.validateResultInt(0, ridesList.size())) {
					Attraction a = ridesList.get(ih.getResult());
					a.buyTicket();
					view.printTransactionConfirmation(a.name);
					inMainMenu = false;
				}
				else
					view.printInvalidSelectionMessage();
			}
			else
				ih.handleResult(this);
			
		} while (inMainMenu);

		view.printGoodBuyMessage(true);
	}
	
	public CashDesk getCashDesk() {
		return cashDesk;
	}
	
}

