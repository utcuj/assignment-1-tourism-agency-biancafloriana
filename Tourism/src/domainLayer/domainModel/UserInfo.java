package domainLayer.domainModel;

import java.sql.Date;

public class UserInfo  {

    private String username;
    private String info;
    private Date date;

    public UserInfo(String username, String info, Date date) {
        this.username = username;
        this.info = info;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
