package database.Gateway;



import java.sql.ResultSet;

import Exception.*;
import database.Connection.DatabaseConnection;

public class PersonGateway {
    private DatabaseConnection databaseConnection = new DatabaseConnection();

    public void insert(String firstName, String lastName, int age, String cnp) throws PersonGatewayException {

        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "INSERT INTO `person` (  `firstName`,`lastName`,`age`, `cnp` ) VALUES('"
                    + firstName + "', '" + lastName + "', '" + age + "','" + cnp + "' )";

            databaseConnection.executeQuery(statement, "insert");

            System.out.println("Saved new person!\n");

            databaseConnection.closeConnectionToDatabase();

        } catch (Exception e) {
            throw new PersonGatewayException("Error occured while saving person to the database.", e);
        }
    }

    public void update(int idPerson, String firstName, String lastName, int age, String cnp) throws PersonGatewayException {

        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "UPDATE `person` SET `firstName`=' " + firstName + "', `lastName`='" + lastName + "', `age`= '"
                    + age + "', `cnp`='" + cnp + "' WHERE `idPerson`='" + idPerson + "';";


            databaseConnection.executeQuery(statement, "update");

            System.out.println("Updated person with id: " + idPerson + "\n");

            databaseConnection.closeConnectionToDatabase();

        } catch (Exception e) {
            throw new PersonGatewayException("Error occured while updating person from the database.", e);
        }
    }

    public void delete(int idPerson) throws PersonGatewayException {

        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "DELETE FROM `person` WHERE `idPerson`='" + idPerson + "';";


            databaseConnection.executeQuery(statement, "update");

            System.out.println("Deleted person with id: " + idPerson + "\n");

            databaseConnection.closeConnectionToDatabase();

        } catch (Exception e) {
            throw new PersonGatewayException("Error occured while deleting person from the database.", e);
        }
    }

    public ResultSet findAll() throws PersonGatewayException {
        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "SELECT * FROM `person` ORDER BY `lastName`;";


            ResultSet r = databaseConnection.executeQuery(statement, "select");

            System.out.println("Selected all persons. \n");


            return r;

        } catch (Exception e) {
            throw new PersonGatewayException("Error occured while selecting person from the database.", e);
        }
    }

    public void closeConnection() {
        databaseConnection.closeConnectionToDatabase();
    }

    public ResultSet findById(int idPerson) throws PersonGatewayException {
        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "SELECT * FROM `person` WHERE `idPerson`='" + idPerson + "';";

            ResultSet r = databaseConnection.executeQuery(statement, "select");

            System.out.println("Selected the person with id: " + idPerson + ".\n");


            return r;

        } catch (Exception e) {
            throw new PersonGatewayException("Error occured while selecting person by id from the database.", e);
        }
    }
}
