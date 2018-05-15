import java.lang.reflect.Method;

public class InputHandler {
	
	public enum ResultType{
		Number,
		Revenue,
		Tickets,
		Menu,
		Quit,
		Invalid
	}
	private View view;
	private String input;
	private ResultType resultType;
	private int result;
	
	public InputHandler(View view, String input) {
		this.view = view;
		this.input = input;
		processResult();
	}
	
	private void processResult() {
		try {
			result = Integer.parseInt(input);
			resultType = ResultType.Number;
		} catch (NumberFormatException e) {
			if(input.equalsIgnoreCase("q"))
				resultType = ResultType.Quit;
			else if(input.equalsIgnoreCase("r"))
				resultType = ResultType.Revenue;
			else if(input.equalsIgnoreCase("t"))
				resultType = ResultType.Tickets;
			else if(input.equalsIgnoreCase("m"))
				resultType = ResultType.Menu;
			else
				resultType = ResultType.Invalid;
		}
	}
	
	public boolean validateResultInt(int min, int max) {
		if(result < min || result > max)
			return false;
		return true;
	}
	public ResultType getResultType() {
		return resultType;
	}
	
	public int getResult(){
		if(resultType != ResultType.Number)
			return -1;
		return result;
	}
	
	public boolean handleResult(Program program) {
		switch (resultType) {
		case Revenue:
			view.printMessage("Total revenue = " + program.getCashDesk().getTotalRevenue());
			return true;
		case Tickets:
			view.printMessage("Total tickets sold = " + program.getCashDesk().getTotalTransactions());
			return true;
		case Menu:
			view.showRideSelectionMenu(Program.ridesList);
			return true;
		case Invalid:
			view.printMessage("Invalid selection; Please try again...");
			return true;
		case Quit:
			program.Quit();
		default:
			return false;
		}
	}

}
