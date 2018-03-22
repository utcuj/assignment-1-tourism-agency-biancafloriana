package domainLayer.Mapper;

import database.ClientGateway;
import Exception.*;
import domainLayer.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientMapper {
    private ClientGateway clientGateway ;

    public ClientMapper() {
        this.clientGateway = new ClientGateway();
    }


    public void insert(Client client)
     {
        try{
            clientGateway.insert(client.getFirstName(),client.getLastName(),client.getAge(),client.getCnp(),client.getCard(),client.getAdress());
        }catch(ClientGatewayException e){
           System.out.print(e.fillInStackTrace());
        }
    }

    public void update(Client client)
    {
        try{
            clientGateway.update(client.getIdClient(),client.getFirstName(),client.getLastName(),client.getAge(),client.getCnp(),client.getCard(),client.getAdress());
        }catch(ClientGatewayException e){
            System.out.print(e.fillInStackTrace());
        }
    }

    public void delete(Client client)
    {
        try{
            clientGateway.delete(client.getIdClient());
        }catch(ClientGatewayException e){
            System.out.print(e.fillInStackTrace());
        }
    }

    public List<Client> findAll()
    {
        try{
            ResultSet r = clientGateway.findAll();
            List<Client> clientList = new ArrayList<>();

            while(r.next()){

                clientList.add( new Client(r.getInt("idClient"),r.getString("firstName"),r.getString("lastName"),
                        r.getInt("age"),r.getString("adress"),r.getString("cnp"),
                        r.getString("card")));


            }
            clientGateway.closeConnection();
            return clientList;
        }catch(ClientGatewayException e){
            System.out.print(e.fillInStackTrace());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Client findbyId(int idClient)
    {
        try{
            ResultSet r = clientGateway.findAll();
            Client tempClient = null;
            while(r.next()){

             tempClient = new Client(r.getInt("idClient"),r.getString("firstName"),r.getString("lastName"),
                        r.getInt("age"),r.getString("adress"),r.getString("cnp"),
                        r.getString("card"));


            }
            clientGateway.closeConnection();

            return tempClient;
        }catch(ClientGatewayException e){
            System.out.print(e.fillInStackTrace());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
