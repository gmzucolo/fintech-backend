package br.com.fiap.fintech.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static ConnectionFactory connectionFactory;
    private static final String USERNAME = "RM93185";
    private static final String PASSWORD = "130588";
    private static final String DATABASE_URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";

    public static ConnectionFactory getInstance() {
    	if (connectionFactory == null) {
    		connectionFactory = new ConnectionFactory();
    	}
    	return connectionFactory;
    }
    
    public static Connection createConnectionToSQL() throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection connection = DriverManager.getConnection(
                DATABASE_URL,
                USERNAME,
                PASSWORD);

        return connection;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = createConnectionToSQL();

        if (connection!=null) {
            System.out.println("Conexão realizada com sucesso!");
            connection.close();
        }

    }
}
