package domainLayer.Mapper;

import database.PaymentGateway;
import domainLayer.domainModel.Payment;
import Exception.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentMapper {
    private PaymentGateway paymentGateway;

    public PaymentMapper() {
        this.paymentGateway = new PaymentGateway();
    }


    public void insert(Object[] payment, int paymentId, int clientId) {
        try {
            paymentGateway.insert(clientId,paymentId, Integer.valueOf((String)payment[1]),  Date.valueOf((String)payment[2]));
        } catch (PaymentGatewayException e) {
            e.printStackTrace();
        }
    }

    public void update(Object[] payment, int paymentId, int clientId) {
        try {
            paymentGateway.update((int)payment[0],clientId,paymentId, Integer.valueOf((String)payment[1]),  Date.valueOf((String)payment[5]));
        } catch (PaymentGatewayException e) {
            e.printStackTrace();
        }
    }

    public void delete(int idReservation) {
        try {
            paymentGateway.delete(idReservation);
        } catch (PaymentGatewayException e) {
            e.printStackTrace();
        }
    }

    public List<Payment> findAll(int reservationId) {
        try {
            ResultSet r = paymentGateway.findAll(reservationId);
            List<Payment> paymentList = new ArrayList<>();

            while (r.next()) {

                paymentList.add(new Payment(r.getInt("idPayment"), r.getInt("idClient"), r.getInt("idReservation"),
                        r.getInt("payment"), r.getDate("date")));


            }
            paymentGateway.closeConnection();
            return paymentList;
        } catch (PaymentGatewayException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Payment findById(int idPayment) {
        try {
            ResultSet r = paymentGateway.findById(idPayment);
            Payment tempPayment = null;

            while (r.next()) {

                tempPayment = new Payment(r.getInt("idPayment"), r.getInt("idClient"), r.getInt("idReservation"),
                        r.getInt("payment"), r.getDate("date"));


            }
            paymentGateway.closeConnection();
            return tempPayment;
        } catch (PaymentGatewayException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int getLastId(){
        try {
            ResultSet r = paymentGateway.getLastId();
            r.next();
            int id = r.getInt("MAX(idpayment)");
            paymentGateway.closeConnection();
            return id;
        } catch (ClientGatewayException e) {
            System.out.print(e.fillInStackTrace());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int getPayments(int idReservation){
        try {
            ResultSet r = paymentGateway.getPayments(idReservation);
            int tempPayment =  0;

            while (r.next()) {

                tempPayment += r.getInt("payment");
            }
            paymentGateway.closeConnection();
            return tempPayment;
        } catch (ClientGatewayException e) {
            System.out.print(e.fillInStackTrace());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
