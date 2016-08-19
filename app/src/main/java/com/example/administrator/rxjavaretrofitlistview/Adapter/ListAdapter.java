package com.example.administrator.rxjavaretrofitlistview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.rxjavaretrofitlistview.R;
import com.example.administrator.rxjavaretrofitlistview.bean.LuKouBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/19.
 */
public class ListAdapter extends BaseAdapter {
    private LuKouBean luKouBean;
    private Context context;
    private ArrayList<LuKouBean.DataBean.AlbumsBean.ListBean.AuthorBean> authors;

    public ListAdapter(Context context)
    {
        this.context = context;
        this.luKouBean = luKouBean;
        authors = new ArrayList<>();
    }

    public void setLuKouBean(LuKouBean luKouBean) {
        this.luKouBean = luKouBean;
        //获取数据
        for(int i=0;i<luKouBean.getData().getAlbums().getList().size();i++)
        {
            authors.add(luKouBean.getData().getAlbums().getList().get(i).getAuthor());
        }
    }

    @Override
    public int getCount() {
        return authors.size();
    }

    @Override
    public Object getItem(int position) {
        return authors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(null == convertView)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_items_view,null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView)convertView.findViewById(R.id.imageView);
            viewHolder.textViewl = (TextView)convertView.findViewById(R.id.textView);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder)convertView.getTag();

        viewHolder.textViewl.setText(authors.get(position).getName());
        Glide.with(context).load(authors.get(position).getAvatar()).into(viewHolder.imageView);

        return convertView;
    }
    class ViewHolder
    {
        ImageView imageView;
        TextView textViewl;
    }
}
