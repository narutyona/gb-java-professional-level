package com.geekbrains.server;

import java.sql.*;

public class Repository {
    private Connection connection;

    public Repository() throws SQLException {
        connection = DatabaseConnection.getInstance().getConnection();
    }

    public String getNicknameByLoginAndPassword(String login, String password) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT nickname\n" +
                "  FROM user\n" +
                "  WHERE login = ? AND password = ?")){

            statement.setString(1, login);
            statement.setString(2, password);
            try(final ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    return resultSet.getString("nickname");
                }
                return null;
            }
        }
    }
}
