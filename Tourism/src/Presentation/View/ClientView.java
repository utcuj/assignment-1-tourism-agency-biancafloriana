package Presentation.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class ClientView {
    private JFrame jframe;
    private JPanel jpanel;
    private JTable tableClient;
    private DefaultTableModel modelClient;
    private JScrollPane listClient;


    public ClientView() {
        jframe = new JFrame();
        jpanel = new JPanel();
        tableClient = new JTable();
        listClient = new JScrollPane(tableClient);
        init();
    }

    private void init() {
        initTable();

        jpanel.add(listClient);
        jframe.setContentPane(jpanel);
        jframe.setLocation(600, 200);
        jframe.setSize(500, 600);
        // jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.setVisible(true);

    }

    private void initTable() {
        Vector<String> cols = new Vector();
        cols.add("Id");
        cols.add("Fist Name");
        cols.add("Last Name");
        cols.add("Age");
        cols.add("Adress");
        cols.add("CNP");
        cols.add("CARD");


        modelClient = new DefaultTableModel(null,cols){
            public boolean isCellEditable(int row, int column)
            {
                return false;

            }};
        tableClient.setModel(modelClient);
    }



    public void printMessage(String s) {
        System.out.println(s);
    }

    public void addClient(Vector client) {
        modelClient.addRow(client);
    }
}
