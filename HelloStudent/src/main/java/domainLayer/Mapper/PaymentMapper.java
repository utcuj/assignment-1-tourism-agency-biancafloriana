package domainLayer.Mapper;

import database.PaymentGateway;
import domainLayer.domainModel.Payment;
import Exception.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentMapper {
    private PaymentGateway paymentGateway;

    public PaymentMapper() {
        this.paymentGateway = new PaymentGateway();
    }


    public void insert(Payment payment) {
        try {
            paymentGateway.insert(payment.getidClient(), payment.getIdPayment(), payment.getPayment(), payment.getDate());
        } catch (PaymentGatewayException e) {
            e.printStackTrace();
        }
    }

    public void update(Payment payment) {
        try {
            paymentGateway.update(payment.getIdPayment(), payment.getidClient(), payment.getIdPayment(), payment.getPayment(), payment.getDate());
        } catch (PaymentGatewayException e) {
            e.printStackTrace();
        }
    }

    public void delete(Payment payment) {
        try {
            paymentGateway.delete(payment.getIdPayment());
        } catch (PaymentGatewayException e) {
            e.printStackTrace();
        }
    }

    public List<Payment> findAll() {
        try {
            ResultSet r = paymentGateway.findAll();
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
}
