package Presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AgentView {

    private JFrame jframe;
    private JPanel jpanel;
    private JTable tableClient;
    private DefaultTableModel modelClient;
    private JButton addButton;
    private JButton updateButton;
    private JButton newRowButton;
    private JScrollPane listClient;


    AgentView() {
        jframe = new JFrame();
        jpanel = new JPanel();
        addButton = new JButton("Add");
        updateButton = new JButton("New Row");
        newRowButton = new JButton("Update");
        tableClient = new JTable();
        listClient = new JScrollPane(tableClient);

    }

    public void init() {
        initTable();

        jpanel.add(listClient);
        jframe.setContentPane(jpanel);
        jpanel.add(addButton);
        jpanel.add(updateButton);
        jpanel.add(newRowButton);
        jframe.setLocation(600, 200);
        jframe.setSize(600, 600);
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
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
                if(column==0)return false;
                return true;
            }};
        tableClient.setModel(modelClient);
    }

    public Object[] getClient() {

        int id = tableClient.getSelectedRow();
        int colNumber = modelClient.getColumnCount();
        Object[] result = new Object[colNumber];

        for (int i = 0; i < colNumber; i++) {
            result[i] = tableClient.getModel().getValueAt(id, i);
        }
        return result;
    }

    public void addListenerAddB(ActionListener ButtonL) {
        addButton.addActionListener(ButtonL);

    }

    public void addListenerUpdateB(ActionListener ButtonL) {
        updateButton.addActionListener(ButtonL);

    }

    public void addListenerNewRB(ActionListener ButtonL) {
        newRowButton.addActionListener(ButtonL);

    }

    public void printMessage(String s) {
        System.out.println(s);
    }

    public void addClient(Vector client) {
        modelClient.addRow(client);
    }

    public void addNewRow(){
        modelClient.addRow( new Object[]{});
    }
}
