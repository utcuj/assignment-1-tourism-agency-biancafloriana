package Presentation;

import domainLayer.Mapper.UserMapper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

    private LoginView loginView ;

    private LoginController() {
        loginView = new LoginView();
        addListener();
    }

    private void addListener() {

        ActionListener ButtonL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Object[] date = loginView.getInfo();
                    UserMapper userMapper = new UserMapper();
                    int ok = userMapper.check(date);

                    if (ok == 1) {
                       // AgentController agentController =
                        new AgentController((String) date[0]);
                    } else if (ok == 2) {
                        //AdminController adminController =
                        new AdminController();
                    } else {
                        System.out.println("Uername/Password wrong!");
                    }
                } catch (Exception e) {
                    System.out.println("Nu s-a putut efectua logarea!");
                }
            }
        };
        loginView.addListener(ButtonL);
    }

    public static void main(String[] args) {

        //LoginController loginController =
        new LoginController();

    }

}
