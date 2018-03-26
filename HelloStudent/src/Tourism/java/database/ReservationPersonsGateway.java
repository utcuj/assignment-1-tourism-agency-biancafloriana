package database;

import com.utcn.student.db.DatabaseConnection;
import Exception.*;

import java.sql.Date;
import java.sql.ResultSet;

public class ReservationPersonsGateway {

    private DatabaseConnection databaseConnection = new DatabaseConnection();

    public void insert(int idPerson, int idReservation) throws ReservationPersonsGatewayException {

        try {

            databaseConnection.openConnectionToDatabase();

            String statement =
                    "INSERT INTO `reservationPersons` (`idPerson`, `idReservation`) VALUES ('" +
                            idPerson + "', '" + idReservation + "')";

            databaseConnection.executeQuery(statement, "insert");

            System.out.println("Saved new reservationPersons!\n");

            databaseConnection.closeConnectionToDatabase();

        } catch (Exception e) {
            throw new ReservationPersonsGatewayException("Error occured while saving reservationPersons to the database.", e);
        }
    }

    public void update(int idReservationPersons, int idPerson, int idReservation) throws ReservationPersonsGatewayException {

        try {

            databaseConnection.openConnectionToDatabase();

            String statement =
                    "UPDATE `reservationPersons` SET `idPerson`='" + idPerson + "', `idReservation`='" + idReservation
                            + "' WHERE `idReservationPerson`='" + idReservationPersons + "';";


            databaseConnection.executeQuery(statement, "update");

            System.out.println("Updated reservationPersons with id: " + idReservationPersons + "\n");

            databaseConnection.closeConnectionToDatabase();

        } catch (Exception e) {
            throw new ReservationPersonsGatewayException("Error occured while updating reservationPersons from the database.", e);
        }
    }

    public void delete(int idReservationPersons) throws ReservationPersonsGatewayException {

        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "DELETE FROM `reservationPersons` WHERE `idReservationPerson`='" + idReservationPersons + "';";


            databaseConnection.executeQuery(statement, "update");

            System.out.println("Deleted reservationPersons with id: " + idReservationPersons + "\n");

            databaseConnection.closeConnectionToDatabase();

        } catch (Exception e) {
            throw new ReservationPersonsGatewayException("Error occured while deleting reservationPersons from the database.", e);
        }
    }

    public ResultSet findAll() throws ReservationPersonsGatewayException {
        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "SELECT * FROM `reservationPersons`;";


            ResultSet r = databaseConnection.executeQuery(statement, "select");

            System.out.println("Selected all reservationPersons. \n");


            return r;

        } catch (Exception e) {
            throw new ReservationPersonsGatewayException("Error occured while selecting reservationPersons from the database.", e);
        }
    }

    public void closeConnection() {
        databaseConnection.closeConnectionToDatabase();
    }

    public ResultSet findById(int idReservationPersons) throws ReservationPersonsGatewayException {
        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "SELECT * FROM `reservationPersons` WHERE `idReservationPerson` ='" + idReservationPersons + "';";

            ResultSet r = databaseConnection.executeQuery(statement, "select");

            System.out.println("Selected the reservationPersons with id: " + idReservationPersons + ".\n");


            return r;

        } catch (Exception e) {
            throw new ReservationPersonsGatewayException("Error occured while selecting reservationPersons by id from the database.", e);
        }
    }
}
