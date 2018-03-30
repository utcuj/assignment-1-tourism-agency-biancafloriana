package database.Gateway;



import java.sql.Date;
import java.sql.ResultSet;

import Exception.*;
import database.Connection.DatabaseConnection;

public class PaymentGateway {
    private DatabaseConnection databaseConnection = new DatabaseConnection();

    public void insert(int idClient,int idReservation, int payment, Date date) throws PaymentGatewayException {

        try {

            databaseConnection.openConnectionToDatabase();

            String statement =
                    "INSERT INTO `payments` (`idClient`, `idReservation`, `payment`, `date`) VALUES ('" +
                            idClient + "', '" + idReservation + "', '"+ payment + "', '" + date + "')";

            databaseConnection.executeQuery(statement, "insert");

            System.out.println("Saved new payment!\n");

            databaseConnection.closeConnectionToDatabase();

        } catch (Exception e) {
            throw new PaymentGatewayException("Error occured while saving payment to the database.", e);
        }
    }

    public void update(int idPayment, int idClient, int idReservation, int payment, Date date) throws PaymentGatewayException {

        try {

            databaseConnection.openConnectionToDatabase();

            String statement =
                    "UPDATE `payments` SET `idClient`='" + idClient + "', `idReservation`='" + idReservation + "', `payment`='" + payment +
                            "', `date`='" + date + "' WHERE `idPayment`='" + idPayment + "';";


            databaseConnection.executeQuery(statement, "update");

            System.out.println("Updated payment with id: " + idPayment + "\n");

            databaseConnection.closeConnectionToDatabase();

        } catch (Exception e) {
            throw new PaymentGatewayException("Error occured while updating payment from the database.", e);
        }
    }

    public void delete(int idReservation) throws PaymentGatewayException {

        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "DELETE FROM `payments` WHERE `idReservation`='" + idReservation + "';";


            databaseConnection.executeQuery(statement, "update");

            System.out.println("Deleted payment with id: " + idReservation + "\n");

            databaseConnection.closeConnectionToDatabase();

        } catch (Exception e) {
            throw new PaymentGatewayException("Error occured while deleting payment from the database.", e);
        }
    }

    public ResultSet findAll(int reservationId) throws PaymentGatewayException {
        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "SELECT * FROM `payments`WHERE `idReservation`='"+reservationId+"';";


            ResultSet r = databaseConnection.executeQuery(statement, "select");

            System.out.println("Selected all payments. \n");


            return r;

        } catch (Exception e) {
            throw new PaymentGatewayException("Error occured while selecting payment from the database.", e);
        }
    }

    public void closeConnection() {
        databaseConnection.closeConnectionToDatabase();
    }

    public ResultSet findById(int idPayment) throws PaymentGatewayException {
        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "SELECT * FROM `payments` WHERE `idPayment` ='" + idPayment + "';";

            ResultSet r = databaseConnection.executeQuery(statement, "select");

            System.out.println("Selected payment with id: " + idPayment + ".\n");


            return r;

        } catch (Exception e) {
            throw new PaymentGatewayException("Error occured while selecting payment by id from the database.", e);
        }
    }

    public ResultSet getLastId() throws ClientGatewayException {
        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "SELECT MAX(idpayment) from payments;";

            ResultSet r = databaseConnection.executeQuery(statement, "select");

            System.out.println("Selected last id\n");

            return r;

        } catch (Exception e) {
            throw new ClientGatewayException("Error occured while selecting payment last id", e);
        }

    }

    public ResultSet getPayments(int idReservation) throws ClientGatewayException {
        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "SELECT `payment` FROM `payments` WHERE `idReservation` ='" + idReservation +"';";

            ResultSet r = databaseConnection.executeQuery(statement, "select");

            System.out.println("Selected last id\n");

            return r;

        } catch (Exception e) {
            throw new ClientGatewayException("Error occured while selecting payments for a client", e);
        }


    }
}
