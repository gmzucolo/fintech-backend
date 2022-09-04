package fintech;

public class User {

	private int userId;
	private String userName;
	private String userCpf;
	private String userEmail;
	private String userPhone;
	private String userPassword;

	public User() {
	}

	public User(int userId, String userName, String userCpf, String userEmail, String userPhone, String userPassword) {

		this.userId = userId;
		this.userName = userName;
		this.userCpf = userCpf;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userPassword = userPassword;
	}
	
	



	@Override
	public String toString() {
		return userName;
	}

	public int getUserId() {
		return userId;
	}

	private void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	private void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCpf() {
		return userCpf;
	}

	private void setUserCpf(String userCpf) {
		this.userCpf = userCpf;
	}

	public String getUserEmail() {
		return userEmail;
	}

	private void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	private void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPassword() {
		return userPassword;
	}

	private void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	protected void createUser(int userId, String userName, String userCpf, String userEmail, String userPhone,
			String userPassword) {

	}

	protected void editUser(User user) {

	}

	protected void deleteuser(User user) {

	}

}
