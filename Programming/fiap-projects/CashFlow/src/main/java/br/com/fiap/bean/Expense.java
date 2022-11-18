package br.com.fiap.bean;

public class Expense {
	
	private int idExpense;
	private Double vlExpense;

	public Expense() {
	}
	
	public Expense(int idExpense, Double vlExpense) {
		this.setIdExpense(idExpense);
		this.setVlExpense(vlExpense);
	}

	public int getIdExpense() {
		return idExpense;
	}

	public void setIdExpense(int idExpense) {
		this.idExpense = idExpense;
	}

	public Double getVlExpense() {
		return vlExpense;
	}

	public void setVlExpense(Double vlExpense) {
		this.vlExpense = vlExpense;
	}
	

}
