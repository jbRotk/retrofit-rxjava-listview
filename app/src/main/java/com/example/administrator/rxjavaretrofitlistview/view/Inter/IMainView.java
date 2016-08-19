package com.example.administrator.rxjavaretrofitlistview.view.Inter;

import android.widget.ListView;

import com.example.administrator.rxjavaretrofitlistview.Adapter.ListAdapter;
import com.example.administrator.rxjavaretrofitlistview.bean.LuKouBean;

/**
 * Created by Administrator on 2016/8/19.
 */
public interface IMainView {
    public void ShowMsg(String msg);
    public void HideMsg();
    public ListAdapter getListAdapter();
    public void AddData(ListView listView,ListAdapter listAdapter);
}
