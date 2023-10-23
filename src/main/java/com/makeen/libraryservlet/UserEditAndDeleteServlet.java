package com.makeen.libraryservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserEditAndDeleteServlet extends HttpServlet {

    static DbConnection dbConnection = new DbConnection();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // update
        int userID = Integer.parseInt(request.getParameter("userID"));
        try {
            dbConnection.connect();
            String selectQuery = "SELECT * FROM users WHERE userid=? and userisdeleted = ?";
            try (PreparedStatement selectStatement = dbConnection.getConnection().prepareStatement(selectQuery)) {
                selectStatement.setInt(1, userID);
                selectStatement.setBoolean(2, false);
                try (ResultSet resultSet = selectStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String newUserName = request.getParameter("userName");
                        int newUserAge = Integer.parseInt(request.getParameter("userAge"));
                        String updateQuery = "UPDATE users SET username = ?, userage = ? WHERE userid = ?";
                        try (PreparedStatement updateStatement = dbConnection.getConnection().prepareStatement(updateQuery)) {
                            updateStatement.setString(1, newUserName);
                            updateStatement.setInt(2, newUserAge);
                            updateStatement.setInt(3, userID);
                            updateStatement.executeUpdate();
                            System.out.println(" row(s) updated.");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    } else {
                        System.out.println("User not found for id: " + userID);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // delete
        try {
            dbConnection.connect();
            int userID = Integer.parseInt(request.getParameter("userID"));
            String selectQuery = "SELECT * FROM users WHERE userid=? and userisdeleted = ?";
            try (PreparedStatement selectStatement = dbConnection.getConnection().prepareStatement(selectQuery)) {
                selectStatement.setInt(1, userID);
                selectStatement.setBoolean(2, false);
                try (ResultSet resultSet = selectStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String deleteQuery = "UPDATE users SET userisdeleted = ? where userid = ?";
                        PreparedStatement statement = dbConnection.getConnection().prepareStatement(deleteQuery);
                        statement.setBoolean(1, true);
                        statement.setInt(2, userID);
                        statement.executeUpdate();
                        dbConnection.getLogger().info("User Successfully Deleted");
                        dbConnection.closeConnection();
                    } else {
                        System.out.println("User not found for id: " + userID);
                    }

                }
            }
        } catch (SQLException e) {
            dbConnection.getLogger().info("SQL Delete User Failed");
            e.printStackTrace();
        }
    }
}
