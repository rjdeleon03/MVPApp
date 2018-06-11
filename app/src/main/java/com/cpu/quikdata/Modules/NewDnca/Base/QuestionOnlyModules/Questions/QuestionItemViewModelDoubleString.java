package com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions;

import android.databinding.ObservableField;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionMultipleValue;

public class QuestionItemViewModelDoubleString extends QuestionItemViewModel {

    public final String subQuestion1;
    public final String subQuestion2;

    public final ObservableField<String> answer1;
    public final ObservableField<String> answer2;

    public QuestionItemViewModelDoubleString(BaseQuestionMultipleValue baseQuestion, String subQuestion1, String subQuestion2) {
        super(baseQuestion.getQuestion());
        this.subQuestion1 = subQuestion1;
        this.subQuestion2 = subQuestion2;
        answer1 = new ObservableField<>((String) baseQuestion.getValue()[0]);
        answer2 = new ObservableField<>((String) baseQuestion.getValue()[1]);
    }

}
