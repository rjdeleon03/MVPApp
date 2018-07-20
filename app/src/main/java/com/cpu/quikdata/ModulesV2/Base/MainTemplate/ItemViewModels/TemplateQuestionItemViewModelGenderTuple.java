package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels;

import android.databinding.ObservableInt;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;

public class TemplateQuestionItemViewModelGenderTuple extends TemplateQuestionItemViewModel<QuestionItemModelGenderTuple> {

    public final ObservableInt male = new ObservableInt(0);
    public final ObservableInt female = new ObservableInt(0);

    public TemplateQuestionItemViewModelGenderTuple(QuestionItemModelGenderTuple model) {
        super(model);
        question.set(mModel.getQuestion());
        male.set(mModel.getMale());
        female.set(mModel.getFemale());
    }

    @Override
    public QuestionItemModelGenderTuple getModel() {
        return new QuestionItemModelGenderTuple(question.get(), male.get(), female.get());
    }

    @Override
    public AppConstants.QuestionItemType getType() {
        return AppConstants.QuestionItemType.GENDER_TUPLE;
    }

    @Override
    public void updateModel() {
        mModel.setMale(male.get());
        mModel.setFemale(female.get());
    }
}
