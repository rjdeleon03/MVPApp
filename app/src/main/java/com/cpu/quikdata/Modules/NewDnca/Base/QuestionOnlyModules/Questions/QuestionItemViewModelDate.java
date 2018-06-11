package com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions;

import android.databinding.ObservableField;

import com.cpu.quikdata.Models.Generics.SimpleDate;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;

public class QuestionItemViewModelDate extends QuestionItemViewModel {

    public final ObservableField<SimpleDate> answer;

    /**
     * Constructor
     * @param baseQuestion
     */
    public QuestionItemViewModelDate(BaseQuestion baseQuestion) {
        super(baseQuestion.getQuestion());
        answer = new ObservableField<>((SimpleDate) baseQuestion.getValue());
    }

    /**
     * Sets the date
     * @param year
     * @param month
     * @param day
     */
    public void onDateSet(int year, int month, int day) {
        answer.set(new SimpleDate(year, month, day));
    }
}
