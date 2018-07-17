package com.cpu.quikdata.ModulesV2.Base.MainTemplate;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModelsV2.PrefilledData.PrefilledData;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;
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

import java.util.ArrayList;
import java.util.List;

public abstract class TemplateItemAdapter<D> extends RecyclerView.Adapter<TemplateItemViewHolder> {

    private IBaseQuestionDataManager<D> mBaseQuestionDataManager;
    private List<TemplateQuestionItemViewModel> mItemViewModels = new ArrayList<>();

    public TemplateItemAdapter(IBaseQuestionDataManager baseQuestionDataManager) {
        mBaseQuestionDataManager = baseQuestionDataManager;
    }

    @NonNull
    @Override
    public TemplateItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        AppConstants.QuestionItemType qType = AppConstants.QuestionItemType.values()[viewType];
        return initViewHolder(inflater, parent, qType);
    }

    /**
     * Initializes the viewHolder for the item
     * @param inflater
     * @param parent
     * @param questionItemType
     * @return
     */
    protected abstract TemplateItemViewHolder initViewHolder(LayoutInflater inflater, ViewGroup parent, AppConstants.QuestionItemType questionItemType);

    @Override
    public void onBindViewHolder(@NonNull TemplateItemViewHolder holder, int position) {
        QuestionItemModel model = mBaseQuestionDataManager.getQuestions().get(position);

        TemplateQuestionItemViewModel itemViewModel = null;
        if (model instanceof QuestionItemModelGenderTuple) {
            itemViewModel = new TemplateQuestionItemViewModelGenderTuple((QuestionItemModelGenderTuple) model);
        } else if (model instanceof QuestionItemModelSingleNumber) {
            itemViewModel = new TemplateQuestionItemViewModelSingleNumber((QuestionItemModelSingleNumber) model);
        } else if (model instanceof QuestionItemModelString) {
            itemViewModel = new TemplateQuestionItemViewModelString((QuestionItemModelString) model);
        }

        if (itemViewModel != null) {
            mItemViewModels.add(itemViewModel);
            holder.setViewModel(itemViewModel);
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

    /**
     * Retrieves list of question item view models
     * @return
     */
    public List<TemplateQuestionItemViewModel> getItemViewModels() {
        return mItemViewModels;
    }
}
