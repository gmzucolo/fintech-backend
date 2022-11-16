package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;

import br.com.fiap.bean.User;
import br.com.fiap.dao.UserDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.singleton.ConnectionManager;

public class OracleUserDAO implements UserDAO {

	private Connection connection;

	@Override
	public void insertUser(User user) throws DBException {

		PreparedStatement pstm = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();

			String sqlInsert = "INSERT INTO TB_USER(ID_USER, NM_USER, CPF_USER, DS_USER_EMAIL)" + "VALUES (?, ?, ?, ?)";

			pstm = connection.prepareStatement(sqlInsert);
			pstm.setInt(1, user.getIdUser());
			pstm.setString(2, user.getNameUser());
			pstm.setLong(3, user.getCpfUser());
			pstm.setString(4, user.getEmailUser());
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastradar.");
		} finally {
			try {
				pstm.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void updateUser(User user) throws DBException {

		PreparedStatement pstm = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sqlUpdate = "UPDATE TB_USER SET NM_USER = ?, CPF_USER = ?, DS_USER_EMAIL = ? WHERE ID_USER = ?";

			pstm = connection.prepareStatement(sqlUpdate);
			pstm.setString(1, user.getNameUser());
			pstm.setLong(2, user.getCpfUser());
			pstm.setString(3, user.getEmailUser());
			pstm.setInt(4, user.getIdUser());
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar.");
		} finally {
			try {
				pstm.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void removeUser(int idUser) throws DBException {

		PreparedStatement pstm = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sqlDelete = "DELETE FROM TB_USER WHERE ID_USER = ?";

			pstm = connection.prepareStatement(sqlDelete);
			pstm.setInt(1, idUser);
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover.");
		} finally {
			try {
				pstm.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public User getUserById(int id) {

		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet result = null;
		User user = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();

			pstm = connection.prepareStatement("SELECT * FROM TB_USER WHERE ID_USER = ?");
			pstm.setInt(1, id);
			result = pstm.executeQuery();

			if (result.next()) {
				int idUser = result.getInt("id_user");
				String nameUser = result.getString("nm_user");
				Long cpfUser = result.getLong("cpf_user");
				String emailUser = result.getString("ds_user_email");

				user = new User(idUser, nameUser, cpfUser, emailUser);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return user;
	}

	@Override
	public List<User> getAllUsers() {

		List<User> userList = new ArrayList<User>();
		PreparedStatement pstm = null;
		ResultSet result = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();

			String sqlGetAllUsers = "SELECT * FROM TB_USER";
			pstm = (PreparedStatement) connection.prepareStatement(sqlGetAllUsers);
			result = pstm.executeQuery();

			while (result.next()) {
				int idUser = result.getInt("id_user");
				String nameUser = result.getString("nm_user");
				Long cpfUser = result.getLong("cpf_user");
				String emailUser = result.getString("ds_user_email");

				User user = new User(idUser, nameUser, cpfUser, emailUser);
				userList.add(user);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return userList;
	}

}
