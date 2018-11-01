// Benjamin Bowser
// CSE274 UA
public class StockPurchase {

	public int sharesBought;
	public double pricePerShare;
	public String symbol;
	public StockPurchase(String name, int shares, double price) {
		sharesBought = shares;
		pricePerShare = price;
		symbol = name;
	}
	public int getSharesBought() {
		return sharesBought;
	}
	public double getPricePerShare() {
		return pricePerShare;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSharesBought(int sharesBought) {
		this.sharesBought = sharesBought;
	}

	public String toString() {
		String builder = "Stocks Symbol: " + symbol + "\nPrice: " + pricePerShare + "\nNumber Owned: " + sharesBought;
		return builder;	
	}	
}