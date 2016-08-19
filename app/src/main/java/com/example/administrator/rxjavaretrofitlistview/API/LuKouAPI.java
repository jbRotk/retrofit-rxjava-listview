package com.example.administrator.rxjavaretrofitlistview.API;

import com.example.administrator.rxjavaretrofitlistview.bean.LuKouBean;

import java.util.Map;


import retrofit.http.GET;
import retrofit.http.QueryMap;
import rx.Observable;

/**
 * Created by Administrator on 2016/8/19.
 */

/*
* 这里的URL地址为：http://www.lukou.com/api/albums?album_tag=0&start=
 */
public interface LuKouAPI {
    @GET("api/albums")
    Observable<LuKouBean> getFeed(@QueryMap Map<String,String> map);
}
