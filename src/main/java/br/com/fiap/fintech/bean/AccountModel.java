package br.com.fiap.fintech.bean;

public class AccountModel {

    private int idAccount;
    private int nrBank;
    private int nrAgency;
    private int nrAccount;
    private int nrDigVerify;
    private int nrOp;

    public AccountModel() {
    }

    public AccountModel(int idAccount, int nrBank, int nrAgency, int nrAccount, int nrDigVerify, int nrOp) {
        this.setIdAccount(idAccount);
        this.setNrBank(nrBank);
        this.setNrAgency(nrAgency);
        this.setNrAccount(nrAccount);
        this.setNrDigVerify(nrDigVerify);
        this.setNrOp(nrOp);
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public int getNrBank() {
        return nrBank;
    }

    public void setNrBank(int nrBank) {
        this.nrBank = nrBank;
    }

    public int getNrAgency() {
        return nrAgency;
    }

    public void setNrAgency(int nrAgency) {
        this.nrAgency = nrAgency;
    }

    public int getNrAccount() {
        return nrAccount;
    }

    public void setNrAccount(int nrAccount) {
        this.nrAccount = nrAccount;
    }

    public int getNrDigVerify() {
        return nrDigVerify;
    }

    public void setNrDigVerify(int nrDigVerify) {
        this.nrDigVerify = nrDigVerify;
    }

    public int getNrOp() {
        return nrOp;
    }

    public void setNrOp(int nrOp) {
        this.nrOp = nrOp;
    }
}

