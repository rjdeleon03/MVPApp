package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels;

import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ObservableList;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelMultChoiceRemarks;
import com.cpu.quikdata.R;
import com.cpu.quikdata.Utils.TextUtils;

public class TemplateQuestionItemViewModelMultChoiceRemarks extends TemplateQuestionItemViewModel<QuestionItemModelMultChoiceRemarks> {

    public final ObservableInt selected = new ObservableInt(0);
    public final ObservableList<String> choices = new ObservableArrayList<>();
    private int mItemLayout = R.layout.template_question_mult_choice_item;
    public final ObservableField<String> remarksQuestion = new ObservableField<>("");
    public final ObservableField<String> remarks = new ObservableField<>("");

    public TemplateQuestionItemViewModelMultChoiceRemarks(QuestionItemModelMultChoiceRemarks model) {
        super(model);
        question.set(TextUtils.getTextFromMapping(mModel.getQuestion()));
        selected.set(mModel.getSelected());
        choices.addAll(mModel.getChoices());
        remarksQuestion.set(TextUtils.getTextFromMapping(mModel.getRemarksQuestion()));
        remarks.set(mModel.getRemarks());
    }

    @Bindable
    public int getItemLayout() {
        return mItemLayout;
    }

    @Override
    public QuestionItemModelMultChoiceRemarks getModel() {
        return new QuestionItemModelMultChoiceRemarks(question.get(), mModel.getChoices(), selected.get(), remarksQuestion.get(), remarks.get());
    }

    @Override
    public AppConstants.QuestionItemType getType() {
        return AppConstants.QuestionItemType.STRING;
    }

    @Override
    public void updateModel() {
        mModel.setSelected(selected.get());
        mModel.setRemarks(remarks.get());
    }
}
