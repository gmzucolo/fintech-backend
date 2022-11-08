package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.TransactionExpensesModel;
import br.com.fiap.fintech.bean.UserModel;
import br.com.fiap.fintech.singleton.ConnectionFactory;

public class TransactionExpensesDao {

    public void insertTransactionExpenses(TransactionExpensesModel transactionExpenses, UserModel user) {

        String sqlInsert = "INSERT INTO T_SIP_TRANSACTION_EXPENSES(ID_TRANSACTION_EXPENSES, T_SIP_USER_INFO_ID_USER, VL_TRANSACTION_EXPENSES, TP_TRANSACTION_EXPENSES)"
                + "VALUES (?, ?, ?, ?)";

        Connection connection;
        PreparedStatement pstm = null;

        try {
            connection = ConnectionFactory.createConnectionToSQL();

            pstm = connection.prepareStatement(sqlInsert);
            pstm.setInt(1, transactionExpenses.getIdTransactionExpenses());
            pstm.setInt(2, user.getIdUser());
            pstm.setDouble(3, transactionExpenses.getVlTransactionExpenses());
            pstm.setString(4, transactionExpenses.getTpTransactionExpenses());

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

    public List<TransactionExpensesModel> getAllTransactionExpenses() {

        String sqlGetAllTransactionExpenses = "SELECT * FROM T_SIP_TRANSACTION_EXPENSES";

        List<TransactionExpensesModel> transactionExpensesList = new ArrayList<TransactionExpensesModel>();

        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet result = null;

        try {
            connection = ConnectionFactory.createConnectionToSQL();

            pstm = (PreparedStatement) connection.prepareStatement(sqlGetAllTransactionExpenses);

            result = pstm.executeQuery();

            TransactionExpensesModel transactionExpensesModel;
            while (result.next()) {
                transactionExpensesModel = new TransactionExpensesModel();
                transactionExpensesModel.setIdTransactionExpenses(result.getInt("id_transaction_expenses"));
                transactionExpensesModel.setVlTransactionExpenses(result.getDouble("vl_transaction_expenses"));
                transactionExpensesModel.setTpTransactionExpenses(result.getString("tp_transaction_expenses"));

                transactionExpensesList.add(transactionExpensesModel);

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
        return transactionExpensesList;
    }
}
