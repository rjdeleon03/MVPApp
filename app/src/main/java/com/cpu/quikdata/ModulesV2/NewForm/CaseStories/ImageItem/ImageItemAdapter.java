package com.cpu.quikdata.ModulesV2.NewForm.CaseStories.ImageItem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModulesV2.NewForm.CaseStories.ICameraSourceViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.CaseStories.ICaseStoriesFragment;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;
import com.cpu.quikdata.R;

public class ImageItemAdapter extends RecyclerView.Adapter<ImageItemViewHolder> {

    private INewFormActivity mViewComponent;
    private ICameraSourceViewModel mDataManager;

    public ImageItemAdapter(INewFormActivity viewComponent, ICameraSourceViewModel dataManager) {
        mViewComponent = viewComponent;
        mDataManager = dataManager;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public ImageItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.template_image_item, parent, false);
        return new ImageItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageItemViewHolder holder, int position) {
        ImageItemViewModel itemViewModel = new ImageItemViewModel(null, position);
        itemViewModel.setDataManager(mDataManager);
        itemViewModel.setViewComponent(mViewComponent);
        holder.setViewModel(itemViewModel);
    }

    @Override
    public int getItemCount() {
        return mDataManager.getImageItemsCount();
    }
}
