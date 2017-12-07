package com.example.yuanweibiao.imagemovebylist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyAdapter adapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private List<MyBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();

        adapter = new MyAdapter(this);
        adapter.setList(list);
        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(linearLayoutManager = new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int fPos = linearLayoutManager.findFirstVisibleItemPosition();
                int lPos = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                for (int i = fPos; i <= lPos; i++) {
                    View view = linearLayoutManager.findViewByPosition(i);
                    MoveImageView adImageView = view.findViewById(R.id.image);
                    if (i == 6) {
                        adImageView.setDy(linearLayoutManager.getHeight() - view.getTop());
                    }
                }
            }
        });
    }

    private void getData() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MyBean bean = new MyBean();
            bean.text = "Hello World! " + (i + 1);
            if (i == 6)
                bean.url = "6";
            list.add(bean);
        }
    }

}
