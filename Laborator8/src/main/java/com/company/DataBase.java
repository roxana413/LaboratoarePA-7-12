package com.company;

import com.company.ConnectionManager;

import java.sql.Connection;
import java.sql.*;

public class DataBase {


    private static Connection        connection        = null;
    private static ConnectionManager connectionManager = new ConnectionManager(); // manage a connection to the database.


    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null)
            connection = connectionManager.createConnection();
        return connection;
    }

    public static void closeConnection() throws SQLException {
        connection.close();

    }


    public static void rollback() throws SQLException, ClassNotFoundException {
        String delGenres = "DELETE FROM genress WHERE id >=1";
        String delMovies = "DELETE FROM moviess WHERE id >= 1";
        Statement statement = getConnection().createStatement();

        statement.executeQuery(delMovies);
        statement.executeQuery(delGenres);



    }

    public static void commit () throws SQLException {

        connection.commit();
    }

    public static void acommit () throws SQLException {
        connection.setAutoCommit(false);
    }


}
