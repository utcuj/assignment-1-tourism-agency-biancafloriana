package Presentation.Controller;

import Presentation.View.AdminView;
import domainLayer.Mapper.UserMapper;
import domainLayer.Model.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class AdminController {

    private AdminView adminView;

    AdminController() {
        adminView = new AdminView();
        ListUser();
        addListenerAddB();
        addListenerNewB();
        addListenerDeleteB();
        addListenerInfoB();


    }

    private void addListenerAddB() {

        ActionListener addButtonL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Object[] date = adminView.getUser();
                    UserMapper userMapper = new UserMapper();
                    if (date[0] != null) {
                        if (userMapper.findById(date[0]) == null) {
                            // System.out.println(date[3] + " " + date[2]);
                            if ((int) date[3] >= (int) date[2]) {
                                userMapper.insert(date);
                            } else {
                                adminView.printMessage("Username-ul nu poate fi modificat!");
                            }
                        } else {
                            userMapper.update(date);
                        }
                    }
                } catch (Exception e) {
                    adminView.printMessage("Datele nu sunt valide!");
                    // e.printStackTrace();
                }
            }
        };
        adminView.addListenerAddB(addButtonL);
    }


    private void addListenerNewB() {

        ActionListener ButtonL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    adminView.addNewRow();
                } catch (Exception e) {
                    adminView.printMessage("Nu am putut adauga un rand nou in tabel!");
                    // e.printStackTrace();
                }
            }
        };

        adminView.addListenerNewRB(ButtonL);
    }

    private void addListenerDeleteB() {

        ActionListener ButtonL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Object[] date = adminView.getUser();
                    UserMapper userMapper = new UserMapper();
                    if (date != null) {
                        userMapper.delete((String) date[0]);
                        adminView.removeRow();
                    }
                } catch (Exception e) {
                    adminView.printMessage("Nu s-a putut face sterggerea!");

                }
            }
        };
        adminView.addListenerDeleteB(ButtonL);
    }


    private void ListUser() {
        UserMapper userMapper = new UserMapper();
        List<User> userList = userMapper.findAll();

        for (User user : userList) {
            Vector userV = new Vector();

            userV.add(user.getUsername());
            userV.add(user.getPassword());

            adminView.addUser(userV);
        }
    }


    private void addListenerInfoB() {
        ActionListener ButtonL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Object[] date = adminView.getUser();
                    String[] dates = adminView.getDates();
                    // UserInfoController userController =
                    new UserInfoController((String) date[0], dates);
                } catch (Exception e) {
                    adminView.printMessage("Nu s-a putut efectua raportul!");
                    //e.printStackTrace();
                }
            }
        };
        adminView.addListenerInfoB(ButtonL);

    }

}


