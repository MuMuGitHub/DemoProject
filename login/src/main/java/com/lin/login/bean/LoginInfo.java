package com.lin.login.bean;

import com.lin.framework.bean.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linweilin on 2017/2/28.
 */

public class LoginInfo {
    private String sessionId;
    private List<UserInfo> userInfos;
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public LoginInfo(String sessionId) {
        this.sessionId = sessionId;
        userInfos = new ArrayList<>();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(sessionId);
        userInfos.add(userInfo);
    }

    public List<UserInfo> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }
}
