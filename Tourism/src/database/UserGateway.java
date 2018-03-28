package database;

import java.sql.ResultSet;

public class UserGateway {
    private DatabaseConnection databaseConnection = new DatabaseConnection();
    public ResultSet find(String s) {
        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "SELECT `password` FROM `user` WHERE `username` ='" + s + "';";

            ResultSet r = databaseConnection.executeQuery(statement, "select");

            System.out.println("Selected user with id: " + s + ".\n");

            return r;

        } catch (Exception e) {
           e.printStackTrace();
        } return null;
    }
}

