package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.AccountModel;
import br.com.fiap.fintech.bean.UserModel;
import br.com.fiap.fintech.singleton.ConnectionFactory;

public class AccountDao {

    public void insertAccount(AccountModel account, UserModel userModel) {

        String sqlInsert = "INSERT INTO T_SIP_USER_ACCOUNT (ID_USER_ACCOUNT, T_SIP_USER_INFO_ID_USER, NR_BANK, NR_AGENCY, NR_ACCOUNT, NR_DIG_VERIFY, NR_OP)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection connection;
        PreparedStatement pstm = null;

        try {
            connection = ConnectionFactory.createConnectionToSQL();

            pstm = connection.prepareStatement(sqlInsert);
            pstm.setInt(1, account.getIdAccount());
            pstm.setInt(2, userModel.getIdUser());
            pstm.setInt(3, account.getNrBank());
            pstm.setInt(4, account.getNrAgency());
            pstm.setInt(5, account.getNrAccount());
            pstm.setInt(6, account.getNrDigVerify());
            pstm.setInt(7, account.getNrOp());

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
    
    public void updateAccount(AccountModel accountModel, UserModel userModel) throws SQLException {
    	
    	String sqlUpdate = 
    			"UPDATE T_SIP_USER_ACCOUNT SET ID_ACCOUNT = ?, NR_BANK = ?, NR_AGENCY = ?, NR_ACCOUNT = ?, NR_DIG_VERIFY = ?, NR_OP = ? WHERE ID_USER = ?";
    
    	Connection connection;
    	PreparedStatement pstm = null;
    	
    	try {
    		connection = ConnectionFactory.createConnectionToSQL();
    		
    		pstm = connection.prepareStatement(sqlUpdate);                  
    		pstm.setInt(1, accountModel.getIdAccount());
            pstm.setInt(2, accountModel.getNrBank());
            pstm.setInt(3, accountModel.getNrAgency());
            pstm.setInt(4, accountModel.getNrAccount());
            pstm.setInt(5, accountModel.getNrDigVerify());
            pstm.setInt(6, accountModel.getNrOp());
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
    
    public void removeAccount(int idAccount) throws SQLException {
    	
    	String sqlDelete =
                "DELETE FROM T_SIP_USER_ACCOUNT WHERE ID_USER_ACCOUNT = ?";
    	
    	Connection connection;
    	PreparedStatement pstm = null;
    	
    	try {
            connection = ConnectionFactory.createConnectionToSQL();
            
            pstm = connection.prepareStatement(sqlDelete);           
            pstm.setInt(1, idAccount);
            
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
    
    public AccountModel getAccountById(int idAccount) throws SQLException {
    	
    	String sqlGetAccountById = "SELECT * FROM T_SIP_USER_ACCOUNT WHERE ID_USER_ACCOUNT= ?";

        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet result = null;
        AccountModel accountModel = null;

        try {
            connection = ConnectionFactory.createConnectionToSQL();

            pstm = (PreparedStatement) connection.prepareStatement(sqlGetAccountById);
            pstm.setInt(1, idAccount);          
            result = pstm.executeQuery();
                       
            if (result.next()) {           
//            	int idAccount = result.getInt("id_user_account");
            	int nrBank = result.getInt("nr_bank");
            	int nrAgency = result.getInt("nr_agency");
                int nrAccount = result.getInt("nr_account");
                int nrDigVerify = result.getInt("nr_dig_verify");
                int nrOp = result.getInt("nr_op");

                accountModel = new AccountModel(idAccount, nrBank, nrAgency, nrAccount, nrDigVerify, nrOp);

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
    	return accountModel;
    }
    
    public List<AccountModel> getAllAccounts() {

        String sqlGetAllAccounts = "SELECT * FROM T_SIP_USER_ACCOUNT";

        List<AccountModel> accountList = new ArrayList<AccountModel>();

        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet result = null;

        try {
            connection = ConnectionFactory.createConnectionToSQL();

            pstm = (PreparedStatement) connection.prepareStatement(sqlGetAllAccounts);

            result = pstm.executeQuery();

            AccountModel accountModel;
            while (result.next()) {
                accountModel = new AccountModel();
                accountModel.setIdAccount(result.getInt("id_user_account"));
                accountModel.setNrBank(result.getInt("nr_bank"));
                accountModel.setNrBank(result.getInt("nr_agency"));
                accountModel.setNrBank(result.getInt("nr_account"));
                accountModel.setNrBank(result.getInt("nr_dig_verify"));
                accountModel.setNrBank(result.getInt("nr_op"));

                accountList.add(accountModel);

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
        return accountList;
    }
}
