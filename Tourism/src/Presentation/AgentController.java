package Presentation;

import domainLayer.Mapper.ClientMapper;
import domainLayer.domainModel.Client;

import java.awt.event.*;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class AgentController {

    public AgentView agentView = new AgentView();

    AgentController(){
        agentView.init();
        ListClient();
        addListenerAddB();
        addListenerNewB();
        addListenerDeleteB();
        addListenerRezB();


    }

    private void addListenerAddB(){

        ActionListener addButtonL = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    Object[] date = agentView.getClient();
                    ClientMapper clientMapper = new ClientMapper();
                    if( date[0]==null) {
                        clientMapper.insert(date);
                        int id = clientMapper.getLastId();
                        agentView.UpdateId(id);
                    }
                    else {
                        clientMapper.update(date);
                    }

                   }catch(Exception e){
                    agentView.printMessage("Datele nu sunt valide!");
                    e.printStackTrace();
                }
            }
        };
        agentView.addListenerAddB(addButtonL);
    }

    private void addListenerRezB(){

        ActionListener addButtonL = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    Object[] date = agentView.getClient();
                    ReservationController rez = new ReservationController((int)date[0]);


                }catch(Exception e){
                    agentView.printMessage("Datele nu sunt valide!");
                    e.printStackTrace();
                }
            }
        };
        agentView.addListenerRezB(addButtonL);
    }
    private void addListenerNewB(){

        ActionListener ButtonL = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    agentView.addNewRow();
                }catch(Exception e){
                    agentView.printMessage("Nu am putut adauga un rand nou!");
                    e.printStackTrace();
                }
            }
        };
        agentView.addListenerNewRB(ButtonL);
    }

    private void addListenerDeleteB(){

        ActionListener ButtonL = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    Object[] date = agentView.getClient();
                    ClientMapper clientMapper = new ClientMapper();
                    if(date[0]!=null){
                    clientMapper.delete((int)date[0]);
                    agentView.removeRow();
                    }
                }catch(Exception e){
                    agentView.printMessage("Nu s-a putut efectua stergerea!");
                    e.printStackTrace();
                }
            }
        };
        agentView.addListenerDeleteB(ButtonL);
    }

    public void checkDate(){
      /*  ClientMapper clientMapper = new ClientMapper();
       // List<Client> clientList = clientMapper.finaAllcheck();

        for(Iterator<Client> i = clientList.iterator(); i.hasNext();){
            Client client=i.next();
            Vector clientV = new Vector();

            clientV.add(client.getIdClient());
            clientV.add(client.getFirstName());
            clientV.add(client.getLastName());
            clientV.add(String.valueOf(client.getAge()));
            clientV.add(client.getAdress());
            clientV.add(client.getCnp());
            clientV.add(client.getCard());
            agentView.addClient(clientV);
        }

*/
    }

    public void ListClient(){
            ClientMapper clientMapper = new ClientMapper();
            List<Client> clientList = clientMapper.findAll();

        for(Iterator<Client> i = clientList.iterator(); i.hasNext();){
            Client client=i.next();
            Vector clientV = new Vector();

            clientV.add(client.getIdClient());
            clientV.add(client.getFirstName());
            clientV.add(client.getLastName());
            clientV.add(String.valueOf(client.getAge()));
            clientV.add(client.getAdress());
            clientV.add(client.getCnp());
            clientV.add(client.getCard());
            agentView.addClient(clientV);
            }
    }

  /*  public static void  main(String[] args){

        AgentController agentController = new AgentController();
        agentController.ListClient();

    }*/
}
