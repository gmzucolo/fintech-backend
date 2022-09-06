package fintech;

public class CurrentAccount extends Account {

    private double chequeEspecial;


    public CurrentAccount() {
        super();
    }

    public CurrentAccount(int accountId, String bankNr, String agencyNr, String accountNr, String verifyDig, String operationNr, long accountBalance, User user, Event event, double chequeEspecial) {
        super(accountId, bankNr, agencyNr, accountNr, verifyDig, operationNr, accountBalance, user, event);
    }

    @Override
    public int getAccountId() {
        return super.getAccountId();
    }

    @Override
    public String getBankNr() {
        return super.getBankNr();
    }

    @Override
    public String getAgencyNr() {
        return super.getAgencyNr();
    }

    @Override
    public String getAccountNr() {
        return super.getAccountNr();
    }

    @Override
    public String getVerifyDig() {
        return super.getVerifyDig();
    }

    @Override
    public String getOperationNr() {
        return super.getOperationNr();
    }

    @Override
    public long getAccountBalance() {
        return super.getAccountBalance();
    }

    @Override
    protected void createAccount(int accountId, String bankNr, String agencyNr, String accountNr, String verifyDig, String operationNr, long accountBalance, User user, Event event) {
        super.createAccount(accountId, bankNr, agencyNr, accountNr, verifyDig, operationNr, accountBalance, user, event);
    }

    @Override
    protected void editAccount(Account account) {
        super.editAccount(account);
    }

    @Override
    protected void deleteAccount(Account account) {
        super.deleteAccount(account);
    }

}
