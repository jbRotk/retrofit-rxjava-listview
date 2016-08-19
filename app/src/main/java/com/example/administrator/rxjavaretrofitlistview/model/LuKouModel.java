package com.example.administrator.rxjavaretrofitlistview.model;

import android.content.Context;

import com.example.administrator.rxjavaretrofitlistview.API.Callback;
import com.example.administrator.rxjavaretrofitlistview.API.LuKouAPI;
import com.example.administrator.rxjavaretrofitlistview.bean.LuKouBean;

import java.util.HashMap;
import java.util.Map;


import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/8/19.
 */
public class LuKouModel {
    public Observable<LuKouBean> getData( final Callback<LuKouBean> mCallback)
    {
        return  Observable.create(new Observable.OnSubscribe<LuKouBean>() {
            @Override
            public void call(Subscriber<? super LuKouBean> subscriber) {
                //获取数据
                Map<String, String> map = new HashMap<String, String>();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://www.lukou.com/")
                        .addConverterFactory(GsonConverterFactory.create())//添加 json 转换器
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//添加 RxJava 适配器
                        .build();
                LuKouAPI luKouAPI = retrofit.create(LuKouAPI.class);
                map.put("album_tag", "0");
                map.put("start", " ");
                luKouAPI.getFeed(map)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<LuKouBean>() {
                            @Override
                            public void onCompleted() {
                                System.out.println("Complete");
                            }

                            @Override
                            public void onError(Throwable e) {
                                System.out.println(e.getMessage());
                            }

                            @Override
                            public void onNext(LuKouBean contributors) {
                                mCallback.onSccuss(contributors);
                            }
                        });
            }
        });
    }
}
