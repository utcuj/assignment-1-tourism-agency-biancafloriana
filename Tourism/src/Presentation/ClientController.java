package Presentation;

import domainLayer.Mapper.ClientMapper;
import domainLayer.Mapper.ReservationMapper;
import domainLayer.domainModel.Client;

import java.awt.event.*;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ClientController {

    private ClientView clientView ;

    ClientController() {
        clientView = new ClientView();
        seeAllMissedDate();
    }


    private void seeAllMissedDate() {

        try {
            ReservationMapper reservationMapper = new ReservationMapper();
            List<Integer> idClientList = reservationMapper.checkDate();
            ClientMapper clientMapper = new ClientMapper();
            for (Integer anIdClientList : idClientList) {

                Client client = clientMapper.findbyId(anIdClientList);
                Vector clientV = new Vector();

                clientV.add(client.getIdClient());
                clientV.add(client.getFirstName());
                clientV.add(client.getLastName());
                clientV.add(String.valueOf(client.getAge()));
                clientV.add(client.getAdress());
                clientV.add(client.getCnp());
                clientV.add(client.getCard());
                clientView.addClient(clientV);
            }

            }catch(Exception e){
                clientView.printMessage("Nu s-a putut efectua cautarea!");

            }
        }

    }

