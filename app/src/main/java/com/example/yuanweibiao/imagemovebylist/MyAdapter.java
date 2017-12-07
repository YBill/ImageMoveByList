package com.example.yuanweibiao.imagemovebylist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuanweibiao on 2017/12/7.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ID_1 = 1001;
    private static final int ID_2 = 1002;

    private Context context;
    private List<MyBean> list = new ArrayList<>();

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<MyBean> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (TextUtils.isEmpty(list.get(position).url)) {
            return ID_1;
        } else
            return ID_2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ID_1) {
            View view = LayoutInflater.from(context).inflate(R.layout.adapter_text, parent, false);
            return new TextViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.adapter_image, parent, false);
            return new ImageViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TextViewHolder)
            ((TextViewHolder) holder).update(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TextViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public TextViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
        }

        private void update(int position) {
            MyBean bean = list.get(position);
            textView.setText(bean.text);

        }

    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        public ImageViewHolder(View itemView) {
            super(itemView);
        }
    }

}
