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
    	
    	String sqlUpdate =
                "UPDATE T_SIP_USER_INFO SET NM_USER = ?, CPF_USER = ?, DS_USER_EMAIL = ?, NR_USER_PHONE = ?, NR_USER_DDI = ?, NR_USER_DDD = ? WHERE ID_USER = ?";
    	
    	Connection connection;
    	PreparedStatement pstm = null;
    	
    	try {
            connection = ConnectionFactory.createConnectionToSQL();
            
            pstm = connection.prepareStatement(sqlUpdate);           
            pstm.setString(1, userModel.getNameUser());
            pstm.setLong(2, userModel.getCpfUser());
            pstm.setString(3, userModel.getEmailUser());
            pstm.setInt(4, userModel.getPhoneUser());
            pstm.setInt(5, userModel.getDdiUser());
            pstm.setInt(6, userModel.getDddUser());
            pstm.setInt(7, userModel.getIdUser());
            
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

    public void removeUser(int idUser) throws SQLException {
    	String sqlDelete =
                "DELETE FROM T_SIP_USER_INFO WHERE ID_USER = ?";
    	
    	Connection connection;
    	PreparedStatement pstm = null;
    	
    	try {
            connection = ConnectionFactory.createConnectionToSQL();
            
            pstm = connection.prepareStatement(sqlDelete);           
            pstm.setInt(1, idUser);
            
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

    public UserModel getUserById(int idUser) throws SQLException {
    	
    	String sqlGetUserById = "SELECT * FROM T_SIP_USER_INFO WHERE ID_USER = ?";

        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet result = null;
        UserModel userModel = null;

        try {
            connection = ConnectionFactory.createConnectionToSQL();

            pstm = (PreparedStatement) connection.prepareStatement(sqlGetUserById);
            pstm.setInt(1, idUser);          
            result = pstm.executeQuery();
                       
            if (result.next()) {           
                String nameUser = result.getString("nm_user");
                Long cpfUser = result.getLong("cpf_user");
                String emailUser = result.getString("ds_user_email");
                int phoneUser = result.getInt("nr_user_phone");
                int ddiUser = result.getInt("nr_user_ddi");
                int dddUser = result.getInt("nr_user_ddd");

                userModel = new UserModel(idUser, nameUser, cpfUser, emailUser, phoneUser, ddiUser, dddUser);

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
    	return userModel;
    }

    public List<UserModel> getAllUsers() {

        String sqlGetAllUsers = "SELECT * FROM T_SIP_USER_INFO";

        List<UserModel> userList = new ArrayList<UserModel>();

        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet result = null;
        UserModel userModel;
        
        try {
            connection = ConnectionFactory.createConnectionToSQL();

            pstm = (PreparedStatement) connection.prepareStatement(sqlGetAllUsers);

            result = pstm.executeQuery();
          
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
