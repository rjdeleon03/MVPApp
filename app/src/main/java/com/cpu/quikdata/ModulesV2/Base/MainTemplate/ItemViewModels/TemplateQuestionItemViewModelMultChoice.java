package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels;

import android.content.Context;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ObservableList;
import android.widget.ArrayAdapter;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelMultChoice;

import io.realm.RealmList;

public class TemplateQuestionItemViewModelMultChoice extends TemplateQuestionItemViewModel<QuestionItemModelMultChoice> {

    public final ObservableInt selected = new ObservableInt(0);
    public final ObservableList<String> choices = new ObservableArrayList<>();
    private ArrayAdapter<String> mChoiceAdapter;

    public TemplateQuestionItemViewModelMultChoice(QuestionItemModelMultChoice model) {
        super(model);
//        question.set(TextUtils.textMap.get(mModel.getQuestion()));
        question.set(mModel.getQuestion());
        selected.set(mModel.getSelected());
        choices.addAll(mModel.getChoices());
    }

    public void setContext(Context context) {
        mChoiceAdapter = new ArrayAdapter<>(
                context,
                android.R.layout.simple_spinner_dropdown_item,
                choices
        );
    }
    
    @Bindable
    public ArrayAdapter<String> getChoiceAdapter() {
        return mChoiceAdapter;
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
