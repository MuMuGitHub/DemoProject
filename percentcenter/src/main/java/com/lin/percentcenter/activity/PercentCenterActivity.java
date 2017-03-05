package com.lin.percentcenter.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.lin.framework.activity.BaseActivity;
import com.lin.percentcenter.R;
import com.lin.percentcenter.presenter.UserPresenter;
import com.lin.percentcenter.view.IUserView;


public class PercentCenterActivity extends BaseActivity implements View.OnClickListener,IUserView {

    UserPresenter presenter;
    EditText et_name,et_sex,et_id;
    @Override
    protected int getContentViewId() {
        return R.layout.activity_percent_center;
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        et_name = (EditText) findViewById(R.id.name);
        et_sex = (EditText) findViewById(R.id.sex);
        et_id = (EditText) findViewById(R.id.et_id);
        presenter = new UserPresenter(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button){
            presenter.saveUser(getID(),getSex(),getName());
        }else {
            presenter.loadUser(getID());
        }
    }

    @Override
    public void setID(String id) {
        et_id.setText(id);
    }

    @Override
    public void setName(String name) {
        et_name.setText(name);
    }

    @Override
    public void setSex(String sex) {
        et_sex.setText(sex);
    }

    @Override
    public String getID() {
        return et_id.getText().toString();
    }

    @Override
    public String getName() {
        return et_name.getText().toString();

    }

    @Override
    public String getSex() {
        return et_sex.getText().toString();
    }
}
