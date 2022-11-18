package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.bean.Expense;
import br.com.fiap.bean.User;
import br.com.fiap.exception.DBException;

public interface ExpenseDAO {
	
	void insertExpense(Expense expense, User user) throws DBException;
	
	void updateExpense(Expense expense) throws DBException;
	
	void removeExpense(int idExpense) throws DBException; 
	
	Expense getExpenseById(int idExpense) throws DBException;
	
	List<Expense> getAllExpenses();

}
