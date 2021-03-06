package Presentation.View;
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
    private JButton deleteButton;
    private JButton newRowButton;
    private JScrollPane listClient;
    private JButton rezButton;
    private  JButton passedButton;


    public AgentView() {
        jframe = new JFrame();
        jpanel = new JPanel();
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        newRowButton = new JButton("New Row");
        passedButton = new JButton("Passed date");
        tableClient = new JTable();
        listClient = new JScrollPane(tableClient);
        rezButton = new JButton("Reservations");
        init();
    }

    private void init() {
        initTable();

        jpanel.add(listClient);
        jframe.setContentPane(jpanel);
        jpanel.add(addButton);
        jpanel.add(deleteButton);
        jpanel.add(newRowButton);
        jpanel.add(rezButton);
        jpanel.add(passedButton);
        jframe.setLocation(600, 200);
        jframe.setSize(500, 600);
        //jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
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
                return column != 0;
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

    public void addListenerDeleteB(ActionListener ButtonL) {
        deleteButton.addActionListener(ButtonL);

    }

    public void addListenerNewRB(ActionListener ButtonL) {
        newRowButton.addActionListener(ButtonL);

    }
    public void addListenerRezB(ActionListener ButtonL) {
        rezButton.addActionListener(ButtonL);

    }

    public void addListenerPassedB(ActionListener ButtonL) {
        passedButton.addActionListener(ButtonL);

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

    public void removeRow() { modelClient.removeRow( tableClient.getSelectedRow());}

    public void UpdateId(int id) {
        modelClient.setValueAt(id,tableClient.getSelectedRow(),0);
    }
}
