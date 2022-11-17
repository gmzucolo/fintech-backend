package br.com.fiap.teste;

import java.util.List;

import br.com.fiap.bean.User;
import br.com.fiap.dao.UserDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.DAOFactory;

public class UserDAOTeste {

	public static void main(String[] args) throws DBException {

		UserDAO userDAO = DAOFactory.getUserDAO();

		// insert user
		User user = new User(1, "gustavo", 1111111111, "teste1@teste.com.br");

		try {
			userDAO.insertUser(user);
			System.out.println("usuario cadastrado");
		} catch (DBException e) {
			e.printStackTrace();
		}

		// fetch user by id and update
		user = userDAO.getUserById(1);
		user.setNameUser("adriano");
		user.setCpfUser(222222222);
		user.setEmailUser("teste2@teste.com.br");
		try {
			userDAO.updateUser(user);
			System.out.println("usuario atualizado.");
		} catch (DBException e) {
			e.printStackTrace();
		}

		// list users
		List<User> lista = userDAO.getAllUsers();
		for (User item : lista) {
			System.out.println(item.getIdUser() + " " + item.getNameUser() + " " + item.getCpfUser() + " " + item.getEmailUser());
		}

		// remove user
		try {
			userDAO.removeUser(1);
			System.out.println("usuario removido.");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}
