package br.com.fiap.fintech.bean;

public class TransactionEarningsModel {

    private int idTransactionEarnings;
    private Double vlTransactionEarnings;
    private String tpTransactionEarnings;

    public TransactionEarningsModel() {
    }

    public TransactionEarningsModel(int idTransactionEarnings, Double vlTransactionEarnings, String tpTransactionEarnings) {
        this.setIdTransactionEarnings(idTransactionEarnings);
        this.setVlTransactionEarnings(vlTransactionEarnings);
        this.setTpTransactionEarnings(tpTransactionEarnings);
    }

    public int getIdTransactionEarnings() {
        return idTransactionEarnings;
    }

    public void setIdTransactionEarnings(int idTransactionEarnings) {
        this.idTransactionEarnings = idTransactionEarnings;
    }

    public Double getVlTransactionEarnings() {
        return vlTransactionEarnings;
    }

    public void setVlTransactionEarnings(Double vlTransactionEarnings) {
        this.vlTransactionEarnings = vlTransactionEarnings;
    }

    public String getTpTransactionEarnings() {
        return tpTransactionEarnings;
    }

    public void setTpTransactionEarnings(String tpTransactionEarnings) {
        this.tpTransactionEarnings = tpTransactionEarnings;
    }
}
