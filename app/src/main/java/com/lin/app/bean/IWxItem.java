package com.lin.app.bean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by lin on 2017/3/22.
 */

public interface IWxItem {
    @GET("items")
    Call<List<WxItemModel>> getItems();
}
