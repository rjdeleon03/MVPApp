package com.cpu.quikdata.ModulesV2.PrefilledData;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.QuestionModel;
import com.cpu.quikdata.R;

public class TemplateItemAdapter extends RecyclerView.Adapter<TemplateItemViewHolder> {

    private IPrefilledDataManager mIPrefilledDataManager;

    public TemplateItemAdapter(IPrefilledDataManager iPrefilledDataManager) {
        mIPrefilledDataManager = iPrefilledDataManager;
    }

    @NonNull
    @Override
    public TemplateItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.evacuation_list_item, parent, false);
        return new TemplateItemViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull TemplateItemViewHolder holder, int position) {
        QuestionModel model = mIPrefilledDataManager.getQuestions().get(position);
        holder.setViewModel(new DialogItemViewModelGenderTuple(model));
    }

    @Override
    public int getItemCount() {
        return mIPrefilledDataManager.getItemsCount();
    }

    public void updateData() {
        notifyDataSetChanged();
    }
}
