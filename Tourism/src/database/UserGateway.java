package database;

import database.Connection.DatabaseConnection;

import java.sql.ResultSet;

public class UserGateway {
    private DatabaseConnection databaseConnection = new DatabaseConnection();
    public ResultSet find(String s) {
        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "SELECT * FROM `userinfo` WHERE `username` ='" + s + "';";

            ResultSet r = databaseConnection.executeQuery(statement, "select");

            System.out.println("Selected user with id: " + s + ".\n");

            return r;

        } catch (Exception e) {
           System.out.println("Error occured while seleting user from the database.");
        } return null;
    }

    public void insert(String username, String password)  {

        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "INSERT INTO `userinfo` (  `username`,`password`) VALUES('"
                    + username + "', '" + password + "' )";

            databaseConnection.executeQuery(statement, "insert");

            System.out.println("Saved new user!\n");

            databaseConnection.closeConnectionToDatabase();

        } catch (Exception e) {
            System.out.println("Error occured while saving user to the database.");
        }
    }

    public void update(String username, String password)  {

        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "UPDATE `userinfo` SET  `password`='" + password +
                    "' WHERE `username` ='" + username +"';";

            databaseConnection.executeQuery(statement, "insert");

            System.out.println("Updated user!\n");

            databaseConnection.closeConnectionToDatabase();

        } catch (Exception e) {
            System.out.println("Error occured while updating user to the database.");
        }
    }

    public void delete(String username) {

        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "DELETE FROM `userinfo` WHERE `username`='" + username + "';";


            databaseConnection.executeQuery(statement, "delete");

            System.out.println("Deleted username: " + username + "\n");

            databaseConnection.closeConnectionToDatabase();

        } catch (Exception e) {
            System.out.println("Error occured while deleting user to the database.");
        }
    }
    public void closeConnection() {
        databaseConnection.closeConnectionToDatabase();
    }

    public ResultSet findAll() {
        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "SELECT * FROM `userinfo` ORDER BY `username`;";


            ResultSet r = databaseConnection.executeQuery(statement, "select");

            System.out.println("Selected all user. \n");


            return r;

        } catch (Exception e) {
            System.out.println("Error occured while selecting user to the database.");
        }
        return null;
    }
}

