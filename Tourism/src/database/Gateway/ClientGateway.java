package database.Gateway;



import Exception.*;
import database.Connection.DatabaseConnection;

import java.sql.ResultSet;

public class ClientGateway {

    private DatabaseConnection databaseConnection = new DatabaseConnection();

    public void insert(String firstName, String lastName, int age, String cnp, String card, String adress) throws ClientGatewayException {

        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "INSERT INTO `client` (  `firstName`,`lastName`,`age`, `cnp`, `card`,`adress`) VALUES('"
                    + firstName + "', '" + lastName + "', '" + age + "','" + cnp + "', '" + card + "', '" + adress + "' )";

            databaseConnection.executeQuery(statement, "insert");

            System.out.println("Saved new client!\n");

            databaseConnection.closeConnectionToDatabase();

        } catch (Exception e) {
            throw new ClientGatewayException("Error occured while saving client to the database.", e);
        }
    }

    public void update(int idClient, String firstName, String lastName, int age, String cnp, String card, String adress) throws ClientGatewayException {

        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "UPDATE `client` SET `firstName`=' " + firstName + "', `lastName`='" + lastName + "', `age`= '"
                    + age + "', `cnp`='" + cnp + "', `card`='" + card + "',`adress`= '" + adress + "' WHERE `idClient`='" + idClient + "';";


            databaseConnection.executeQuery(statement, "update");

            System.out.println("Updated client with id: " + idClient + "\n");

            databaseConnection.closeConnectionToDatabase();

        } catch (Exception e) {
            throw new ClientGatewayException("Error occured while updating client from the database.", e);
        }
    }

    public void delete(int idClient) throws ClientGatewayException {

        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "DELETE FROM `client` WHERE `idClient`='" + idClient + "';";


            databaseConnection.executeQuery(statement, "update");

            System.out.println("Deleted client with id: " + idClient + "\n");

            databaseConnection.closeConnectionToDatabase();

        } catch (Exception e) {
            throw new ClientGatewayException("Error occured while deleting client from the database.", e);
        }
    }

    public ResultSet findAll() throws ClientGatewayException {
        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "SELECT * FROM `client` ORDER BY `lastName`;";


            ResultSet r = databaseConnection.executeQuery(statement, "select");

            System.out.println("Selected all clients. \n");


            return r;

        } catch (Exception e) {
            throw new ClientGatewayException("Error occured while selecting client from the database.", e);
        }

    }

    public ResultSet findbyId(int idClient) throws ClientGatewayException {
        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "SELECT * FROM `client` WHERE `idClient`='" + idClient + "';";


            ResultSet r = databaseConnection.executeQuery(statement, "select");

            System.out.println("Selected the client with id: " + idClient + ".\n");


            return r;

        } catch (Exception e) {
            throw new ClientGatewayException("Error occured while selecting client by id from the database.", e);
        }

    }

    public ResultSet getLastId() throws ClientGatewayException {
        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "SELECT MAX(idClient) from client;";

            ResultSet r = databaseConnection.executeQuery(statement, "select");

            System.out.println("Selected last id\n");

            return r;

        } catch (Exception e) {
            throw new ClientGatewayException("Error occured while selecting client by id from the database.", e);
        }

    }

    public void closeConnection() {
        databaseConnection.closeConnectionToDatabase();
    }
}
