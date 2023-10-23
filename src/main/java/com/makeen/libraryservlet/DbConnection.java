package com.makeen.libraryservlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DbConnection {
    private final Logger logger = Logger.getLogger(DbConnection.class.getName());

    private Connection connection;

    public DbConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            logger.info("DB load successfully!");
        } catch (ClassNotFoundException e) {
            logger.info("DB load failed!");
            e.printStackTrace();
        }
    }

    public void connect() {
        try {
            this.connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "github", "123");
            logger.info("DB connect successfully!");
        } catch (SQLException e) {
            logger.info("DB connect failed!");
            e.printStackTrace();
        }

    }


    public Connection getConnection() {
        return connection;
    }

    public Logger getLogger() {
        return logger;
    }

    public void closeConnection() {
        try {
            this.connection.close();
            logger.info("DB coles successfully!");
        } catch (SQLException e) {
            logger.info("DB close failed!");
            e.printStackTrace();
        }
    }
}
