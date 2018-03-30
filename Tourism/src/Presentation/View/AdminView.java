package Presentation.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AdminView {

    private JFrame jframe;
    private JPanel jpanel;
    private JTable tableUser;
    private DefaultTableModel modelUser;
    private JButton addButton;
    private JButton deleteButton;
    private JButton newRowButton;
    private JScrollPane listUser;
    private JButton reportButton;
    private int rowNr = 0;
    private JTextField firstDateTf;
    private JTextField secondDateTf;
    private JLabel firstDateL;
    private JLabel secondDateL;


    public AdminView() {
        jframe = new JFrame();
        jpanel = new JPanel();
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        newRowButton = new JButton("New Row");
        reportButton = new JButton("Report");
        tableUser = new JTable();
        listUser = new JScrollPane(tableUser);
        firstDateTf = new JTextField(10);
        secondDateTf = new JTextField(10);
        firstDateL = new JLabel("Start date");
        secondDateL = new JLabel("End date");
        init();
    }

    private void init() {
        initTable();
        jpanel.add(listUser);
        jframe.setContentPane(jpanel);
        jpanel.add(firstDateL);
        jpanel.add(firstDateTf);
        jpanel.add(secondDateL);
        jpanel.add(secondDateTf);
        jpanel.add(reportButton);
        jpanel.add(addButton);
        jpanel.add(deleteButton);
        jpanel.add(newRowButton);
        jframe.setLocation(600, 200);
        jframe.setSize(500, 600);
        //jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }

    private void initTable() {
        Vector<String> cols = new Vector();
        cols.add("Username");
        cols.add("Password");

        modelUser = new DefaultTableModel(null, cols);
        tableUser.setModel(modelUser);
    }

    public Object[] getUser() {

        int id = tableUser.getSelectedRow();
        Object[] result = new Object[4];

        result[0] = tableUser.getModel().getValueAt(id, 0);
        result[1] = tableUser.getModel().getValueAt(id, 1);
        result[2] = rowNr;
        result[3] = id;
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

    public void addUser(Vector user) {
        modelUser.addRow(user);
        rowNr++;
    }

    public void addNewRow() {
        modelUser.addRow(new Object[]{});
    }

    public void removeRow() {
        modelUser.removeRow(tableUser.getSelectedRow());
    }

    public void addListenerInfoB(ActionListener buttonL) {
        reportButton.addActionListener(buttonL);
    }

    public String[] getDates() {

        return new String[]{firstDateTf.getText(), secondDateTf.getText()};

    }

}
