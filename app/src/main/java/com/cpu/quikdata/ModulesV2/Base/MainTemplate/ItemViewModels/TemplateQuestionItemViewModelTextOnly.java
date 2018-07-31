package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels;

import android.databinding.ObservableBoolean;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelTextOnly;
import com.cpu.quikdata.Utils.TextUtils;

import org.apache.commons.text.WordUtils;

public class TemplateQuestionItemViewModelTextOnly extends TemplateQuestionItemViewModel<QuestionItemModelTextOnly> {

    public final ObservableBoolean value = new ObservableBoolean(false);
    private boolean mUseAltLayout;

    public TemplateQuestionItemViewModelTextOnly(QuestionItemModelTextOnly model, boolean useAltLayout) {
        super(model);
        question.set((TextUtils.textMap.get(mModel.getQuestion())).toUpperCase());
        mUseAltLayout = useAltLayout;
    }

    public TemplateQuestionItemViewModelTextOnly(QuestionItemModelTextOnly model) {
        this(model, false);
    }

    public boolean getUseAltLayout() {
        return mUseAltLayout;
    }

    @Override
    public QuestionItemModelTextOnly getModel() {
        return new QuestionItemModelTextOnly(question.get());
    }

    @Override
    public AppConstants.QuestionItemType getType() {
        return AppConstants.QuestionItemType.BOOLEAN;
    }

    @Override
    public void updateModel() {}
}
