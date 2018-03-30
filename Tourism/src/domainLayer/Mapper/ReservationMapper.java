package domainLayer.Mapper;

import database.Gateway.ReservationGateway;
import domainLayer.Model.Reservation;
import Exception.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationMapper {
    private ReservationGateway reservationGateway;

    public ReservationMapper() {
        this.reservationGateway = new ReservationGateway();
    }

    public void insert(Object[] reservation, int reservationId) {
        try {
            reservationGateway.insert(reservationId, (String) reservation[1], (String) reservation[2], Integer.valueOf((String) reservation[3]),
                    Integer.valueOf((String) reservation[3]), Date.valueOf((String) reservation[5]), (int) reservation[6], (int) reservation[7]);

        } catch (ReservationGatewayException e) {
           // e.printStackTrace();
            System.out.println("Error while inserting reservation!");
        }
    }

    public void update(Object[] reservation, int reservationId) {
        try {
            reservationGateway.update((int) reservation[0],
                    reservationId, (String) reservation[1],
                    (String) reservation[2],
                    Integer.valueOf((String) reservation[3]),
                    Integer.valueOf((String) reservation[3]),
                    Date.valueOf((String) reservation[5]),
                    (int) reservation[6], (int) reservation[7]);
        } catch (ReservationGatewayException e) {
           // e.printStackTrace();
            System.out.println("Error while updating reservation!");
        }
    }

    public void delete(int reservationId) {
        try {
            ReservationPersonsMapper reservationPersonsMapper = new ReservationPersonsMapper();
            PaymentMapper paymentMapper = new PaymentMapper();

                reservationPersonsMapper.delete(reservationId);
                paymentMapper.delete(reservationId);

            reservationGateway.delete(reservationId);
        } catch (ReservationGatewayException e) {
          //  e.printStackTrace();
            System.out.println("Error while deleting reservation!");
        }
    }

    public List<Reservation> findAll(int id) {
        try {
            ResultSet r = reservationGateway.findAllReservationForClient(id);
            List<Reservation> reservationList = new ArrayList<>();

            while (r.next()) {


                reservationList.add(new Reservation(r.getInt("idReservation"), r.getInt("idClient"), r.getString("destination"),
                        r.getString("hotel"), r.getInt("personNumber"), r.getInt("price"), r.getDate("date"),
                        r.getInt("partialPayment"), r.getInt("paid")));


            }
            reservationGateway.closeConnection();
            return reservationList;
        } catch (ReservationGatewayException | SQLException e) {
           // e.printStackTrace();
            System.out.println("Error while selecting reservation!");
        }
        return null;
    }

    public Reservation findById(int idReservation) {
        try {
            ResultSet r = reservationGateway.findById(idReservation);
            Reservation tempReservation = null;

            while (r.next()) {


                tempReservation = new Reservation(r.getInt("idReservation"), r.getInt("idClient"), r.getString("destination"),
                        r.getString("hotel"), r.getInt("personNumber"), r.getInt("price"), r.getDate("date"),
                        r.getInt("partialPayment"), r.getInt("paid"));


            }
            reservationGateway.closeConnection();
            return tempReservation;
        } catch (ReservationGatewayException | SQLException e) {
           // e.printStackTrace();
            System.out.println("Error while inserting by id reservation!");
        }
        return null;
    }

    public int getLastId() {
        try {
            ResultSet r = reservationGateway.getLastId();
            r.next();
            int id = r.getInt("MAX(idReservation)");
            reservationGateway.closeConnection();
            return id;
        } catch (Exception e) {
            System.out.println("Error occured while selecting reservation last id to the database.");
        }
        return -1;
    }

    public void updateP(int reservationId, int payments) {
        try {
            Reservation reservation = findById(reservationId);
            reservationGateway.update(reservationId, reservation.getClient(), reservation.getDestination(), reservation.getHotel(), reservation.getPersonNumber()
                    , reservation.getPrice(), reservation.getDate(), payments, reservation.getPaid());
        } catch (Exception E) {
            System.out.println("Error occured while updating reservation to the database.");
        }
    }

    public void checkPaid(int reservationId) {
        try {
            Reservation reservation = findById(reservationId);
            if (reservation.checkPaid())
                reservationGateway.update(reservationId, reservation.getClient(), reservation.getDestination(), reservation.getHotel(), reservation.getPersonNumber()
                        , reservation.getPrice(), reservation.getDate(), reservation.getPartialPayment(), 1);
        } catch (Exception E) {
            System.out.println("Error occured while updating reservation to the database.");
        }
    }

    public List<Integer> checkDate() {
        try {
            ResultSet r = reservationGateway.findAll();
            List<Integer> idList = new ArrayList<>();

            while (r.next()) {


                Reservation rez = new Reservation(r.getInt("idReservation"), r.getInt("idClient"), r.getString("destination"),
                        r.getString("hotel"), r.getInt("personNumber"), r.getInt("price"), r.getDate("date"),
                        r.getInt("partialPayment"), r.getInt("paid"));

                if (rez.isDatePassed())
                    idList.add(rez.getClient());
            }
            reservationGateway.closeConnection();
            return idList;
        } catch (ReservationGatewayException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteByClientId(int clientId) {
        try {
            List<Reservation> reservations = findAll(clientId);
            ReservationPersonsMapper reservationPersonsMapper = new ReservationPersonsMapper();
            PaymentMapper paymentMapper = new PaymentMapper();
            for( Reservation rez: reservations){
                reservationPersonsMapper.delete(rez.getIdReservation());
                paymentMapper.delete(rez.getIdReservation());
            }

            reservationGateway.deleteByClientId(clientId);
        } catch (Exception e) {
            //  e.printStackTrace();
            System.out.println("Error while deleting reservation!");
        }
    }
}
