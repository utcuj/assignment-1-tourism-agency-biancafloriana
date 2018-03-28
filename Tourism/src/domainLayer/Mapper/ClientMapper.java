package domainLayer.Mapper;

import database.ClientGateway;
import Exception.*;
import domainLayer.domainModel.Client;

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
            clientGateway.insert((String)client[1],(String)client[2],Integer.valueOf((String)client[3]),(String)client[4],(String)client[5],(String)client[6]);
        } catch (ClientGatewayException e) {
            System.out.print(e.fillInStackTrace());
        }
    }

    public void update(Object[] client) {
        try {
            clientGateway.update((int)client[0],(String)client[1],(String)client[2],Integer.valueOf((String)client[3]),(String)client[4],(String)client[5],(String)client[6]);
        } catch (ClientGatewayException e) {
            System.out.print(e.fillInStackTrace());
        }
    }

    public void delete(int clientId) {
        try {
            clientGateway.delete(clientId);
        } catch (ClientGatewayException e) {
            System.out.print(e.fillInStackTrace());
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
        } catch (ClientGatewayException e) {
            System.out.print(e.fillInStackTrace());
        } catch (SQLException e) {
            e.printStackTrace();
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
        } catch (ClientGatewayException e) {
            System.out.print(e.fillInStackTrace());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getLastId(){
        try {
            ResultSet r = clientGateway.getLastId();
            r.next();
            int id = r.getInt("MAX(idClient)");
            clientGateway.closeConnection();
            return id;
        } catch (ClientGatewayException e) {
            System.out.print(e.fillInStackTrace());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }


}
