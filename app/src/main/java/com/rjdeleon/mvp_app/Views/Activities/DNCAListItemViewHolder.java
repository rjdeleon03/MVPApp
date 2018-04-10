package com.rjdeleon.mvp_app.Views.Activities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rjdeleon.mvp_app.Contracts.DNCAListItemContract;
import com.rjdeleon.mvp_app.R;

public class DNCAListItemViewHolder extends RecyclerView.ViewHolder implements DNCAListItemContract.View {


    private TextView textViewHead;
    private TextView textViewDesc;

    public DNCAListItemViewHolder(View itemView) {
        super(itemView);

        textViewHead = itemView.findViewById(R.id.textViewHead);
        textViewDesc = itemView.findViewById(R.id.textViewDesc);
    }

    @Override
    public void setHead(String head) {
        textViewHead.setText(head);
    }

    @Override
    public void setDesc(String desc) {
        textViewDesc.setText(desc);
    }
}
