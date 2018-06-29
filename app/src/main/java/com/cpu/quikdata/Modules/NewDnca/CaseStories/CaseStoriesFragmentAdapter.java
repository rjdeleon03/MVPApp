package com.cpu.quikdata.Modules.NewDnca.CaseStories;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Modules.NewDnca.CaseStories.Image.CaseStoriesImageViewHolder;
import com.cpu.quikdata.Modules.NewDnca.CaseStories.Image.CaseStoriesImageViewModel;
import com.cpu.quikdata.databinding.CaseImageItemBinding;
import com.cpu.quikdata.R;

public class CaseStoriesFragmentAdapter extends RecyclerView.Adapter<CaseStoriesImageViewHolder> {

    private Context mContext;
    private CaseStoriesViewModel mViewModel;

    public CaseStoriesFragmentAdapter(Context context, CaseStoriesViewModel viewModel) {
        mContext = context;
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public CaseStoriesImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.case_image_item, parent, false);
        CaseImageItemBinding binding = CaseImageItemBinding.bind(root);
        return new CaseStoriesImageViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CaseStoriesImageViewHolder holder, int position) {
        CaseStoriesImageViewModel caseStoriesImageViewModel = new CaseStoriesImageViewModel(mViewModel, position);
        holder.bind(caseStoriesImageViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getImagePathsCount();
    }
}
