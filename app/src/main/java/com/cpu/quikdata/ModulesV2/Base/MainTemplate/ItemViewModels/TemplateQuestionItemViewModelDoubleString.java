package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels;

import android.databinding.ObservableField;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelDoubleString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.Utils.TextUtils;

public class TemplateQuestionItemViewModelDoubleString extends TemplateQuestionItemViewModel<QuestionItemModelDoubleString> {

    public final ObservableField<String> subQuestion1 = new ObservableField<>("");
    public final ObservableField<String> value1 = new ObservableField<>("");
    public final ObservableField<String> subQuestion2 = new ObservableField<>("");
    public final ObservableField<String> value2 = new ObservableField<>("");

    public TemplateQuestionItemViewModelDoubleString(QuestionItemModelDoubleString model) {
        super(model);
        question.set(TextUtils.getTextFromMapping(mModel.getQuestion()));
        subQuestion1.set(TextUtils.getTextFromMapping(mModel.getSubQuestion1()));
        value1.set(mModel.getValue1());
        subQuestion2.set(TextUtils.getTextFromMapping(mModel.getSubQuestion2()));
        value2.set(mModel.getValue2());
    }

    @Override
    public QuestionItemModelDoubleString getModel() {
        return new QuestionItemModelDoubleString(question.get(), subQuestion1.get(), value1.get(), subQuestion2.get(), value2.get());
    }

    @Override
    public AppConstants.QuestionItemType getType() {
        return AppConstants.QuestionItemType.DOUBLE_STRING;
    }

    @Override
    public void updateModel() {
        mModel.setValue1(value1.get());
        mModel.setValue2(value2.get());
    }
}
