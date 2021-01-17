package com.geekbrains.server;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleAuthService implements AuthService {
    private class UserData {
        private String login;
        private String password;
        private String nickname;

        public UserData(String login, String password, String nickname) {
            this.login = login;
            this.password = password;
            this.nickname = nickname;
        }
    }

    private Repository repository;

    public SimpleAuthService() throws SQLException {
        repository = new Repository();
    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        try {
            return repository.getNicknameByLoginAndPassword(login, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
