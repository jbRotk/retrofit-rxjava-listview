package com.example.administrator.rxjavaretrofitlistview.presenter;

import android.os.SystemClock;

import com.example.administrator.rxjavaretrofitlistview.API.Callback;
import com.example.administrator.rxjavaretrofitlistview.bean.LuKouBean;
import com.example.administrator.rxjavaretrofitlistview.model.LuKouModel;
import com.example.administrator.rxjavaretrofitlistview.view.Inter.IMainView;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/8/19.
 */
public class LuKouPresenter {
    LuKouModel luKouModel;
    IMainView iMainView;
    LuKouBean luKouBean;
    public LuKouPresenter(IMainView iMainView)
    {
        this.iMainView = iMainView;
        luKouModel = new LuKouModel();
    }

    public LuKouBean getData()
    {
        luKouModel.getData(new Callback<LuKouBean>() {
            @Override
            public void onSccuss(LuKouBean data) {
                iMainView.ShowMsg("获取数据成功...");
                iMainView.getListAdapter().setLuKouBean(data);
                iMainView.getListAdapter().notifyDataSetChanged();
            }

            @Override
            public void onLoading() {
                iMainView.ShowMsg("正在加载中...");
            }

            @Override
            public void onFaild() {
                iMainView.ShowMsg("加载失败了...");
            }
        })
                .subscribeOn(Schedulers.io())// 在非UI线程中执行getUser
                .observeOn(AndroidSchedulers.mainThread())// 在UI线程中执行结果
                .subscribe();
        return luKouBean;

    }
}
