package com.cpu.quikdata.ModulesV2.PrefilledData;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModulesV2.PrefilledData.Models.QuestionItemModel;
import com.cpu.quikdata.ModulesV2.PrefilledData.Models.QuestionItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.PrefilledData.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.PrefilledData.ViewHolders.TemplateItemViewHolder;
import com.cpu.quikdata.ModulesV2.PrefilledData.ViewHolders.TemplateItemViewHolderGenderTuple;
import com.cpu.quikdata.ModulesV2.PrefilledData.ViewHolders.TemplateItemViewHolderSingleNumber;
import com.cpu.quikdata.ModulesV2.PrefilledData.ViewModels.TemplateQuestionItemViewModelGenderTuple;
import com.cpu.quikdata.ModulesV2.PrefilledData.ViewModels.TemplateQuestionItemViewModelSingleNumber;
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
        View view;

        AppConstants.QuestionItemType qType = AppConstants.QuestionItemType.values()[viewType];
        switch (qType) {
            case GENDER_TUPLE:
                view = inflater.inflate(R.layout.template_question_gender_tuple, parent, false);
                return new TemplateItemViewHolderGenderTuple(view);
            case SINGLE_NUMBER:
                view = inflater.inflate(R.layout.template_question_single_number, parent, false);
                return new TemplateItemViewHolderSingleNumber(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TemplateItemViewHolder holder, int position) {
        QuestionItemModel model = mIPrefilledDataManager.getQuestions().get(position);

        if (model instanceof QuestionItemModelGenderTuple) {
            holder.setViewModel(new TemplateQuestionItemViewModelGenderTuple((QuestionItemModelGenderTuple) model));
        } else if (model instanceof QuestionItemModelSingleNumber) {
            holder.setViewModel(new TemplateQuestionItemViewModelSingleNumber((QuestionItemModelSingleNumber) model));
        }
    }

    @Override
    public int getItemCount() {
        return mIPrefilledDataManager.getItemsCount();
    }

    @Override
    public int getItemViewType(int position) {
        AppConstants.QuestionItemType qType = mIPrefilledDataManager.getQuestions().get(position).getType();
        return qType.ordinal();
    }

    public void updateData() {
        notifyDataSetChanged();
    }
}
