package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Revenue;
import br.com.fiap.bean.User;
import br.com.fiap.dao.RevenueDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.singleton.ConnectionManager;

public class OracleRevenueDAO implements RevenueDAO {
	
	private Connection connection;

	public void insertRevenue(Revenue revenue, User user) throws DBException {
		
		PreparedStatement pstm = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();

			String sqlInsert = "INSERT INTO TB_REVENUE(ID_REVENUE, TB_USER_ID_USER, VL_REVENUE)" + "VALUES (?, ?, ?)";

			pstm = connection.prepareStatement(sqlInsert);
			pstm.setInt(1, revenue.getIdRevenue());
			pstm.setInt(2, user.getIdUser());
			pstm.setDouble(3, revenue.getVlRevenue());		
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
	
	public void updateRevenue(Revenue revenue) throws DBException {
		
		PreparedStatement pstm = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sqlUpdate = "UPDATE TB_REVENUE SET VL_REVENUE = ? WHERE ID_REVENUE = ?";

			pstm = connection.prepareStatement(sqlUpdate);
			pstm.setDouble(1, revenue.getVlRevenue());
			pstm.setInt(2, revenue.getIdRevenue());
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
	
	public void removeRevenue(int idRevenue) throws DBException {
		
		PreparedStatement pstm = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sqlDelete = "DELETE FROM TB_REVENUE WHERE ID_REVENUE = ?";

			pstm = connection.prepareStatement(sqlDelete);
			pstm.setInt(1, idRevenue);
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
	
	public Revenue getRevenueById(int idRevenue) throws DBException {
		
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet result = null;
		Revenue revenue = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();

			pstm = connection.prepareStatement("SELECT * FROM TB_REVENUE WHERE ID_REVENUE = ?");
			pstm.setInt(1, idRevenue);
			result = pstm.executeQuery();

			if (result.next()) {
				Double vlRevenue = result.getDouble("vl_revenue");				

				revenue = new Revenue(idRevenue, vlRevenue);

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

		return revenue;
	}
	
	public List<Revenue> getAllRevenues() {
		
		List<Revenue> userRevenue = new ArrayList<Revenue>();
		PreparedStatement pstm = null;
		ResultSet result = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();

			String sqlGetAllRevenue = "SELECT * FROM TB_REVENUE";
			pstm = (PreparedStatement) connection.prepareStatement(sqlGetAllRevenue);
			result = pstm.executeQuery();

			while (result.next()) {
				int idRevenue = result.getInt("id_revenue");				
				Double vlRevenue = result.getDouble("vl_revenue");
				Revenue revenue = new Revenue(idRevenue, vlRevenue);
				userRevenue.add(revenue);

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

		return userRevenue;
	}

}
