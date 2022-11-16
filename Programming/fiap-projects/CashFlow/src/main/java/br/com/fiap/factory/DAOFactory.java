package br.com.fiap.factory;

import br.com.fiap.dao.UserDAO;
import br.com.fiap.dao.impl.OracleUserDAO;

public class DAOFactory {
	
	public static UserDAO getUserDAO() {
		return new OracleUserDAO();
	}

}
