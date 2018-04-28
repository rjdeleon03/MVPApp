package com.rjdeleon.mvp_app.Views.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rjdeleon.mvp_app.Contracts.DNCAListItemContract;
import com.rjdeleon.mvp_app.Presenters.DNCAListItemPresenter;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.DncaListItemBinding;

public class DNCAListItemViewHolder extends RecyclerView.ViewHolder implements DNCAListItemContract.View {

    private TextView textViewHead;
    private TextView textViewDesc;
    private final DncaListItemBinding binding;

    public DNCAListItemViewHolder(DncaListItemBinding binding) {
        super(binding.getRoot());
        this.textViewHead = itemView.findViewById(R.id.dnca_item_head);
        this.textViewDesc = itemView.findViewById(R.id.dnca_item_desc);
        this.binding = binding;
    }

    @Override
    public void setHead(String head) {
        textViewHead.setText(head);
    }

    @Override
    public void setDesc(String desc) {
        textViewDesc.setText(desc);
    }

    @Override
    public void bind(DNCAListItemContract.Presenter presenter) {
        binding.setPresenter((DNCAListItemPresenter) presenter);
    }

    @Override
    public void onDownloadDnca(String url) {
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        itemView.getContext().startActivity(pdfIntent);
    }
}
