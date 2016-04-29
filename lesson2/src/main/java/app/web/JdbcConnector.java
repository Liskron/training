package app.web;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JdbcConnector {

    public static final String SQL_SELECT = "select * from accounts";
    public static final String SQL_SELECT_BY_ID = "select * from accounts where id = ?";

    public static final String DATABASE_URL = "jdbc:mysql://localhost:3307/database?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "password";

    public Account findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int internalId = resultSet.getInt("id");
                String username = resultSet.getString("username");
                return new Account(internalId, username);
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Account> findAll() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_SELECT);
            List<Account> accounts = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                accounts.add(new Account(id, username));
            }
            return accounts;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
