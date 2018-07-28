package com.example.bhargaviy.samplerecycleapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bhargavi Y on 7/28/2018.
 */

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.ViewHolder> {
    private ArrayList<String> lableLs = new ArrayList<>();
    private Context mContext;

    public TitleAdapter(ArrayList<String> lableLs, Context mContext) {
        this.lableLs = lableLs;
        this.mContext = mContext;
    }

    @Override
    public TitleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.title_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TitleAdapter.ViewHolder holder, int position) {
        holder.lableTxt.setText(lableLs.get(position));
    }

    @Override
    public int getItemCount() {
        return lableLs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        TextView lableTxt = (TextView) itemView.findViewById(R.id.title_lable);
    }
}
