
public class Customer {
	public int num, arrivalTime, transactionTime;

	public Customer(int custNum, int arr, int trans) {
		num = custNum;
		arrivalTime = arr;
		transactionTime = trans;
	}
	public int getArrivalTime() { return arrivalTime; }
	public int getCustomerNumber() { return num; }
	public int getTransactionTime() { return transactionTime; }
	
}
