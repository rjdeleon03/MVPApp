package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels;

import android.databinding.ObservableInt;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.Utils.TextUtils;

public class TemplateQuestionItemViewModelSingleNumber extends TemplateQuestionItemViewModel<QuestionItemModelSingleNumber> {

    public final ObservableInt value = new ObservableInt(0);

    public TemplateQuestionItemViewModelSingleNumber(QuestionItemModelSingleNumber model) {
        super(model);
        question.set(TextUtils.textMap.get(mModel.getQuestion()));
        value.set(mModel.getValue());
    }

    @Override
    public QuestionItemModelSingleNumber getModel() {
        return new QuestionItemModelSingleNumber(question.get(), value.get());
    }

    @Override
    public AppConstants.QuestionItemType getType() {
        return AppConstants.QuestionItemType.SINGLE_NUMBER;
    }

    @Override
    public void updateModel() {
        mModel.setValue(value.get());
    }
}
