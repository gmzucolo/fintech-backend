package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.UserModel;
import br.com.fiap.fintech.singleton.ConnectionFactory;

public class UserDao {

    public void insertUser(UserModel userModel) throws SQLException {

        String sqlInsert =
                "INSERT INTO T_SIP_USER_INFO(ID_USER, NM_USER, CPF_USER, DS_USER_EMAIL, NR_USER_PHONE, NR_USER_DDI, NR_USER_DDD)"
                        + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection connection;
        PreparedStatement pstm = null;

        try {
            connection = ConnectionFactory.createConnectionToSQL();

            pstm = connection.prepareStatement(sqlInsert);
            pstm.setInt(1, userModel.getIdUser());
            pstm.setString(2, userModel.getNameUser());
            pstm.setLong(3, userModel.getCpfUser());
            pstm.setString(4, userModel.getEmailUser());
            pstm.setInt(5, userModel.getPhoneUser());
            pstm.setInt(6, userModel.getDdiUser());
            pstm.setInt(7, userModel.getDddUser());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Nao foi possivel se conectar ao Oracle FIAP!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("O Driver JDBC nao foi encontrado!");
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void updateUser(UserModel userModel) throws SQLException {
    	//TODO update method
    }

    public void removeUser(int idUser) throws SQLException {
    	//TODO delete method
    }

    public UserModel getUserById(int idUser) throws SQLException {
    	//TODO getUserById method
    	UserModel userModel = null;
    	return userModel;
    }

    public List<UserModel> getAllUsers() {

        String sqlGetAllUsers = "SELECT * FROM T_SIP_USER_INFO";

        List<UserModel> userList = new ArrayList<UserModel>();

        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet result = null;

        try {
            connection = ConnectionFactory.createConnectionToSQL();

            pstm = (PreparedStatement) connection.prepareStatement(sqlGetAllUsers);

            result = pstm.executeQuery();

            UserModel userModel;
            while (result.next()) {
                userModel = new UserModel();
                userModel.setIdUser(result.getInt("id_user"));
                userModel.setNameUser(result.getString("nm_user"));
                userModel.setCpfUser(result.getLong("cpf_user"));
                userModel.setEmailUser(result.getString("ds_user_email"));
                userModel.setPhoneUser(result.getInt("nr_user_phone"));
                userModel.setDdiUser(result.getInt("nr_user_ddi"));
                userModel.setDddUser(result.getInt("nr_user_ddd"));

                userList.add(userModel);

            }

        } catch (SQLException e) {
            System.err.println("Nao foi possivel se conectar ao Oracle FIAP!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("O Driver JDBC nao foi encontrado!");
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

}
