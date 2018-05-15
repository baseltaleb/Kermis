import java.util.ArrayList;

public class EventManager {
	static ArrayList<ITransactionListener> transactionListeners = new ArrayList<>();
	
	public static void updateTransactionListeners(Transaction transaction) {
		for(ITransactionListener listener : transactionListeners) {
			listener.onTransactionMade(transaction);
		}
	}
}
