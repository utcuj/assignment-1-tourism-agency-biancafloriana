package Presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

public class PaymentView {
    private JFrame jframe;
    private JPanel jpanel;
    private JTable tablePayment;
    private DefaultTableModel modelPayment;
    private JButton addButton;
    private JButton deleteButton;
    private JButton newRowButton;
    private JScrollPane listPayment;


    PaymentView() {
        jframe = new JFrame();
        jpanel = new JPanel();
        addButton = new JButton("Add");
        //deleteButton = new JButton("Delete");
        newRowButton = new JButton("New Row");
        tablePayment = new JTable();
        listPayment = new JScrollPane(tablePayment);

    }

    public void init() {
        initTable();

        jpanel.add(listPayment);
        jframe.setContentPane(jpanel);
        jpanel.add(addButton);
        //jpanel.add(deleteButton);
        jpanel.add(newRowButton);
        jframe.setLocation(600, 200);
        jframe.setSize(600, 600);
        // jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.setVisible(true);

    }

    private void initTable() {
        Vector<String> cols = new Vector();
        cols.add("Id");
        cols.add("payment");
        cols.add("date");


        modelPayment = new DefaultTableModel(null,cols){
            public boolean isCellEditable(int row, int column)
            {
                if(column==0 || column == 2)return false;
                return true;
            }};
        tablePayment.setModel(modelPayment);
    }

    public Object[] getPayment() {

        int id = tablePayment.getSelectedRow();
        int colNumber = modelPayment.getColumnCount();
        Object[] result = new Object[colNumber];

        for (int i = 0; i < colNumber-1; i++) {
            result[i] = tablePayment.getModel().getValueAt(id, i);
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        result[2] = dtf.format(localDate);
        return result;
    }

    public void addListenerAddB(ActionListener ButtonL) {
        addButton.addActionListener(ButtonL);

    }

    public void addListenerDeleteB(ActionListener ButtonL) {
        deleteButton.addActionListener(ButtonL);

    }

    public void addListenerNewRB(ActionListener ButtonL) {
        newRowButton.addActionListener(ButtonL);

    }

    public void printMessage(String s) {
        System.out.println(s);
    }

    public void addPayment(Vector client) {
        modelPayment.addRow(client);
    }

    public void addNewRow(){
        modelPayment.addRow( new Object[]{});
    }

    public void removeRow() { modelPayment.removeRow( tablePayment.getSelectedRow());}

    public void UpdateId(int id, Date date) {
        modelPayment.setValueAt(id,tablePayment.getSelectedRow(),0);
        modelPayment.setValueAt(date,tablePayment.getSelectedRow(),2);
    }
}
