package Presentation.Controller;

import Presentation.View.UserInfoView;
import domainLayer.Mapper.UserInfoMapper;
import domainLayer.Model.UserInfo;

import java.util.List;
import java.util.Vector;

class UserInfoController {

    private UserInfoView userInfoView = new UserInfoView();
    private String username;

    UserInfoController(String username, String[] dates) {
        this.username = username;
        ListInfo(dates);

    }

    private void ListInfo(String[] dates) {
        UserInfoMapper userInfoMapper = new UserInfoMapper(username);
        List<UserInfo> userList = userInfoMapper.findAll(dates);

        for (UserInfo user : userList) {
            Vector userV = new Vector();

            userV.add(user.getUsername());
            userV.add(user.getInfo());
            userV.add(user.getDate());

            userInfoView.addUser(userV);
        }
    }
}

