package fintech;

public class Authenticator {

	private User user;
	private Account account;

	public Authenticator() {
	}

	public Authenticator(User user, Account account) {
		this.user = user;
		this.account = account;
	}

	public User getUser() {
		return user;
	}

	private void setUser(User user) {
		this.user = user;
	}

	public Account getAccount() {
		return account;
	}

	private void setAccount(Account account) {
		this.account = account;
	}

	protected void doLogin(User user, Account account) {
	}

	protected void doLogout() {
	}

}
