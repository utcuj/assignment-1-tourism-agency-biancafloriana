package domainLayer.domainModel;

public class User {

    private String username;
    private String password;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPassword(String password){
        //System.out.println(password + this.password);
        return password.compareTo(this.password) == 0;
    }

    public boolean checkAdmin() {
        return username.compareTo("admin") == 0;
    }
}
