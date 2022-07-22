package com.example.demo2;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class MyJDBC {
    public static void main(String[] args) {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "example");
        Statement statement = connection.createStatement();
        ResultSet resultSet statement.executeQuery()

    }
}
