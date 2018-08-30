package com.assignment.repositories;

import com.assignment.dbConnection.DbConnection;
import com.assignment.models.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class RegistrationRepository {



    public void registerUser(Registration registration) {
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.createConnection();
        dbConnection.registerUser(connection, registration);

    }

}
