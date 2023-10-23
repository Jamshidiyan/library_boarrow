package com.makeen.libraryservlet;

import com.makeen.model.Book.Book;
import com.makeen.model.User.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

//@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    static DbConnection dbConnection = new DbConnection();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // read

        int userIDToFind = Integer.parseInt(request.getParameter("userID"));
        try {
            dbConnection.connect();
            String readUser = "select * from GITHUB.USERS where User_id = ? and userisdeleted = ?";
            PreparedStatement statement = dbConnection.getConnection().prepareStatement(readUser);
            statement.setInt(1, userIDToFind);
            statement.setBoolean(2, false);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int userID = resultSet.getInt(1);
                String userName = resultSet.getString(2);
                int userAge = resultSet.getInt(3);
                System.out.println("User id :" + userID + "User Name : " + userName + "User age :" + userAge);
                dbConnection.getLogger().info("User Successfully Read");
            }
            resultSet.close();
            statement.executeUpdate();
            dbConnection.closeConnection();
        } catch (SQLException e) {
            dbConnection.getLogger().info("SQL Read User Failed");
            throw new RuntimeException();
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        // create
        int age;
        String name = request.getParameter("userName");
        try {
            age = Integer.parseInt(request.getParameter("userAge"));
        } catch (Exception e) {
            age = 0;
        }
        User user = new User(name, age);


        dbConnection.connect();
        String insertQuery = "INSERT INTO users (userid, username, userage, userisdeleted) VALUES (userid.NEXTVAL, ?, ?, ?)";
        try (PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(insertQuery)) {
            preparedStatement.setString(1, user.getUser_name());
            preparedStatement.setInt(2, age);
            preparedStatement.setBoolean(3, user.isDelete());


            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("User.jsp");
        dbConnection.closeConnection();
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        // delete
        try {
            dbConnection.connect();
            int userID = Integer.parseInt(request.getParameter("id"));
            String selectQuery = "SELECT * FROM users WHERE userid=? and userisdeleted = ?";
            try (PreparedStatement selectStatement = dbConnection.getConnection().prepareStatement(selectQuery)) {
                selectStatement.setInt(1, userID);
                selectStatement.setBoolean(2, false);
                try (ResultSet resultSet = selectStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String deleteQuery = "update from users set userisdeleted = ? where User_Id = ?";
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
            throw new RuntimeException();
        }
    }
}