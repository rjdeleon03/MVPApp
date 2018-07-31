package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels;

import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;
import android.databinding.ObservableList;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelMultChoice;
import com.cpu.quikdata.R;
import com.cpu.quikdata.Utils.TextUtils;

public class TemplateQuestionItemViewModelMultChoice extends TemplateQuestionItemViewModel<QuestionItemModelMultChoice> {

    public final ObservableInt selected = new ObservableInt(0);
    public final ObservableList<String> choices = new ObservableArrayList<>();
    private int mItemLayout = R.layout.template_question_mult_choice_item;

    public TemplateQuestionItemViewModelMultChoice(QuestionItemModelMultChoice model) {
        super(model);
        question.set(TextUtils.textMap.get(mModel.getQuestion()));
        selected.set(mModel.getSelected());
        choices.addAll(mModel.getChoices());
    }

    @Bindable
    public int getItemLayout() {
        return mItemLayout;
    }

    @Override
    public QuestionItemModelMultChoice getModel() {
        return new QuestionItemModelMultChoice(question.get(), mModel.getChoices(), selected.get());
    }

    @Override
    public AppConstants.QuestionItemType getType() {
        return AppConstants.QuestionItemType.STRING;
    }

    @Override
    public void updateModel() {
        mModel.setSelected(selected.get());
    }
}
