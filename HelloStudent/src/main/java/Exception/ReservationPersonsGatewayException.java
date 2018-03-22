package Exception;

public class ReservationPersonsGatewayException extends Exception {

    public ReservationPersonsGatewayException(String s, Exception e) {
        System.out.println(s);
    }
}
