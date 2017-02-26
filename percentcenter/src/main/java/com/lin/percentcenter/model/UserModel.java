package com.lin.percentcenter.model;

import com.lin.percentcenter.bean.UserInfo;

/**
 * Created by lin on 2017/2/26.
 */

public class UserModel implements IUserModel {
    private UserInfo userInfo;
    @Override
    public void setID(String id) {
        userInfo.setId(id);
    }

    @Override
    public void setName(String name) {
        userInfo.setName(name);
    }

    @Override
    public void setSex(String sex) {
        userInfo.setSex(sex);
    }

    @Override
    public UserInfo load(String id) {
        if (userInfo.getId().equals(id)){
            return userInfo;
        }
        return null;
    }
}
