package com.example.demo2;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;


public class CrudOperations {
    private final String databaseUrl;
    private final String databaseUsername;
    private final String databasePassword;
    private final String dbDriver;
    private Connection connection;

    public CrudOperations(String databaseUrl, String databaseUsername, String databasePassword, String dbDriver) {

        this.databaseUrl = databaseUrl;
        this.databaseUsername = databaseUsername;
        this.databasePassword = databasePassword;
        this.dbDriver = dbDriver;

    }
    public void loadDriver(String dbDriver) {
        try {

            Class.forName(dbDriver);

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }
    }

    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public Connection getConnection()  {

        Connection connection = null;
        try {

            connection = java.sql.DriverManager.getConnection(this.databaseUrl, this.databaseUsername, this.databasePassword);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return connection;
    }

    public boolean insert(videoGame videoGame) throws SQLException {

        loadDriver(dbDriver);
        Connection connection = this.getConnection();
        String sqlAdd = "insert into games values(?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sqlAdd);
        preparedStatement.setString(1, null);
        preparedStatement.setString(2, videoGame.getName());
        preparedStatement.setString(3, videoGame.getPlatform());
        preparedStatement.setString(4, videoGame.getPublisher());
        preparedStatement.setString(5, videoGame.getBeaten());
        preparedStatement.setString(6, videoGame.getDateBought());

        boolean rowsAffected = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        this.disconnect();

        return rowsAffected;

    }

    public boolean updateGame(videoGame videoGame) throws SQLException {

        loadDriver(dbDriver);
        Connection connection = this.getConnection();
        String sqlUpdate = "update games set name = ?, platform = ?, publisher = ?, beaten = ?, dateBought = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);

        preparedStatement.setString(1, videoGame.getName());
        preparedStatement.setString(2, videoGame.getPlatform());
        preparedStatement.setString(3, videoGame.getPublisher());
        preparedStatement.setString(4, videoGame.getBeaten());
        preparedStatement.setString(5, videoGame.getDateBought());
        preparedStatement.setInt(6, videoGame.getId());

        boolean rowsAffected = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        this.disconnect();

        return rowsAffected;

    }

    public boolean deleteGame(int videoGameId) throws SQLException {

        loadDriver(dbDriver);
        Connection connection = this.getConnection();

        String sqlDelete = "delete from games where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
        preparedStatement.setInt(1, videoGameId);

        boolean rowsAffected = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        this.disconnect();

        return rowsAffected;

    }

    public List<videoGame> listOfGames() throws SQLException {
        List<videoGame> gameList = new ArrayList<>();

        loadDriver(dbDriver);
        Connection connection = this.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM games");

        while (resultSet.next()) {

            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String platform = resultSet.getString(3);
            String publisher = resultSet.getString(4);
            String beaten = resultSet.getString(5);
            String dateBought = resultSet.getString(6);
            videoGame videoGame = new videoGame(id, name, platform, publisher, beaten, dateBought);
            gameList.add(videoGame);

        }

        resultSet.close();
        statement.close();
        this.disconnect();

        return gameList;

    }

}