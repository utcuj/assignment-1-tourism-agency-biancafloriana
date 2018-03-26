package database;

import com.utcn.student.db.DatabaseConnection;

import java.sql.Date;
import java.sql.ResultSet;

import Exception.*;

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

    public void delete(int idPayment) throws PaymentGatewayException {

        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "DELETE FROM `payments` WHERE `idPayment`='" + idPayment + "';";


            databaseConnection.executeQuery(statement, "update");

            System.out.println("Deleted payment with id: " + idPayment + "\n");

            databaseConnection.closeConnectionToDatabase();

        } catch (Exception e) {
            throw new PaymentGatewayException("Error occured while deleting payment from the database.", e);
        }
    }

    public ResultSet findAll() throws PaymentGatewayException {
        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "SELECT * FROM `payments`;";


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
}
