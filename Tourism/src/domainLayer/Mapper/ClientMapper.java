package domainLayer.Mapper;

import database.ClientGateway;
import Exception.*;
import domainLayer.domainModel.Client;
import domainLayer.domainModel.Reservation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientMapper {
    private ClientGateway clientGateway;

    public ClientMapper() {
        this.clientGateway = new ClientGateway();
    }


    public void insert(Object[] client) {
        try {
            clientGateway.insert((String) client[1], (String) client[2], Integer.valueOf((String) client[3]), (String) client[4], (String) client[5], (String) client[6]);
        } catch (ClientGatewayException e) {
            System.out.println("Error occured while saving client to the database.");
        }
    }

    public void update(Object[] client) {
        try {
            clientGateway.update((int) client[0], (String) client[1], (String) client[2], Integer.valueOf((String) client[3]), (String) client[4], (String) client[5], (String) client[6]);
        } catch (ClientGatewayException e) {
            System.out.println("Error occured while updating client to the database.");
        }
    }

    public void delete(int clientId) {
        try {

            ReservationMapper reservationMapper= new ReservationMapper();

            reservationMapper.deleteByClientId(clientId);

            clientGateway.delete(clientId);
        } catch (ClientGatewayException e) {
            System.out.println("Error occured while deleting client to the database.");
        }
    }

    public List<Client> findAll() {
        try {
            ResultSet r = clientGateway.findAll();
            List<Client> clientList = new ArrayList<>();

            while (r.next()) {

                clientList.add(new Client(r.getInt("idClient"), r.getString("firstName"), r.getString("lastName"),
                        r.getInt("age"), r.getString("adress"), r.getString("cnp"),
                        r.getString("card")));

            }
            clientGateway.closeConnection();
            return clientList;
        } catch (ClientGatewayException | SQLException e) {
            System.out.println("Error occured while selecting client to the database.");
        }
        return null;
    }

        public Client findbyId(int idClient) {
        try {
            ResultSet r = clientGateway.findbyId(idClient);
            Client tempClient = null;
            while (r.next()) {

                tempClient = new Client(r.getInt("idClient"), r.getString("firstName"), r.getString("lastName"),
                        r.getInt("age"), r.getString("adress"), r.getString("cnp"),
                        r.getString("card"));

            }
            clientGateway.closeConnection();
            return tempClient;
        }catch (ClientGatewayException | SQLException e) {
                System.out.println("Error occured while selecting client to the database.");
            }
            return null;
    }

    public int getLastId() {
        try {
            ResultSet r = clientGateway.getLastId();
            r.next();
            int id = r.getInt("MAX(idClient)");
            clientGateway.closeConnection();
            return id;
        }catch (ClientGatewayException | SQLException e) {
                System.out.println("Error occured while selecting client to the database.");
            }

        return -1;
    }


}
