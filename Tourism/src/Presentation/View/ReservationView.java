package Presentation.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ReservationView {
    private JFrame jframe;
    private JPanel jpanel;
    private JTable tableReservation;
    private DefaultTableModel modelReservation;
    private JButton addButton;
    private JButton deleteButton;
    private JButton newRowButton;
    private JScrollPane listReservation;
    private JButton personButton;
    private JButton paymentButton;

    public ReservationView() {
        jframe = new JFrame();
        jpanel = new JPanel();
        addButton = new JButton("Add/Update");
        deleteButton = new JButton("Delete");
        newRowButton = new JButton("New Row");
        tableReservation = new JTable();
        listReservation = new JScrollPane(tableReservation);
        personButton = new JButton("Persons");
        paymentButton = new JButton("Payments");
        init();
    }

    private void init() {
        initTable();

        jpanel.add(listReservation);
        jframe.setContentPane(jpanel);
        jpanel.add(addButton);
        jpanel.add(deleteButton);
        jpanel.add(newRowButton);
        jpanel.add(personButton);
        jpanel.add(paymentButton);
        jframe.setLocation(600, 200);
        jframe.setSize(600, 600);
       // jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.setVisible(true);

    }

    private void initTable() {
        Vector<String> cols = new Vector();
        cols.add("Id");
        cols.add("Destination");
        cols.add("Hotel");
        cols.add("PersonsNumber");
        cols.add("Price");
        cols.add("Final date");
        cols.add("partialPayment");
        cols.add("Paid");

        modelReservation = new DefaultTableModel(null,cols){
            public boolean isCellEditable(int row, int column)
            {
                return column != 0 && column != 6 && column != 7;
            }};
        tableReservation.setModel(modelReservation);
    }

    public Object[] getReservation() {

        int id = tableReservation.getSelectedRow();
        int colNumber = modelReservation.getColumnCount();
        Object[] result = new Object[colNumber];

        for (int i = 0; i < colNumber-2; i++) {
            result[i] = tableReservation.getModel().getValueAt(id, i);
        }
        result[6] = result[7] = 0;

        return result;
    }

    public void addListenerAddB(ActionListener ButtonL) {
        addButton.addActionListener(ButtonL);

    }

    public void addListenerDeleteB(ActionListener ButtonL) {
        deleteButton.addActionListener(ButtonL);

    }

    public void addListenerPersonsB(ActionListener ButtonL) {
        personButton.addActionListener(ButtonL);

    }
    public void addListenerPaymentB(ActionListener ButtonL) {
        paymentButton.addActionListener(ButtonL);

    }
    public void addListenerNewRB(ActionListener ButtonL) {
        newRowButton.addActionListener(ButtonL);

    }

    public void printMessage(String s) {
        System.out.println(s);
    }

    public void addReservation(Vector client) {
        modelReservation.addRow(client);
    }

    public void addNewRow(){
        modelReservation.addRow( new Object[]{});
    }

    public void removeRow() { modelReservation.removeRow( tableReservation.getSelectedRow());}

    public void UpdateId(int id) {
        modelReservation.setValueAt(id,tableReservation.getSelectedRow(),0);
    }
}
