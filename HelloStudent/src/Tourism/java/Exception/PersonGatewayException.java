package Exception;

public class PersonGatewayException extends Exception {
    public PersonGatewayException(String s, Exception e) {

        System.out.println(s);
        System.out.println(e.fillInStackTrace());
    }
}
