package Presentation.Controller;

import Presentation.View.ReservationView;
import domainLayer.Mapper.ReservationMapper;
import domainLayer.Mapper.UserInfoMapper;
import domainLayer.Model.Reservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class ReservationController {
    
        private ReservationView reservationView ;
        private int clientId;
        private String username;

    public ReservationController(int id,String username) {
        this.username = username;
        clientId = id;
        reservationView = new ReservationView();

        addListenerAddB();
        addListenerDeleteB();
        addListenerNewB();
        ListReservation();
        addListenerPaymentB();
        addListenerPersonsB();

    }
    private void addListenerAddB(){

        ActionListener addButtonL = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    Object[] date = reservationView.getReservation();
                    ReservationMapper reservationMapper = new ReservationMapper();
                    if( date[0]==null) {
                        reservationMapper.insert(date,clientId);
                        int id = reservationMapper.getLastId();
                        reservationView.UpdateId(id);
                        UserInfoMapper userInfoMapper = new UserInfoMapper(username);
                        userInfoMapper.insertReservation(clientId,id);
                    }
                    else {
                        reservationMapper.update(date,clientId);

                        UserInfoMapper userInfoMapper = new UserInfoMapper(username);
                        userInfoMapper.updateReservation(clientId,(int)date[0]);
                    }

                }catch(Exception e){
                    reservationView.printMessage("Datele nu sunt valide!");
                    e.printStackTrace();
                }
            }
        };
        reservationView.addListenerAddB(addButtonL);
    }


    private void addListenerNewB(){

        ActionListener ButtonL = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    reservationView.addNewRow();
                }catch(Exception e){
                    reservationView.printMessage("Nu am putut adauga un rand nou !");
                    e.printStackTrace();
                }
            }
        };
        reservationView.addListenerNewRB(ButtonL);
    }
    private void addListenerPersonsB(){

        ActionListener ButtonL = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    Object[] date = reservationView.getReservation();
                    //PersonController personController =
                    new PersonController((int)date[0]);

                }catch(Exception e){
                    reservationView.printMessage("Datele nu sunt valide!");
                    e.printStackTrace();
                }
            }
        };

        reservationView.addListenerPersonsB(ButtonL);
    }

    private void addListenerPaymentB(){

        ActionListener ButtonL = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    Object[] date = reservationView.getReservation();
                    System.out.print((int)date[0]);
                    //PaymentController paymentController =
                    new PaymentController((int)date[0],clientId,username);

                }catch(Exception e){
                    reservationView.printMessage("Datele nu sunt valide!");
                    e.printStackTrace();
                }
            }
        };

        reservationView.addListenerPaymentB(ButtonL);
    }

    private void addListenerDeleteB(){

        ActionListener ButtonL = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    Object[] date = reservationView.getReservation();
                    ReservationMapper reservationMapper = new ReservationMapper();
                    if(date[0]!=null){
                        reservationMapper.delete((int)date[0]);
                        reservationView.removeRow();

                        UserInfoMapper userInfoMapper = new UserInfoMapper(username);
                        userInfoMapper.deletedReservation(clientId,(int)date[0]);
                    }
                }catch(Exception e){
                    reservationView.printMessage("Nu s-a putut efectua stergerea!");
                    e.printStackTrace();
                }
            }
        };
        reservationView.addListenerDeleteB(ButtonL);
    }

    private void ListReservation(){
        ReservationMapper reservationMapper = new ReservationMapper();
        List<Reservation> reservationList = reservationMapper.findAll(clientId);

        for (Reservation reservation : reservationList) {
            Vector reservationV = new Vector();

            reservationV.add(reservation.getIdReservation());
            reservationV.add(reservation.getDestination());
            reservationV.add(reservation.getHotel());
            reservationV.add(String.valueOf(reservation.getPersonNumber()));
            reservationV.add(String.valueOf(reservation.getPrice()));
            reservationV.add(String.valueOf(reservation.getDate()));
            reservationV.add(String.valueOf(reservation.getPartialPayment()));
            reservationV.add(String.valueOf(reservation.getPaid()));
            reservationView.addReservation(reservationV);
        }
    }
}
