package com.lin.percentcenter.presenter;

import com.lin.percentcenter.bean.UserInfo;
import com.lin.percentcenter.model.IUserModel;
import com.lin.percentcenter.model.UserModel;
import com.lin.percentcenter.view.IUserView;

/**
 * Created by lin on 2017/2/26.
 */

public class UserPresenter {

    private IUserView mUserView;
    private IUserModel mUserModel;

    public UserPresenter(IUserView mUserView) {
        this.mUserView = mUserView;
        mUserModel = new UserModel();
    }

    public void saveUser(String id,String sex,String name){
        mUserModel.setID(id);
        mUserModel.setName(name);
        mUserModel.setSex(sex);
    }

    public void loadUser(String id){
        UserInfo userInfo = mUserModel.load(id);
        mUserView.setName(userInfo.getName());
        mUserView.setSex(userInfo.getSex());
    }
}
