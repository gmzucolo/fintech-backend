package br.com.fiap.factory;

import br.com.fiap.dao.ExpenseDAO;
import br.com.fiap.dao.RevenueDAO;
import br.com.fiap.dao.UserDAO;
import br.com.fiap.dao.impl.OracleExpenseDAO;
import br.com.fiap.dao.impl.OracleRevenueDAO;
import br.com.fiap.dao.impl.OracleUserDAO;

public class DAOFactory {
	
	public static UserDAO getUserDAO() {
		return new OracleUserDAO();
	}
	
	public static RevenueDAO getRevenueDAO() {
		return new OracleRevenueDAO();
	}
	
	public static ExpenseDAO getExpenseDAO() {
		return new OracleExpenseDAO();
	}

}
