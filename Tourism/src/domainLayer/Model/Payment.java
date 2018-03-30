package domainLayer.Model;

import java.sql.Date;

public class Payment {
    private int idPayment;
    private int idClient;
    private int idReservation;
    private int payment;
    private Date date;

    public Payment(int idPayment, int idClient, int idReservation, int payment, Date date) {
        this.idPayment = idPayment;
        this.idClient = idClient;
        this.idReservation = idReservation;
        this.payment = payment;
        this.date = date;
    }

    public Payment(int idClient, int idReservation, int payment, Date date) {
        this.idClient = idClient;
        this.idReservation = idReservation;
        this.payment = payment;
        this.date = date;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public int getidClient() {
        return idClient;
    }

    public void setidClient(int idClient) {
        this.idClient = idClient;
    }

    public int getidReservation() {
        return idReservation;
    }

    public void setidReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
