package com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions;

import android.databinding.ObservableFloat;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;

public class QuestionItemViewModelFloat extends QuestionItemViewModel {

    public final ObservableFloat answer;

    public QuestionItemViewModelFloat(BaseQuestion baseQuestion) {
        super(baseQuestion.getQuestion());
        answer = new ObservableFloat((float) baseQuestion.getValue());

        if (question == null) {
            int x = 5;
        }
    }

}
