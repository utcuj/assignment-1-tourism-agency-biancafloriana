package database;

import database.Connection.DatabaseConnection;

import java.sql.Date;
import java.sql.ResultSet;

public class UserInfoGateway {

    private DatabaseConnection databaseConnection = new DatabaseConnection();

    public void insert(String username, String s, String date) {

        try {

            databaseConnection.openConnectionToDatabase();

            String statement =
                    "INSERT INTO `agentinfo` (`username`, `info`,`date`) VALUES ('" +
                            username + "', '" + s + "', '" + Date.valueOf(date) + "')";

            databaseConnection.executeQuery(statement, "insert");

            System.out.println("Saved new info!\n");

            databaseConnection.closeConnectionToDatabase();

        } catch (Exception e) {
            System.out.println("Error occured while saving user info to the database.");
        }
    }

    public ResultSet findAll(String username,String[] dates) {
        try {
            databaseConnection.openConnectionToDatabase();

            //SELECT * FROM agentinfo WHERE username = 'bia' and (date between '2017-09-09' and '2019-09-09')
            String statement = "SELECT * FROM `agentinfo` WHERE `username` ='" + username +"' and ( `date` between '"+ Date.valueOf(dates[0]) +
                    "' and '"+ Date.valueOf(dates[1]) +"');";

            ResultSet r = databaseConnection.executeQuery(statement, "select");
            System.out.println("find info!\n");


            return r;
        } catch (Exception e) {
            System.out.println("Error occured while selection user info to the database.");
        }
        return null;
    }

    public void closeConnection() {
        databaseConnection.closeConnectionToDatabase();
    }
}
