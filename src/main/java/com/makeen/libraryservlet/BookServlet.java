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

@WebServlet(name = "BookServlet", value = "/BookServlet")
public class BookServlet extends HttpServlet {
    private final DbConnection dbConnection=new DbConnection();
    private HashMap <Integer,Book> bookHashMap=new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");

        Book book=new Book(name);

        try {
            dbConnection.connect();
            String readBook = "select * from Book where Book_Id = ?";
            PreparedStatement statement = dbConnection.getConnection().prepareStatement(readBook);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int bookId = resultSet.getInt(1);
                String queryBookName = resultSet.getString(2);
                System.out.println("Book id :" + bookId + "Book Name : " + queryBookName);
            }
            resultSet.close();
            statement.executeUpdate();
            dbConnection.closeConnection();
        } catch (SQLException e) {
            System.out.println("SQL Read Book Failed");
            throw new RuntimeException();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        Book book=new Book(name);
        bookHashMap.put(book.getBook_id(),book);

        try {
            dbConnection.connect();
            String sql = "insert into Book (book_name) values(?)";
            PreparedStatement prepareStatement=dbConnection.getConnection().prepareStatement(sql);
            prepareStatement.setString(1,name);
            prepareStatement.execute();
            dbConnection.getLogger().info("Successfuly Create book");
            dbConnection.closeConnection();
        } catch (SQLException e) {
            dbConnection.getLogger().info("Create book Error");
            dbConnection.closeConnection();
            throw new RuntimeException(e);
        }
        response.sendRedirect("");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // update
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        bookHashMap.put(id,new Book(name));


        try {
            dbConnection.connect();
            String updateQuery = "UPDATE book SET name = ? WHERE id = ?";
           PreparedStatement prepareStatement= dbConnection.getConnection().prepareStatement(updateQuery);
           prepareStatement.setString(1,name);
           prepareStatement.setInt(2,id);
            dbConnection.getLogger().info("Successfuly update book");
            dbConnection.closeConnection();
           prepareStatement.executeUpdate();
           //this is test


        } catch (SQLException e) {
            dbConnection.getLogger().info("Update book error");
            dbConnection.closeConnection();
            throw new RuntimeException(e);

        }
        response.sendRedirect("");

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // delete
        String id = request.getParameter("id");
        String name = request.getParameter("name");

        Book book=new Book(name);

        try {
            dbConnection.connect();
            String deleteBook = "delete from Book where Book_Id = ?";
            PreparedStatement statement = dbConnection.getConnection().prepareStatement(deleteBook);
            statement.setString(1, id);
            statement.executeUpdate();
            dbConnection.closeConnection();
        } catch (SQLException e) {
            System.out.println("SQL Delete Book Failed");
            throw new RuntimeException();
        }
    }
}