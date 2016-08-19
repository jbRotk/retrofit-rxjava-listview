package com.example.administrator.rxjavaretrofitlistview.API;

import com.example.administrator.rxjavaretrofitlistview.bean.LuKouBean;

import java.util.Map;


import retrofit.http.GET;
import retrofit.http.QueryMap;
import rx.Observable;

/**
 * Created by Administrator on 2016/8/19.
 */
public interface LuKouAPI {
    @GET("api/albums")
    Observable<LuKouBean> getFeed(@QueryMap Map<String,String> map);
}
