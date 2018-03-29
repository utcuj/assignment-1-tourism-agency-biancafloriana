package Presentation;

import domainLayer.Mapper.ClientMapper;
import domainLayer.Mapper.ReservationMapper;
import domainLayer.Mapper.UserInfoMapper;
import domainLayer.domainModel.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class AgentController {

    private AgentView agentView ;
    private String username;

    AgentController(String username) {
        agentView = new AgentView();
        this.username = username;
        ListClient();
        addListenerAddB();
        addListenerNewB();
        addListenerDeleteB();
        addListenerRezB();
        addListenerPassedB();

    }

    private void addListenerAddB() {

        ActionListener addButtonL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Object[] date = agentView.getClient();
                    ClientMapper clientMapper = new ClientMapper();
                    if (date[0] == null) {
                        clientMapper.insert(date);
                        int id = clientMapper.getLastId();
                        agentView.UpdateId(id);

                        UserInfoMapper userInfoMapper = new UserInfoMapper(username);
                        userInfoMapper.insertClient(id);
                    } else {
                        clientMapper.update(date);

                        UserInfoMapper userInfoMapper = new UserInfoMapper(username);
                        userInfoMapper.updateClient((int) date[0]);
                    }

                } catch (Exception e) {
                    agentView.printMessage("Datele nu sunt valide!");
                    e.printStackTrace();
                }
            }
        };
        agentView.addListenerAddB(addButtonL);
    }

    private void addListenerRezB() {

        ActionListener addButtonL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Object[] date = agentView.getClient();
                    //ReservationController rez =
                    new ReservationController((int) date[0], username);


                } catch (Exception e) {
                    agentView.printMessage("Nu s-a selectat clientul!");
                    e.printStackTrace();
                }
            }
        };
        agentView.addListenerRezB(addButtonL);
    }

    private void addListenerNewB() {

        ActionListener ButtonL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    agentView.addNewRow();
                } catch (Exception e) {
                    agentView.printMessage("Nu am putut adauga un rand nou in tabela!");
                    e.printStackTrace();
                }
            }
        };
        agentView.addListenerNewRB(ButtonL);
    }

    private void addListenerDeleteB() {

        ActionListener ButtonL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Object[] date = agentView.getClient();
                    ClientMapper clientMapper = new ClientMapper();

                    if (date[0] != null) {

                        clientMapper.delete((int) date[0]);
                        agentView.removeRow();

                        UserInfoMapper userInfoMapper = new UserInfoMapper(username);
                        userInfoMapper.deleteClient((int) date[0]);
                    }
                } catch (Exception e) {
                    agentView.printMessage("Nu s-a putut efectua stergerea!");
                    //e.printStackTrace();
                }
            }
        };
        agentView.addListenerDeleteB(ButtonL);
    }


    private void ListClient() {
        ClientMapper clientMapper = new ClientMapper();
        List<Client> clientList = clientMapper.findAll();

        for (Client client : clientList) {
            Vector clientV = new Vector();

            clientV.add(client.getIdClient());
            clientV.add(client.getFirstName());
            clientV.add(client.getLastName());
            clientV.add(String.valueOf(client.getAge()));
            clientV.add(client.getCnp());
            clientV.add(client.getCard());
            clientV.add(client.getAdress());
            agentView.addClient(clientV);
        }
    }


    private void addListenerPassedB() {
        ActionListener ButtonL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    //ClientController clientController =
                            new ClientController();
                } catch (Exception e) {
                    agentView.printMessage("Nu s-a putut efectua interogarea pentru clientii cu rezervarile expirate!");
                    e.printStackTrace();
                }
            }
        };
        agentView.addListenerPassedB(ButtonL);


    }
}

