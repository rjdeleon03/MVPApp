package com.cpu.quikdata.ModulesV2.Base.MainTemplate;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModelsV2.PrefilledData.PrefilledData;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders.TemplateItemViewHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders.TemplateItemViewHolderGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders.TemplateItemViewHolderSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders.TemplateItemViewHolderString;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseQuestionDataManager;
import com.cpu.quikdata.R;

public class TemplateItemAdapter extends RecyclerView.Adapter<TemplateItemViewHolder> {

    private IBaseQuestionDataManager<PrefilledData> mBaseQuestionDataManager;

    public TemplateItemAdapter(IBaseQuestionDataManager baseQuestionDataManager) {
        mBaseQuestionDataManager = baseQuestionDataManager;
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
            case STRING:
                view = inflater.inflate(R.layout.template_question_string, parent, false);
                return new TemplateItemViewHolderString(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TemplateItemViewHolder holder, int position) {
        QuestionItemModel model = mBaseQuestionDataManager.getQuestions().get(position);

        if (model instanceof QuestionItemModelGenderTuple) {
            holder.setViewModel(new TemplateQuestionItemViewModelGenderTuple((QuestionItemModelGenderTuple) model));
        } else if (model instanceof QuestionItemModelSingleNumber) {
            holder.setViewModel(new TemplateQuestionItemViewModelSingleNumber((QuestionItemModelSingleNumber) model));
        } else if (model instanceof QuestionItemModelString) {
            holder.setViewModel(new TemplateQuestionItemViewModelString((QuestionItemModelString) model));
        }
    }

    @Override
    public int getItemCount() {
        return mBaseQuestionDataManager.getItemsCount();
    }

    @Override
    public int getItemViewType(int position) {
        AppConstants.QuestionItemType qType = mBaseQuestionDataManager.getQuestions().get(position).getType();
        return qType.ordinal();
    }
}
