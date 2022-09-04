package fintech;

public class Earning {

	private int earningId;
	private long earningValue;
	private String earningType;

	public Earning() {
	}

	public Earning(int earningId, long earningValue, String earningType) {
		this.earningId = earningId;
		this.earningValue = earningValue;
		this.earningType = earningType;
	}

	public int getEarningId() {
		return earningId;
	}

	private void setEarningId(int earningId) {
		this.earningId = earningId;
	}

	public long getEarningValue() {
		return earningValue;
	}

	private void setEarningValue(long earningValue) {
		this.earningValue = earningValue;
	}

	public String getEarningType() {
		return earningType;
	}
	
	private void setEarningType(String earningType) {
		this.earningType = earningType;
	}

	protected void createEarning(int earningId, long earningValue, String earningType) {
	}

	protected void editEarning(Earning earning) {
	}

	protected void deleteEarning(Earning earning) {
	}

}
