package Exception;

public class DataMapperException extends Exception {
    public DataMapperException(String s, Exception e) {
        System.out.println(s);
        System.out.println(e.fillInStackTrace());
    }
}
