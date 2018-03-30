package domainLayer.Mapper;

import database.Gateway.UserInfoGateway;
import domainLayer.Model.UserInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UserInfoMapper {
    private String username;
    UserInfoGateway userInfoGateway = new UserInfoGateway();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");



    public UserInfoMapper(String username) {
        this.username = username;
    }

    public void insertClient(int idClient) {

        userInfoGateway.insert(username,"Added a new client with id= " + idClient,dtf.format( LocalDate.now()));
    }

    public void updateClient(int idClient) {
        userInfoGateway.insert(username,"Added updated client with id= " + idClient,dtf.format( LocalDate.now()));
    }

    public void deleteClient(int idClient) {
        userInfoGateway.insert(username,"Added deleted client with id= " + idClient,dtf.format( LocalDate.now()));
    }

    public void insertReservation(int idClient,int idReservation) {
        userInfoGateway.insert(username,"Added  a reservation with id= "+ idReservation +" for client with id= " + idClient,dtf.format( LocalDate.now()));
    }

    public void deletedReservation(int idClient, int idReservation) {

        userInfoGateway.insert(username,"Added deleted a reservation with id= "+ idReservation +" for client with id= " + idClient,dtf.format( LocalDate.now()));
    }

    public void updateReservation(int idClient, int idReservation) {
        userInfoGateway.insert(username,"Added updated a reservation with id= "+ idReservation +" for client with id= " + idClient,dtf.format( LocalDate.now()));
    }

    public void insertPayment(int idClient, int idReservation, int id) {

        userInfoGateway.insert(username,"Added a payment with id= "+ id +" for a reservation with id= "+ idReservation +" for client with id= " + idClient,dtf.format( LocalDate.now()));
    }

    public List<UserInfo> findAll(String[] dates) {

        try {
            ResultSet r = userInfoGateway.findAll(username, dates);
            List<UserInfo> userList = new ArrayList<>();

            while (r.next()) {

                userList.add(new UserInfo(r.getString("username"),r.getString("info"),r.getDate("date")));

            }
            userInfoGateway.closeConnection();
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    }

