package com.example.bhargaviy.samplerecycleapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GetTiltleLableInterface.lableList {
    private RecyclerView mLableRv;
    private Context mContext;
    private LinearLayoutManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        mLableRv = (RecyclerView) findViewById(R.id.entry_rv);
        AppControler.getInstance().setTitleLable(this);
        GetTiltleLableInterface.titleLables();
    }

    @Override
    public void listOfLables(String result, ArrayList<String> lables) {
        if (result.equals(Constant.SUCCESS)) {
            TitleAdapter titleAdapter = new TitleAdapter(lables, mContext);
            mLableRv.setLayoutManager(mManager);
            mLableRv.setAdapter(titleAdapter);
        } else {
            Toast.makeText(mContext, "Pleae try agian after sometime.", Toast.LENGTH_SHORT).show();
        }
    }
}
