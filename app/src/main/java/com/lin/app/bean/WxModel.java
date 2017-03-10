package com.lin.app.bean;

import com.lin.framework.bean.BaseModel;

import java.util.List;

/**
 * Created by linweilin on 2017/3/10.
 */

public class WxModel extends BaseModel {
    private Result result = null;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public class Result {
        private int totalPage = -1;
        private int ps = -1;
        private int pno = -1;
        private List<WxItemModel> list = null;

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getPs() {
            return ps;
        }

        public void setPs(int ps) {
            this.ps = ps;
        }

        public int getPno() {
            return pno;
        }

        public void setPno(int pno) {
            this.pno = pno;
        }

        public List<WxItemModel> getList() {
            return list;
        }

        public void setList(List<WxItemModel> list) {
            this.list = list;
        }
    }
}
