package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels;

import android.databinding.ObservableBoolean;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBoolean;
import com.cpu.quikdata.Utils.TextUtils;

public class TemplateQuestionItemViewModelBoolean extends TemplateQuestionItemViewModel<QuestionItemModelBoolean> {

    public final ObservableBoolean value = new ObservableBoolean(false);
    private boolean mUseAltLayout;

    public TemplateQuestionItemViewModelBoolean(QuestionItemModelBoolean model, boolean useAltLayout) {
        super(model);
        question.set(TextUtils.textMap.get(mModel.getQuestion()));
        value.set(mModel.getValue());
        mUseAltLayout = useAltLayout;
    }

    public TemplateQuestionItemViewModelBoolean(QuestionItemModelBoolean model) {
        this(model, false);
    }

    public boolean getUseAltLayout() {
        return mUseAltLayout;
    }

    @Override
    public QuestionItemModelBoolean getModel() {
        return new QuestionItemModelBoolean(question.get(), value.get());
    }

    @Override
    public AppConstants.QuestionItemType getType() {
        return AppConstants.QuestionItemType.BOOLEAN;
    }

    @Override
    public void updateModel() {
        mModel.setValue(value.get());
    }
}
