package com.example.yoga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class list1 extends AppCompatActivity implements ListAdapterClass.ListViewHolder.RecycleViewClickListener {
    ListAdapterClass listAdapterClass;
    ArrayList<ModelClass> mData;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1);

        recyclerView = findViewById(R.id.rv_list);
        getData();
        setDataAdapter();
    }

    private void setDataAdapter() {
        listAdapterClass=new ListAdapterClass(list1.this,mData,this::onClickListener);
        recyclerView.setAdapter(listAdapterClass);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getData() {
        mData = new ArrayList<>();
        mData.add(new ModelClass(R.drawable.beginner,"BEGINNER","START NOW"));
        mData.add(new ModelClass(R.drawable.inter,"INTERMEDIATE","START NOW"));
        mData.add(new ModelClass(R.drawable.advanced,"ADVANCED","START NOW"));
        mData.add(new ModelClass(R.drawable.weight,"WEIGHT LOSS","START NOW"));
        mData.add(new ModelClass(R.drawable.anx,"MEDITATIVE","START NOW"));
    }

    @Override
    public void onClickListener(int position) {
        String topic = mData.get(position).getTopic();
        Toast.makeText(list1.this,"hello this is "+topic ,Toast.LENGTH_SHORT).show();

    }
}