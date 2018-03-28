package Presentation;

import domainLayer.Mapper.ClientMapper;
import domainLayer.Mapper.UserMapper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

    private LoginView loginView = new LoginView();

    LoginController(){

        loginView.init();
        addListener();
    }

    private void addListener(){

        ActionListener ButtonL = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    Object[] date = loginView.getInfo();
                     UserMapper userMapper = new UserMapper();
                     int ok = userMapper.check(date);

                     if(ok == 1){
                         AgentController agentController = new AgentController();
                     } else if ( ok == 2) {}
                     else {System.out.println("Uername/Password wrong!");}
                }catch(Exception e){
                   System.out.println("Nu s-a putut efectua logarea!");
                    e.printStackTrace();
                }
            }
        };
        loginView.addListener(ButtonL);
    }
    public static void  main(String[] args){

        LoginController loginController = new LoginController();

    }

}
