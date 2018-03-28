package domainLayer.Mapper;

import database.ReservationGateway;
import domainLayer.domainModel.Reservation;
import Exception.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationMapper {
    private ReservationGateway reservationGateway;

    public ReservationMapper() {
        this.reservationGateway = new ReservationGateway();
    }


    public void insert(Reservation reservation) {
        try {
            reservationGateway.insert(reservation.getClient(), reservation.getDestination(), reservation.getHotel(), reservation.getPersonNumber(),
                    reservation.getPrice(), reservation.getDate(), reservation.getPartialPayment(), reservation.isPaid());
        } catch (ReservationGatewayException e) {
            e.printStackTrace();
        }
    }

    public void update(Reservation reservation) {
        try {
            reservationGateway.update(reservation.getIdReservation(), reservation.getClient(), reservation.getDestination(), reservation.getHotel(), reservation.getPersonNumber(),
                    reservation.getPrice(), reservation.getDate(), reservation.getPartialPayment(), reservation.isPaid());
        } catch (ReservationGatewayException e) {
            e.printStackTrace();
        }
    }

    public void delete(Reservation reservation) {
        try {
            reservationGateway.delete(reservation.getIdReservation());
        } catch (ReservationGatewayException e) {
            e.printStackTrace();
        }
    }

    public List<Reservation> findAll() {
        try {
            ResultSet r = reservationGateway.findAll();
            List<Reservation> reservationList = new ArrayList<>();

            while (r.next()) {


                reservationList.add(new Reservation(r.getInt("idReservation"), r.getInt("idClient"), r.getString("destination"),
                        r.getString("hotel"), r.getInt("personNumber"), r.getInt("price"), r.getDate("date"),
                        r.getInt("partialPayment"), r.getInt("paid")));


            }
            reservationGateway.closeConnection();
            return reservationList;
        } catch (ReservationGatewayException | SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return null;
    }

}
