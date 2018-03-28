package Presentation;

import domainLayer.Mapper.PaymentMapper;
import domainLayer.Mapper.ReservationMapper;
import domainLayer.domainModel.Payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class PaymentController {
    private PaymentView paymentView ;
    private int reservationId, clientId;
    public PaymentController(int reservationId,int clientId) {
        this.reservationId = reservationId;
        this.clientId = clientId;
        paymentView = new PaymentView();
        paymentView.init();
        addListenerAddB();
        //addListenerDeleteB();
        addListenerNewB();
        ListPayment();

    }
    private void addListenerAddB(){

        ActionListener addButtonL = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    Object[] date = paymentView.getPayment();
                    PaymentMapper paymentMapper = new PaymentMapper();
                    ReservationMapper reservationMapper = new ReservationMapper();
                    if( date[0]==null) {
                        if(reservationMapper.findById(reservationId).getDate().compareTo(Date.valueOf((String)date[2])) == 1){
                        paymentMapper.insert(date,reservationId,clientId);
                        int id = paymentMapper.getLastId();
                        paymentView.UpdateId(id, Date.valueOf((String)date[2]));
                        reservationMapper.updateP(reservationId,paymentMapper.getPayments(reservationId));
                        reservationMapper.checkPaid(reservationId);}
                        else {System.out.println("Data finala depasita!");}
                    }
                    else {
                       // paymentMapper.update(date,reservationId,clientId);
                    }

                }catch(Exception e){
                    paymentView.printMessage("Datele nu sunt valide!");
                    e.printStackTrace();
                }
            }
        };
        paymentView.addListenerAddB(addButtonL);
    }


    private void addListenerNewB(){

        ActionListener ButtonL = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    paymentView.addNewRow();
                }catch(Exception e){
                    paymentView.printMessage("Nu am putut adauga un rand nou!");
                    e.printStackTrace();
                }
            }
        };
        paymentView.addListenerNewRB(ButtonL);
    }




    private void ListPayment(){
        PaymentMapper paymentMapper = new PaymentMapper();
        List<Payment> paymentList = paymentMapper.findAll(reservationId);

        for(Iterator<Payment> i = paymentList.iterator(); i.hasNext();){
            Payment payment=i.next();
            Vector paymentV = new Vector();

            paymentV.add(payment.getIdPayment());
            paymentV.add(String.valueOf(payment.getPayment()));
            paymentV.add(String.valueOf(payment.getDate()));

            paymentView.addPayment(paymentV);
        }
    }

}
