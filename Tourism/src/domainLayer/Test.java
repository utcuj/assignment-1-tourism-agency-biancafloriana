package domainLayer;

import domainLayer.Mapper.*;

public class Test {


    public static void main(String args[]) {
        /*ClientMapper clientMapper = new ClientMapper();
         clientMapper.insert(new Client("Vasile","Ion",26,"aer 345","12345678912","1734567890123"));

        List clientList = clientMapper.findAll();
        for (Object i : clientList) {
            System.out.println(((Client) i).toString());
        }
        System.out.println(clientMapper.findbyId(6));
        */

        /*PersonMapper personMapper = new PersonMapper();
        personMapper.insert(new Person("Vasile", "Maria", 24, "1234"));
        //personMapper.update( new Person(1,"Vasile","Mihai",24,"1234"));
        //personMapper.delete(new Person(1, "Vasile", "Mihai", 24, "1234"));
        List personList = personMapper.findAll();
        for (Object i : personList) {
            System.out.println(((Person) i).toString());
        }
        System.out.println(personMapper.findById(3));
        */

       /* ReservationMapper reservationMapper = new ReservationMapper();

        reservationMapper.insert(new Reservation(8, "Cipru","Iosifi",3, 134, Date.valueOf("2018-12-3"),100,0));
        //reservationMapper.update(new Reservation(1,7, "Malta","Iosi",4, 1234, Date.valueOf("2018-12-3"),100,0));
        //reservationMapper.delete(new Reservation(1,7, "Malta","Iosi",4, 1234, Date.valueOf("2018-12-3"),100,0));
        List personList = reservationMapper.findAll();
        for (Object i : personList) {
            System.out.println(((Reservation) i).toString());
        }
        System.out.println(reservationMapper.findById(2));*/

        PaymentMapper paymentMapper = new PaymentMapper();

        //paymentMapper.insert(new Payment(8,2, 100,Date.valueOf("2018-3-3")));
       //paymentMapper.update(new Payment(2,8,2, 1000,Date.valueOf("2018-3-3")));
        //paymentMapper.delete(new Payment(2,8,2, 1000,Date.valueOf("2018-3-3")));
        /*List paymentList = paymentMapper.findAll(3);
        for (Object i : paymentList) {
            System.out.println(((Payment) i).toString());
        }
        System.out.println(paymentMapper.findById(1));


       /*  ReservationPersonsMapper reservationPersonsMapper = new ReservationPersonsMapper();

       // reservationPersonsMapper.insert(new ReservationPersons(2,3));
       // reservationPersonsMapper.update((new ReservationPersons(7,3,1)));
        reservationPersonsMapper.delete(new ReservationPersons(7,3,1));
        List paymentList = reservationPersonsMapper.findAll();
        for (Object i : paymentList) {
            System.out.println(((ReservationPersons) i).toString());
        }
        System.out.println(reservationPersonsMapper.findById(5));
        */


    }
}
