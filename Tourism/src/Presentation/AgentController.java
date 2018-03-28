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
        addListenerAddB();
        addListenerNewB();

    }

    private void addListenerAddB(){

        ActionListener addButtonL = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    Object[] date = agentView.getClient();
                    ClientMapper clientMapper = new ClientMapper();
                    if( date[0]==null)
                                clientMapper.insert(new Client((String)date[1],(String)date[2],Integer.valueOf((String)date[3]),(String)date[4],(String)date[5],(String)date[6]));
                    else clientMapper.update(new Client((int)date[0],(String)date[1],(String)date[2],Integer.valueOf((String)date[3]),(String)date[4],(String)date[5],(String)date[6]));

                   }catch(Exception e){
                    agentView.printMessage("Datele nu sunt valide!");
                    e.printStackTrace();
                }
            }
        };
        agentView.addListenerAddB(addButtonL);
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
        agentView.addListenerUpdateB(ButtonL);
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

    public static void  main(String[] args){

        AgentController agentController = new AgentController();
        agentController.ListClient();

    }
}
