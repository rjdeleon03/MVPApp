package com.cpu.quikdata.ModulesV2.Base.MainTemplate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders.Readonly.TemplateReadonlyItemViewHolderGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders.TemplateItemViewHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders.Question.TemplateQuestionItemViewHolderGenderTuple;
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
                return new TemplateReadonlyItemViewHolderGenderTuple(view);
//            case SINGLE_NUMBER:
//                view = inflater.inflate(R.layout.template_readonly_single_number, parent, false);
//                return new TemplateQuestionItemViewHolderSingleNumber(view);
//            case STRING:
//                view = inflater.inflate(R.layout.template_readonly_string, parent, false);
//                return new TemplateQuestionItemViewHolderString(view);
        }
        return null;
    }
}
