package domainLayer.Mapper;

import database.UserGateway;

import java.sql.ResultSet;

public class UserMapper {
        UserGateway userGateway = new UserGateway();
    public int check(Object[] date) {

        try {
            ResultSet r = userGateway.find((String) date[0]);
            r.next();
            System.out.println(r.getString("password"));
            if (r.getString("password").compareTo((String)date[1])== 0) {
                if (date[0] == "admin") return 2;
                return 1;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    return -1;}
}
