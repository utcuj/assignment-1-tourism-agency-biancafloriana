package domainLayer.Mapper;

import database.ReservationPersonsGateway;
import domainLayer.domainModel.ReservationPersons;
import Exception.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationPersonsMapper {
    private ReservationPersonsGateway reservationPersonsGateway;

    public ReservationPersonsMapper() {
        this.reservationPersonsGateway = new ReservationPersonsGateway();
    }


    public void insert(ReservationPersons reservationPersons) {
        try {
            reservationPersonsGateway.insert(reservationPersons.getIdPerson(), reservationPersons.getIdReservation());
        } catch (ReservationPersonsGatewayException e) {
            e.printStackTrace();
        }
    }

    public void update(ReservationPersons reservationPersons) {
        try {
            reservationPersonsGateway.update(reservationPersons.getIdReservationPersons(), reservationPersons.getIdPerson(), reservationPersons.getIdReservation());
        } catch (ReservationPersonsGatewayException e) {
            e.printStackTrace();
        }
    }

    public void delete(ReservationPersons reservationPersons) {
        try {
            reservationPersonsGateway.delete(reservationPersons.getIdReservationPersons());
        } catch (ReservationPersonsGatewayException e) {
            e.printStackTrace();
        }
    }

    public List<ReservationPersons> findAll() {
        try {
            ResultSet r = reservationPersonsGateway.findAll();
            List<ReservationPersons> reservationPersonsList = new ArrayList<>();

            while (r.next()) {


                reservationPersonsList.add(new ReservationPersons(r.getInt("idReservationPerson"), r.getInt("idReservation"),
                        r.getInt("idPerson")));


            }
            reservationPersonsGateway.closeConnection();
            return reservationPersonsList;
        } catch (ReservationPersonsGatewayException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ReservationPersons findById(int idReservationPersons) {
        try {
            ResultSet r = reservationPersonsGateway.findById(idReservationPersons);
            ReservationPersons tempReservationPersons = null;

            while (r.next()) {


                tempReservationPersons = new ReservationPersons(r.getInt("idReservationPerson"), r.getInt("idReservation"),
                        r.getInt("idPerson"));


            }
            reservationPersonsGateway.closeConnection();
            return tempReservationPersons;
        } catch (ReservationPersonsGatewayException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
