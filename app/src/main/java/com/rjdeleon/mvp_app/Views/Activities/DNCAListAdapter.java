package com.rjdeleon.mvp_app.Views.Activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rjdeleon.mvp_app.Models.DNCAListItem;
import com.rjdeleon.mvp_app.R;

import java.util.List;

public class DNCAListAdapter extends RecyclerView.Adapter<DNCAListAdapter.ViewHolder>{

    private List<DNCAListItem> listItems;
    private Context context;

    public DNCAListAdapter(List<DNCAListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dnca_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DNCAListItem listItem = listItems.get(position);

        holder.textViewHead.setText(listItem.getBrgyName());
        holder.textViewDesc.setText(listItem.getAreaName());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewHead;
        private TextView textViewDesc;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = itemView.findViewById(R.id.textViewHead);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);
        }
    }
}
