package com.cpu.quikdata.ModulesV2.PrefilledData;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModulesV2.PrefilledData.Models.QuestionItemModel;
import com.cpu.quikdata.ModulesV2.PrefilledData.Models.QuestionItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.PrefilledData.ViewModels.TemplateQuestionItemViewModel;
import com.cpu.quikdata.ModulesV2.PrefilledData.ViewModels.TemplateQuestionItemViewModelGenderTuple;
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
        View root = inflater.inflate(R.layout.template_question_gender_tuple, parent, false);
        return new TemplateItemViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull TemplateItemViewHolder holder, int position) {
        QuestionItemModelGenderTuple model = (QuestionItemModelGenderTuple) mIPrefilledDataManager.getQuestions().get(position);
        holder.setViewModel(new TemplateQuestionItemViewModelGenderTuple(model));
    }

    @Override
    public int getItemCount() {
        return mIPrefilledDataManager.getItemsCount();
    }

    public void updateData() {
        notifyDataSetChanged();
    }
}
