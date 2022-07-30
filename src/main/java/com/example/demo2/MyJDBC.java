package com.example.demo2;
import java.sql.*;


public class MyJDBC {
    private String databaseUrl = "jdbc:mysql://localhost:3306/jdbc";
    private String databaserUsername = "root";
    private String databasePassword = "example";
    private String dbDriver = "com.mysql.cj.jdbc.Driver";

    public void loadDriver(String dbDriver) {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaserUsername, databasePassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public String insert(videoGame videoGame) {
        loadDriver(dbDriver);
        Connection connection = this.getConnection();
        String sqlAdd = "insert into games values(?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlAdd);
            preparedStatement.setString(1, null);
            preparedStatement.setString(2, videoGame.getName());
            preparedStatement.setString(3, videoGame.getPublisher());
            preparedStatement.setString(4, videoGame.getPlatform());

            preparedStatement.setString(5, videoGame.getBeaten());
            preparedStatement.setString(6, videoGame.getDateBought());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return "data not entered";
        }
        return "data successfully entered";
    }
}