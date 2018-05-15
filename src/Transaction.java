
public class Transaction {
	Attraction attraction;
	
	public Transaction(Attraction attraction){
		this.attraction = attraction;
	}
	
	public double getTransactionSum() {
		return attraction.getPrice();
	}
}
