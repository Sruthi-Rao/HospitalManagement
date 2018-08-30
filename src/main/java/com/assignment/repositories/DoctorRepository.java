package com.assignment.repositories;

import com.assignment.dbConnection.DbConnection;
import com.assignment.models.Doctor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class DoctorRepository {

    public void getDoctorsList(Doctor doctor) {

        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.createConnection();


    }
}
