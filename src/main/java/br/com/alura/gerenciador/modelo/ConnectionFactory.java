package br.com.alura.gerenciador.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

    private static Connection connection;

    static{
        new ConnectionFactory();
    }

    public  ConnectionFactory(){
        try {
        Properties properties = new Properties();
        properties.load(getClass().getResourceAsStream("/connection.properties"));
        Class.forName("org.mariadb.jdbc.Driver");
        connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
                properties.getProperty("password"));
 
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static Connection recuperarConexao(){
        return connection;
    }
}