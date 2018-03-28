package Exception;

public class ClientGatewayException extends Exception {
    public ClientGatewayException(String s, Exception e) {
        System.out.println(s);

    }
}
