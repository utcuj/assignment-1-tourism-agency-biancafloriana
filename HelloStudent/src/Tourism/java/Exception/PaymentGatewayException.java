package Exception;

public class PaymentGatewayException extends Exception {
    public PaymentGatewayException(String s, Exception e) {
        System.out.println(s);
    }
}
