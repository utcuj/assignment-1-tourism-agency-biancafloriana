package domainLayer.domainModel;

public class ReservationPersons {
    private int idReservationPersons;
    private int idReservation;
    private int idPerson;

    public ReservationPersons(int idReservation, int idPerson) {
        this.idReservation = idReservation;
        this.idPerson = idPerson;
    }

    public ReservationPersons(int idReservationPersons, int idReservation, int idPerson) {
        this.idReservationPersons = idReservationPersons;
        this.idReservation = idReservation;
        this.idPerson = idPerson;
    }

    public int getIdReservationPersons() {
        return idReservationPersons;
    }

    public void setIdReservationPersons(int idReservationPersons) {
        this.idReservationPersons = idReservationPersons;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }
}
