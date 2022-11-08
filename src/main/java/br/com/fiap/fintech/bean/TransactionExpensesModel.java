package br.com.fiap.fintech.bean;

public class TransactionExpensesModel {

    private int idTransactionExpenses;
    private Double vlTransactionExpenses;
    private String tpTransactionExpenses;

    public TransactionExpensesModel() {
    }

    public TransactionExpensesModel(int idTransactionExpenses, Double vlTransactionExpenses, String tpTransactionExpenses) {
        this.setIdTransactionExpenses(idTransactionExpenses);
        this.setVlTransactionExpenses(vlTransactionExpenses);
        this.setTpTransactionExpenses(tpTransactionExpenses);
    }

    public int getIdTransactionExpenses() {
        return idTransactionExpenses;
    }

    public void setIdTransactionExpenses(int idTransactionExpenses) {
        this.idTransactionExpenses = idTransactionExpenses;
    }

    public Double getVlTransactionExpenses() {
        return vlTransactionExpenses;
    }

    public void setVlTransactionExpenses(Double vlTransactionExpenses) {
        this.vlTransactionExpenses = vlTransactionExpenses;
    }

    public String getTpTransactionExpenses() {
        return tpTransactionExpenses;
    }

    public void setTpTransactionExpenses(String tpTransactionExpenses) {
        this.tpTransactionExpenses = tpTransactionExpenses;
    }
}
