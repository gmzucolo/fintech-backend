package fintech;

public class Account {

	private int accountId;
	private String bankNr;
	private String agencyNr;
	private String accountNr;
	private String verifyDig;
	private String operationNr;
	private long accountBalance;
	private User user;
	private Event event;

	public Account() {
	}

	public Account(int accountId, String bankNr, String agencyNr, String accountNr, String verifyDig,
			String operationNr, long accountBalance, User user, Event event) {

		this.accountId = accountId;
		this.bankNr = bankNr;
		this.agencyNr = agencyNr;
		this.accountNr = accountNr;
		this.verifyDig = verifyDig;
		this.operationNr = operationNr;
		this.accountBalance = accountBalance;
		this.user = user;
		this.event = event;

	}
	
	@Override
	public String toString() {
		System.out.println("Número Banco: " + bankNr);
		System.out.println("Número Agência: " + agencyNr);
		System.out.println("Número Conta: " + accountNr);
		System.out.println("Número Dígito: " + verifyDig);
		System.out.println("Número Operação: " + operationNr);
		System.out.println("Titular: " + user);
		return super.toString();
	}

	public int getAccountId() {
		return accountId;
	}

	private void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getBankNr() {
		return bankNr;
	}

	private void setBankNr(String bankNr) {
		this.bankNr = bankNr;
	}

	public String getAgencyNr() {
		return agencyNr;
	}

	private void setAgencyNr(String agencyNr) {
		this.agencyNr = agencyNr;
	}

	public String getAccountNr() {
		return accountNr;
	}

	private void setAccountNr(String accountNr) {
		this.accountNr = accountNr;
	}

	public String getVerifyDig() {
		return verifyDig;
	}

	private void setVerifyDig(String verifyDig) {
		this.verifyDig = verifyDig;
	}

	public String getOperationNr() {
		return operationNr;
	}

	private void setOperationNr(String operationNr) {
		this.operationNr = operationNr;
	}

	public long getAccountBalance() {
		return accountBalance;
	}

	private void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}

	protected void createAccount(int accountId, String bankNr, String agencyNr, String accountNr, String verifyDig,
			String operationNr, long accountBalance, User user, Event event) {
	}

	protected void editAccount(Account account) {

	}

	protected void deleteAccount(Account account) {
	}	

}
