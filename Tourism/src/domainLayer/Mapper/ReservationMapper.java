package domainLayer.Mapper;

import database.ReservationGateway;
import domainLayer.domainModel.Reservation;
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
            reservationGateway.insert(reservationId, (String)reservation[1], (String)reservation[2], Integer.valueOf((String)reservation[3]),
                    Integer.valueOf((String)reservation[3]), Date.valueOf((String)reservation[5]), (int)reservation[6], (int)reservation[7]);

        } catch (ReservationGatewayException e) {
            e.printStackTrace();
        }
    }

    public void update(Object[] reservation, int reservationId) {
        try {
            reservationGateway.update((int)reservation[0],
                    reservationId, (String)reservation[1],
                    (String)reservation[2],
                    Integer.valueOf((String)reservation[3]),
                    Integer.valueOf((String)reservation[3]),
                    Date.valueOf((String)reservation[5]),
                    (int)reservation[6], (int)reservation[7]);
        } catch (ReservationGatewayException e) {
            e.printStackTrace();
        }
    }

    public void delete(int reservationId) {
        try {
            reservationGateway.delete(reservationId);
        } catch (ReservationGatewayException e) {
            e.printStackTrace();
        }
    }

    public List<Reservation> findAll(int id) {
        try {
            ResultSet r = reservationGateway.findAll(id);
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

    public int getLastId(){
        try {
            ResultSet r = reservationGateway.getLastId();
            r.next();
            int id = r.getInt("MAX(idReservation)");
            reservationGateway.closeConnection();
            return id;
        } catch (ClientGatewayException e) {
            System.out.print(e.fillInStackTrace());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void updateP(int reservationId, int payments) {
        try {
            Reservation reservation = findById(reservationId);
            reservationGateway.update(reservationId, reservation.getClient(), reservation.getDestination(), reservation.getHotel(), reservation.getPersonNumber()
                    , reservation.getPrice(), reservation.getDate(), payments, reservation.getPaid());
        }catch (Exception E){System.out.println("Nu sa putut updata paymentul");}
    }

    public void checkPaid(int reservationId){
        try {
            Reservation reservation = findById(reservationId);
            if(reservation.getPrice() <= reservation.getPartialPayment())
            reservationGateway.update(reservationId, reservation.getClient(), reservation.getDestination(), reservation.getHotel(), reservation.getPersonNumber()
                    , reservation.getPrice(), reservation.getDate(), reservation.getPartialPayment(), 1);
        }catch (Exception E){System.out.println("Nu sa putut updata paymentul");}
    }
}
