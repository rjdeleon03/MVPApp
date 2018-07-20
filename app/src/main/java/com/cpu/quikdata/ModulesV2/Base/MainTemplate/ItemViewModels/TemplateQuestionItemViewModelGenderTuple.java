package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels;

import android.databinding.ObservableInt;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;

public class TemplateQuestionItemViewModelGenderTuple extends TemplateQuestionItemViewModel<QuestionItemModelGenderTuple> {

    private final QuestionItemModelGenderTuple mModel;
    public final ObservableInt male = new ObservableInt(0);
    public final ObservableInt female = new ObservableInt(0);

    public TemplateQuestionItemViewModelGenderTuple(QuestionItemModelGenderTuple model) {
        super(model.getQuestion());
        mModel = model;
        male.set(model.getMale());
        female.set(model.getFemale());
    }

    public void updateModel() {
        mModel.setMale(male.get());
        mModel.setFemale(female.get());
    }

    @Override
    public QuestionItemModelGenderTuple getModel() {
        return new QuestionItemModelGenderTuple(question.get(), male.get(), female.get());
    }

    @Override
    public AppConstants.QuestionItemType getType() {
        return AppConstants.QuestionItemType.GENDER_TUPLE;
    }
}
