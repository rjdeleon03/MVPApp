package com.cpu.quikdata.ModulesV2.Base.MainTemplate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders.TemplateItemViewHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders.TemplateItemViewHolderGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders.TemplateItemViewHolderSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders.TemplateItemViewHolderString;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseQuestionDataManager;
import com.cpu.quikdata.R;

public class TemplateReadonlyAdapter<D> extends TemplateItemAdapter<D> {

    public TemplateReadonlyAdapter(IBaseQuestionDataManager baseQuestionDataManager) {
        super(baseQuestionDataManager);
    }

    /**
     * Initializes the viewHolder for the item
     * @param parent
     * @param inflater
     * @param questionItemType
     * @return
     */
    @Override
    protected TemplateItemViewHolder initViewHolder(LayoutInflater inflater, ViewGroup parent, AppConstants.QuestionItemType questionItemType) {
        View view;
        switch (questionItemType) {
            case GENDER_TUPLE:
                view = inflater.inflate(R.layout.template_readonly_gender_tuple, parent, false);
                return new TemplateItemViewHolderGenderTuple(view);
//            case SINGLE_NUMBER:
//                view = inflater.inflate(R.layout.template_readonly_single_number, parent, false);
//                return new TemplateItemViewHolderSingleNumber(view);
//            case STRING:
//                view = inflater.inflate(R.layout.template_readonly_string, parent, false);
//                return new TemplateItemViewHolderString(view);
        }
        return null;
    }
}
