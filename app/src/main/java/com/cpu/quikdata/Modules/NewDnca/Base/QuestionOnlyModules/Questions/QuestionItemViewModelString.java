package com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions;

import android.databinding.ObservableField;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;

public class QuestionItemViewModelString extends QuestionItemViewModel {

    public final ObservableField<String> answer;

    public QuestionItemViewModelString(BaseQuestion baseQuestion) {
        super(baseQuestion.getQuestion());
        answer = new ObservableField<>((String) baseQuestion.getValue());
    }

}
