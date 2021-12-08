package br.com.alura.gerenciador.modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

    private static DataSource dataSource;

    static {
        new ConnectionFactory();
    }

    private ConnectionFactory() {
        try {
            Properties properties = new Properties();
            properties.load(getClass().getResourceAsStream("/connection.properties"));
            ComboPooledDataSource pool = new ComboPooledDataSource();
            Class.forName("org.mariadb.jdbc.Driver");
            pool.setJdbcUrl(properties.getProperty("url"));
            pool.setUser(properties.getProperty("user"));
            pool.setPassword(properties.getProperty("password"));

            ConnectionFactory.dataSource = pool;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static Connection recuperarConexao() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}