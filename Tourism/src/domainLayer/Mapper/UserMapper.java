package domainLayer.Mapper;

import database.Gateway.UserGateway;
import domainLayer.Model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    UserGateway userGateway = new UserGateway();

    public int check(Object[] date) {

        try {
            ResultSet r = userGateway.find((String) date[0]);
            r.next();
            User user = new User(r.getString("username"), r.getString("password"));
            if (user.checkPassword((String) date[1])) {
                if (user.checkAdmin()) {
                    return 2;
                }
                return 1;
            }

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Nu s-a putut face verificarea!");
        }

        return -1;
    }


    public User findById(Object date) {
        try {
            ResultSet r = userGateway.find((String)date);
            User tempUser = null;

            while (r.next()) {

                tempUser = new User(r.getString("username"), r.getString("password"));

            }
            userGateway.closeConnection();
            return tempUser;
        } catch ( SQLException e) {
           // e.printStackTrace();
            System.out.println("Nu s-a putut face verificarea!");
        }
        return null;
    }

    public void insert(Object[] date) {
        try {
            userGateway.insert((String)date[0], (String)date[1]);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Nu s-a putut face salvarea!");
        }
    }

    public void update(Object[] date) {
        try {
            userGateway.update((String)date[0], (String)date[1]);
        } catch (Exception e) {
           // e.printStackTrace();
            System.out.println("Nu s-a putut face update!");
        }
    }

    public void delete(String date) {
        try {
            userGateway.delete(date);
        } catch (Exception e)  {
           // e.printStackTrace();
            System.out.println("Nu s-a putut face stergerea!");
        }
    }

    public List<User> findAll() {
        try {
            ResultSet r = userGateway.findAll();
            List<User> userList = new ArrayList<>();

            while (r.next()) {

                userList.add(new User(r.getString("username"),r.getString("password")));
                
            }
            userGateway.closeConnection();
            return userList;
        } catch (SQLException e) {
           // e.printStackTrace();
            System.out.println("Nu s-a putut face selectarea!");
        }
        return null;
    }
}
