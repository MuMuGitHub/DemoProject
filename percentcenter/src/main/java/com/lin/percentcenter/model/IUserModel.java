package com.lin.percentcenter.model;


import com.lin.percentcenter.bean.UserInfo;

/**
 * Created by lin on 2017/2/26.
 */

public interface IUserModel {
    void setID(String id);
    void setName(String name);
    void setSex(String sex);
    UserInfo load(String id);

}
