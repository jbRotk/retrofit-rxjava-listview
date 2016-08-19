package com.example.administrator.rxjavaretrofitlistview.API;

public interface Callback<T> {
    public void onSccuss(T data);
    public void onLoading();
    public void onFaild();
}