package database;



import java.sql.Date;
import java.sql.ResultSet;


import Exception.*;

public class ReservationGateway {

    private DatabaseConnection databaseConnection = new DatabaseConnection();

    public void insert(int idClient, String destination, String hotel, int personNumber, int price, Date date, int partialPayment, int paid) throws ReservationGatewayException {

        try {

            databaseConnection.openConnectionToDatabase();

            String statement =
                    "INSERT INTO `reservation` (`destination`, `hotel`, `personNumber`, `price`, `date`, `partialPayment`, `idClient`, `paid`) VALUES ('" +
                            destination + "', '" + hotel + "', '" + personNumber + "', '" + price + "', '" + date + "', '" + partialPayment + "', '" + idClient + "', '" + paid + "')";

            databaseConnection.executeQuery(statement, "insert");

            System.out.println("Saved new reservation!\n");

            databaseConnection.closeConnectionToDatabase();

        } catch (Exception e) {
            throw new ReservationGatewayException("Error occured while saving reservation to the database.", e);
        }
    }

    public void update(int idReservation, int idClient, String destination, String hotel, int personNumber, int price, Date date, int partialPayment, int paid) throws ReservationGatewayException {

        try {

            databaseConnection.openConnectionToDatabase();

            String statement =
                    "UPDATE `tourism`.`reservation` SET `destination`='" + destination + "', `hotel`='" + hotel + "', `personNumber`='" + personNumber +
                            "', `price`='" + price + "', `date`='" + date + "', `partialPayment`='" + partialPayment + "', `idClient`='" + idClient
                            + "', `paid`='" + paid + "' WHERE `idReservation`='" + idReservation + "';";


            databaseConnection.executeQuery(statement, "update");

            System.out.println("Updated reservation with id: " + idReservation + "\n");

            databaseConnection.closeConnectionToDatabase();

        } catch (Exception e) {
            throw new ReservationGatewayException("Error occured while updating reservation from the database.", e);
        }
    }

    public void delete(int idReservation) throws ReservationGatewayException {

        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "DELETE FROM `reservation` WHERE `idReservation`='" + idReservation + "';";


            databaseConnection.executeQuery(statement, "update");

            System.out.println("Deleted reservation with id: " + idReservation + "\n");

            databaseConnection.closeConnectionToDatabase();

        } catch (Exception e) {
            throw new ReservationGatewayException("Error occured while deleting reservation from the database.", e);
        }
    }

    public ResultSet findAll() throws ReservationGatewayException {
        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "SELECT * FROM `reservation`;";


            ResultSet r = databaseConnection.executeQuery(statement, "select");

            System.out.println("Selected all reservations. \n");


            return r;

        } catch (Exception e) {
            throw new ReservationGatewayException("Error occured while selecting reservation from the database.", e);
        }
    }

    public void closeConnection() {
        databaseConnection.closeConnectionToDatabase();
    }

    public ResultSet findById(int idReservation) throws ReservationGatewayException {
        try {

            databaseConnection.openConnectionToDatabase();

            String statement = "SELECT * FROM `reservation` WHERE `idReservation` ='" + idReservation + "';";

            ResultSet r = databaseConnection.executeQuery(statement, "select");

            System.out.println("Selected the reservation with id: " + idReservation + ".\n");


            return r;

        } catch (Exception e) {
            throw new ReservationGatewayException("Error occured while selecting reservation by id from the database.", e);
        }
    }
}
