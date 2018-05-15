import java.util.*;

public class CashDesk implements ITransactionListener {
	int totalTransactions;
	double totalRevenue;
	
	public double getTotalRevenue() {
		return totalRevenue;
	}
	
	public int getTotalTransactions() {
		return totalTransactions;
	}
	
	@Override
	public void onTransactionMade(Transaction transaction) {
		totalTransactions++;
		totalRevenue += transaction.getTransactionSum();
	}

}
