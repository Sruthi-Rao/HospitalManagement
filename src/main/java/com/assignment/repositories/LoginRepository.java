package com.assignment.repositories;

import com.assignment.dbConnection.DbConnection;
import com.assignment.models.Login;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.Map;

@Repository
public class LoginRepository {

    public Map checkLogin(Login login) {
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.createConnection();
        Map hashMap = dbConnection.getUser(connection, login);
        return hashMap;

    }
}
