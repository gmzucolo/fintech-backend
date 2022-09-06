package fintech;

public class Test {

	public static void main(String[] args) {

		User gustavo = new User(01, "gustavo", "12345678910", "gustavo@email.com.br", "19 123456789", "123");
		CurrentAccount contaCorrente1 = new CurrentAccount(01, "123", "1234", "12345", "1", null, 0, gustavo, null, 100000.00);
		
		System.out.println(contaCorrente1);
	}

}
