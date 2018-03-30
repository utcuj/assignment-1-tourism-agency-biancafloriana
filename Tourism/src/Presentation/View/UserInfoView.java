package Presentation.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class UserInfoView {

    private JFrame jframe;
    private JPanel jpanel;
    private JTable tableInfo;
    private DefaultTableModel modelInfo;
    private JScrollPane listInfo;


    public UserInfoView() {
        jframe = new JFrame();
        jpanel = new JPanel();

        tableInfo = new JTable();
        listInfo = new JScrollPane(tableInfo);
        init();

    }

    private void init() {
        initTable();

        jpanel.add(listInfo);
        jframe.setContentPane(jpanel);
        jframe.setLocation(600, 200);
        jframe.setSize(500, 600);
        //jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.setVisible(true);

    }

    private void initTable() {
        Vector<String> cols = new Vector();
        cols.add("username");
        cols.add("info");
        cols.add("date");

        modelInfo = new DefaultTableModel(null, cols) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableInfo.setModel(modelInfo);
    }

    public void printMessage(String s) {
        System.out.println(s);
    }

    public void addUser(Vector user) {
        modelInfo.addRow(user);
    }

}
