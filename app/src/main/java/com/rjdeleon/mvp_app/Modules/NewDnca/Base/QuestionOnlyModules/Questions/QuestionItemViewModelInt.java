package com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions;

import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;

public class QuestionItemViewModelInt extends QuestionItemViewModel {

    public final ObservableInt answer;

    public QuestionItemViewModelInt(BaseQuestion baseQuestion) {
        super(baseQuestion.getQuestion());
        answer = new ObservableInt((int) baseQuestion.getValue());
    }

}
