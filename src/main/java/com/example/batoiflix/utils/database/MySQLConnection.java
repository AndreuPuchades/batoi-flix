package com.example.batoiflix.utils.database;

import com.example.batoiflix.exceptions.DatabaseConnectionError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class MySQLConnection {
    private Connection connection;

    private String connectionURI;

    private String username;

    private String password;

    public MySQLConnection(String connectionURI, String username, String password) {
        this.connectionURI = connectionURI;
        this.username = username;
        this.password = password;
    }

    @Autowired
    public MySQLConnection(Environment environment){
        this.connectionURI = environment.getProperty("spring.datasource.url");
        this.username = environment.getProperty("spring.datasource.username");
        this.password = environment.getProperty("spring.datasource.password");
    }

    public Connection getConnection() {
        try {
            if (connection != null && connection.isValid(2)) {
                return connection;
            }
            String dbURL = connectionURI;
            this.connection = DriverManager.getConnection(dbURL, username, password);
            return connection;
        } catch (SQLException exception) {
            throw new DatabaseConnectionError(exception.getMessage());
        }
    }

}

