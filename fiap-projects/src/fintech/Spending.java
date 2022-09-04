package fintech;

public class Spending {

	private int spendingId;
	private long spendingValue;
	private String spendingType;

	public Spending() {
	}

	public Spending(int spendingId, long spendingValue, String spendingType) {
		this.spendingId = spendingId;
		this.spendingValue = spendingValue;
		this.spendingType = spendingType;

	}

	public int getSpendingId() {
		return spendingId;
	}

	private void setSpendingId(int spendingId) {
		this.spendingId = spendingId;
	}

	public long getSpendingValue() {
		return spendingValue;
	}

	private void setSpendingValue(long spendingValue) {
		this.spendingValue = spendingValue;
	}

	public String getSpendingType() {
		return spendingType;
	}

	private void setSpendingType(String spendingType) {
		this.spendingType = spendingType;
	}

	protected void createSpending(int spendingId, long spendingValue, String spendingType) {
	}

	protected void editSpending(Spending spending) {
	}

	protected void deleteSpending(Spending spending) {
	}

}
