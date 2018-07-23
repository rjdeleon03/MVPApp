package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels;

import android.databinding.ObservableInt;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelDate;

public class TemplateQuestionItemViewModelDate extends TemplateQuestionItemViewModel<QuestionItemModelDate> {

    public final ObservableInt year = new ObservableInt(0);
    public final ObservableInt month = new ObservableInt(0);
    public final ObservableInt dayOfMonth = new ObservableInt(0);

    public TemplateQuestionItemViewModelDate(QuestionItemModelDate model) {
        super(model);
        question.set(mModel.getQuestion());
        year.set(mModel.getYear());
        month.set(mModel.getMonth());
        dayOfMonth.set(mModel.getDayOfMonth());
    }

    @Override
    public QuestionItemModelDate getModel() {
        return new QuestionItemModelDate(question.get(), year.get(), month.get(), dayOfMonth.get());
    }

    @Override
    public AppConstants.QuestionItemType getType() {
        return AppConstants.QuestionItemType.SINGLE_NUMBER;
    }

    @Override
    public void updateModel() {
        mModel.setYear(year.get());
        mModel.setMonth(month.get());
        mModel.setDayOfMonth(dayOfMonth.get());
    }
}
