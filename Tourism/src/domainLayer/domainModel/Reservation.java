package domainLayer.domainModel;


import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {

    private int idReservation;
    private int client;
    private String destination;
    private String hotel;
    private int personNumber;
    private int price;
    private Date date;
    private int partialPayment;
    private int paid;

    public Reservation(int client, String destination, String hotel, int personNumber, int price, Date date, int partialPayment, int paid) {
        this.client = client;
        this.destination = destination;
        this.hotel = hotel;
        this.personNumber = personNumber;
        this.price = price;
        this.date = date;
        this.partialPayment = partialPayment;
        this.paid = paid;
    }

    public Reservation(int idReservation, int client, String destination, String hotel, int personNumber, int price, Date date, int partialPayment, int paid) {
        this.idReservation = idReservation;
        this.client = client;
        this.destination = destination;
        this.hotel = hotel;
        this.personNumber = personNumber;
        this.price = price;
        this.date = date;
        this.partialPayment = partialPayment;
        this.paid = paid;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public int getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(int personNumber) {
        this.personNumber = personNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPartialPayment() {
        return partialPayment;
    }

    public void setPartialPayment(int partialPayment) {
        this.partialPayment = partialPayment;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }


    public boolean isDatePassed(){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        return date.compareTo(Date.valueOf(dtf.format(localDate)))==-1 && paid == 0;
    }

    public boolean checkPaid(){
        return price <= partialPayment;
    }
}
