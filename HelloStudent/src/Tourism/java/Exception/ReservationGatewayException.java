package Exception;

public class ReservationGatewayException extends Exception {


    public ReservationGatewayException(String s, Exception e) {
        System.out.println(s);
    }
}
