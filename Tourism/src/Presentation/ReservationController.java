package Presentation;

import domainLayer.Mapper.PaymentMapper;
import domainLayer.Mapper.ReservationMapper;
import domainLayer.domainModel.Reservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ReservationController {
    
        private ReservationView reservationView ;
        private int clientId;
    public ReservationController(int id) {
        clientId = id;
        reservationView = new ReservationView();
        reservationView.init();
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
                    }
                    else {
                        reservationMapper.update(date,clientId);
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
                    reservationView.printMessage("Nu am putut adauga un rand nou!");
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
                    PersonController personController = new PersonController((int)date[0]);

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
                    PaymentController paymentController = new PaymentController((int)date[0],clientId);

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
                    }
                }catch(Exception e){
                    reservationView.printMessage("Nu s-a putut efectua stergerea!");
                    e.printStackTrace();
                }
            }
        };
        reservationView.addListenerDeleteB(ButtonL);
    }

    public void ListReservation(){
        ReservationMapper reservationMapper = new ReservationMapper();
        List<Reservation> reservationList = reservationMapper.findAll(clientId);

        for(Iterator<Reservation> i = reservationList.iterator(); i.hasNext();){
            Reservation reservation=i.next();
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
