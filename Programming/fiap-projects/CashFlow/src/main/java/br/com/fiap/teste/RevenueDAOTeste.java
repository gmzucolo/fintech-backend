package br.com.fiap.teste;

import java.util.List;

import br.com.fiap.bean.Revenue;
import br.com.fiap.bean.User;
import br.com.fiap.dao.RevenueDAO;
import br.com.fiap.dao.UserDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.DAOFactory;

public class RevenueDAOTeste {

	public static void main(String[] args) {
		
		UserDAO userDAO = DAOFactory.getUserDAO();

		// insert user
		User user = new User(1, "gustavo", 1111111111, "teste1@teste.com.br");

		try {
			userDAO.insertUser(user);
			System.out.println("usuario cadastrado");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		RevenueDAO revenueDAO = DAOFactory.getRevenueDAO();
		
		//insert revenue
		Revenue revenue = new Revenue(1, 100.00);
		
		try {
			revenueDAO.insertRevenue(revenue, user);
			System.out.println("ganho cadastrado");
		} catch (DBException e) {
			e.printStackTrace();
		}

//		// fetch user by id and update
//		revenue = revenueDAO.getRevenueById(1);
//		revenue.setNameUser("adriano");
//		try {
//			userDAO.updateUser(user);
//			System.out.println("usuario atualizado.");
//		} catch (DBException e) {
//			e.printStackTrace();
//		}
//
//		// list users
//		List<User> lista = userDAO.getAllUsers();
//		for (User item : lista) {
//			System.out.println(item.getIdUser() + " " + item.getNameUser() + " " + item.getCpfUser() + " " + item.getEmailUser());
//		}
//
//		// remove user
//		try {
//			userDAO.removeUser(1);
//			System.out.println("usuario removido.");
//		} catch (DBException e) {
//			e.printStackTrace();
//		}

	}

}
