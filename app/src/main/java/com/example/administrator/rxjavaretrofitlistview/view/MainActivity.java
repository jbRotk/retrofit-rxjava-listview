package com.example.administrator.rxjavaretrofitlistview.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.administrator.rxjavaretrofitlistview.Adapter.ListAdapter;
import com.example.administrator.rxjavaretrofitlistview.R;
import com.example.administrator.rxjavaretrofitlistview.bean.LuKouBean;
import com.example.administrator.rxjavaretrofitlistview.presenter.LuKouPresenter;
import com.example.administrator.rxjavaretrofitlistview.view.Inter.IMainView;
import com.jakewharton.rxbinding.view.RxView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity implements IMainView{

    private ProgressDialog progressDialog;

    @InjectView(R.id.go)
    protected Button go;

    @InjectView(R.id.list)
    protected ListView list;
    private ListAdapter listAdapter;

    private LuKouPresenter luKouPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setClickListener();
    }

    private void init()
    {
        ButterKnife.inject(MainActivity.this);

        progressDialog = new ProgressDialog(MainActivity.this);

        luKouPresenter = new LuKouPresenter(MainActivity.this);
        listAdapter = new ListAdapter(MainActivity.this);
        list.setAdapter(listAdapter);
    }

    private void setClickListener()//设置监听
    {
        RxView.clicks(go)
                .subscribe(
                        new Action1<Void>() {
                            @Override
                            public void call(Void aVoid) {

                               // MainActivity.this.ShowMsg("加载开始");
                                luKouPresenter.getData();
                            }
                        }
                );//这里进行获取数据
    }

    @Override
    public void ShowMsg(String msg) {
        progressDialog.setMessage(msg);
        progressDialog.show();
    }

    @Override
    public void HideMsg() {
        progressDialog.hide();
    }


    @Override
    public void AddData(ListView listView, ListAdapter listAdapter) {

    }
    @Override
    public ListAdapter getListAdapter() {
        return listAdapter;
    }
    
}
