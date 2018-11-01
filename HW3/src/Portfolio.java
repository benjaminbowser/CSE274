// Benjamin Bowser
// CSE274 UA
import java.util.*;

public class Portfolio {
	private Vector<String> stocksOwned;
	private Vector<Deque<StockPurchase>> stocks;
	private Deque<StockPurchase> ledger;

	public Portfolio() {
		stocks = new Vector<>();
		stocksOwned = new Vector<String>();
	}
	// Throw error if parameters are non-sensical
	public void buy(String symbol, int shares, double pricePerShare) {
		if (symbol.length() < 1 || shares < 0 || pricePerShare < 0) {
			throw new ValueOutOfBounds("The symbol name, number of shares, or purchase price is invalid.");
		}
		StockPurchase newest = new StockPurchase(symbol, shares, pricePerShare);
		if (!stocksOwned.contains(symbol)) {
			ledger = new LinkedList<>();
			stocksOwned.add(newest.symbol);
			stocks.add(ledger);
		}
		else {
			int loc = stocksOwned.indexOf(symbol);
			ledger = stocks.elementAt(loc);
		}
		ledger.addLast(newest);
	}

	public double sell(String symbol, int shares, double pricePerShare) {
		if (symbol.length() < 1 || shares <= 0 || pricePerShare <= 0) {
			throw new ValueOutOfBounds("The symbol name, number of shares, or purchase price is invalid.");
		}
		if (!stocksOwned.contains(symbol)) {
			throw new ValueOutOfBounds("You cannot sell a stock that you do not own. Check symbol name.");
		}
		int loc = stocksOwned.indexOf(symbol);
		if (shares > shareTotal(loc)) {
			throw new ValueOutOfBounds("You cannot sell more shares than you own.");
		}
		double totalCost = 0;
		double sellingPrice = shares * pricePerShare;

		while (shares > 0) {
			StockPurchase trans = stocks.get(loc).removeFirst();

			if (trans.sharesBought > shares) {
				int leftOver = trans.sharesBought - shares;
				totalCost += shares * trans.pricePerShare;
				shares = 0;
				stocks.get(loc).addFirst(new StockPurchase(symbol, leftOver, trans.pricePerShare));
			} else {
				totalCost += trans.sharesBought * trans.pricePerShare;
				shares -= trans.sharesBought;
			}
		}
		return sellingPrice - totalCost;
	}

	public int shareTotal(int location) {
		// Help from https://www.tutorialspoint.com/java/util/arraydeque_iterator.htm
		int counter = 0;

		for(Iterator<StockPurchase> itr = stocks.get(location).iterator(); itr.hasNext();)  {
			counter += itr.next().sharesBought;
		}
		return counter;
	}

	public static void main(String[] args) {
		Portfolio portfolio = new Portfolio();
		portfolio.buy("AAPL", 100, 150.00);
		portfolio.buy("AAPL",  50, 145.00);
		portfolio.buy("AAPL", 100, 130.00);
		portfolio.buy("CSCO", 200,  29.00);
		portfolio.buy("CSCO", 200,  29.00);
		portfolio.buy("QQQ", 120, 142.00);
		portfolio.buy("LVS", 50, 61.00);

		System.out.println(portfolio.sell("AAPL", 249, 170.00));
		System.out.println(portfolio.sell("CSCO", 200,  28.00));
		System.out.println(portfolio.sell("LVS", 10, 90.00));
		System.out.println(portfolio.stocks.toString());
	}
}