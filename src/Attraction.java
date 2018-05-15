
public class Attraction {
	String name;
	double price;
	int timesRun;
	
	public Attraction(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public void run() {
		//System.out.println("Running " + name);
		timesRun++;
	}
	
	public void buyTicket() {
		Transaction transaction = new Transaction(this);
		EventManager.updateTransactionListeners(transaction);
		run();
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getTimesRun() {
		return timesRun;
	}
	
	public String toString() {
		return name;
	}
}
