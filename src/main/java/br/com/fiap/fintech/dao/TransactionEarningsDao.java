package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.TransactionEarningsModel;
import br.com.fiap.fintech.bean.UserModel;
import br.com.fiap.fintech.singleton.ConnectionFactory;

public class TransactionEarningsDao {

    public void insertTransactionEarnings(TransactionEarningsModel transactionEarnings, UserModel user) {

        String sqlInsert = "INSERT INTO T_SIP_TRANSACTION_EARNINGS(ID_TRANSACTION_EARNINGS, T_SIP_USER_INFO_ID_USER, VL_TRANSACTION_EARNINGS, TP_TRANSACTION_EARNINGS)"
                + "VALUES (?, ?, ?, ?)";

        Connection connection;
        PreparedStatement pstm = null;

        try {
            connection = ConnectionFactory.createConnectionToSQL();

            pstm = connection.prepareStatement(sqlInsert);
            pstm.setInt(1, transactionEarnings.getIdTransactionEarnings());
            pstm.setInt(2, user.getIdUser());
            pstm.setDouble(3, transactionEarnings.getVlTransactionEarnings());
            pstm.setString(4, transactionEarnings.getTpTransactionEarnings());

            pstm.execute();

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

    public List<TransactionEarningsModel> getAllTransactionEarnings() {

        String sqlGetAllTransactionEarnings = "SELECT * FROM T_SIP_TRANSACTION_EARNINGS";

        List<TransactionEarningsModel> transactionEarningsList = new ArrayList<TransactionEarningsModel>();

        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet result = null;

        try {
            connection = ConnectionFactory.createConnectionToSQL();

            pstm = (PreparedStatement) connection.prepareStatement(sqlGetAllTransactionEarnings);

            result = pstm.executeQuery();

            TransactionEarningsModel transactionEarningsModel;
            while (result.next()) {
                transactionEarningsModel = new TransactionEarningsModel();
                transactionEarningsModel.setIdTransactionEarnings(result.getInt("id_transaction_earnings"));
                transactionEarningsModel.setVlTransactionEarnings(result.getDouble("vl_transaction_earnings"));
                transactionEarningsModel.setTpTransactionEarnings(result.getString("tp_transaction_earnings"));

                transactionEarningsList.add(transactionEarningsModel);

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
        return transactionEarningsList;
    }
}
