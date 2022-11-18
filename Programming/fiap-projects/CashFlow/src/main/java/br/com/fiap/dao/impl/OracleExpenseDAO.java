package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Expense;
import br.com.fiap.bean.User;
import br.com.fiap.dao.ExpenseDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.singleton.ConnectionManager;

public class OracleExpenseDAO implements ExpenseDAO{
	
	private Connection connection;

	@Override
	public void insertExpense(Expense expense, User user) throws DBException {

		PreparedStatement pstm = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();

			String sqlInsert = "INSERT INTO TB_EXPENSE(ID_EXPENSE, TB_USER_ID_USER, VL_EXPENSE)" + "VALUES (?, ?, ?)";

			pstm = connection.prepareStatement(sqlInsert);
			pstm.setInt(1, expense.getIdExpense());
			pstm.setInt(2, user.getIdUser());
			pstm.setDouble(3, expense.getVlExpense());		
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
	public void updateExpense(Expense expense) throws DBException {

		PreparedStatement pstm = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sqlUpdate = "UPDATE TB_EXPENSE SET VL_EXPENSE = ? WHERE ID_EXPENSE = ?";

			pstm = connection.prepareStatement(sqlUpdate);
			pstm.setDouble(1, expense.getVlExpense());
			pstm.setInt(2, expense.getIdExpense());
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
	public void removeExpense(int idExpense) throws DBException {

		PreparedStatement pstm = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sqlDelete = "DELETE FROM TB_EXPENSE WHERE ID_EXPENSE = ?";

			pstm = connection.prepareStatement(sqlDelete);
			pstm.setInt(1, idExpense);
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
	public Expense getExpenseById(int idExpense) {

		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet result = null;
		Expense expense = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();

			pstm = connection.prepareStatement("SELECT * FROM TB_EXPENSE WHERE ID_EXPENSE = ?");
			pstm.setInt(1, idExpense);
			result = pstm.executeQuery();

			if (result.next()) {
				Double vlExpense = result.getDouble("vl_expense");				

				expense = new Expense(idExpense, vlExpense);

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

		return expense;
	}

	@Override
	public List<Expense> getAllExpenses() {

		List<Expense> userExpense = new ArrayList<Expense>();
		PreparedStatement pstm = null;
		ResultSet result = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();

			String sqlGetAllExpenses = "SELECT * FROM TB_EXPENSE";
			pstm = (PreparedStatement) connection.prepareStatement(sqlGetAllExpenses);
			result = pstm.executeQuery();

			while (result.next()) {
				int idExpense = result.getInt("id_expense");				
				Double vlExpense = result.getDouble("vl_expense");
				Expense expense = new Expense(idExpense, vlExpense);
				userExpense.add(expense);

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

		return userExpense;
	}

}
