package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.bean.User;
import br.com.fiap.exception.DBException;

public interface UserDAO {
	
	void insertUser(User user) throws DBException;
	
	void updateUser(User user) throws DBException;
	
	void removeUser(int idUser) throws DBException; 
	
	User getUserById(int idUser) throws DBException;
	
	List<User> getAllUsers();

}
