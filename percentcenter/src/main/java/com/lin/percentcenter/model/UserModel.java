package com.lin.percentcenter.model;

import com.lin.percentcenter.bean.UserInfo;

/**
 * Created by lin on 2017/2/26.
 */

public class UserModel implements IUserModel {
    private UserInfo userInfo;
    @Override
    public void setID(String id) {
        if (userInfo == null)
            userInfo = new UserInfo();
        userInfo.setId(id);
    }

    @Override
    public void setName(String name) {
        if (userInfo == null)
            userInfo = new UserInfo();
        userInfo.setName(name);
    }

    @Override
    public void setSex(String sex) {

        if (userInfo == null)
            userInfo = new UserInfo();
        userInfo.setSex(sex);
    }

    @Override
    public UserInfo load(String id) {
        if (userInfo.getId().equals(id)){
            return userInfo;
        }
        return new UserInfo();
    }
}
