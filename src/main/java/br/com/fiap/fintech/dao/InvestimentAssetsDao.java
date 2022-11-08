package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.InvestimentAssetsModel;
import br.com.fiap.fintech.bean.UserModel;
import br.com.fiap.fintech.singleton.ConnectionFactory;

public class InvestimentAssetsDao {

    public void insertInvestimentAssets(InvestimentAssetsModel investimentAssets, UserModel user) {

        String sqlInsert = "INSERT INTO T_SIP_INVESTIMENT_ASSETS(ID_INVESTIMENT_ASSETS, T_SIP_USER_INFO_ID_USER, VL_INVESTIMENT_ASSETS, TP_INVESTIMENT_ASSETS, DT_INVESTIMENT_ASSETS)"
                + "VALUES (?, ?, ?, ?, ?)";

        Connection connection;
        PreparedStatement pstm = null;

        try {
            connection = ConnectionFactory.createConnectionToSQL();

            pstm = connection.prepareStatement(sqlInsert);
            pstm.setInt(1, investimentAssets.getIdInvestimentAssets());
            pstm.setInt(2, user.getIdUser());
            pstm.setDouble(3, investimentAssets.getVlInvestimentAssets());
            pstm.setString(4, investimentAssets.getTpInvestimentAssets());
            pstm.setString(5, investimentAssets.getDtInvestimentAssets());

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

    public List<InvestimentAssetsModel> getAllInvestiments() {

        String sqlGetAllInvestimentsAssets = "SELECT * FROM T_SIP_INVESTIMENT_ASSETS";

        List<InvestimentAssetsModel> assetsList = new ArrayList<InvestimentAssetsModel>();

        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet result = null;

        try {
            connection = ConnectionFactory.createConnectionToSQL();

            pstm = (PreparedStatement) connection.prepareStatement(sqlGetAllInvestimentsAssets);

            result = pstm.executeQuery();

            InvestimentAssetsModel investimentAssetsModel;
            while (result.next()) {
                investimentAssetsModel = new InvestimentAssetsModel();
                investimentAssetsModel.setIdInvestimentAssets(result.getInt("id_investiment_assets"));
                investimentAssetsModel.setVlInvestimentAssets(result.getDouble("vl_investiment_assets"));
                investimentAssetsModel.setTpInvestimentAssets(result.getString("tp_investiment_assets"));
                investimentAssetsModel.setDtInvestimentAssets(result.getString("dt_investiment_assets"));

                assetsList.add(investimentAssetsModel);

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
        return assetsList;
    }
}
