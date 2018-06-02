package com.rjdeleon.mvp_app.Modules.NewDnca.Base.Questions;

import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseQuestion;

public class QuestionItemViewModelInt extends QuestionItemViewModelBase {

    public final ObservableInt answer;

    public QuestionItemViewModelInt(BaseQuestion baseQuestion) {
        super(baseQuestion.getQuestion());
        answer = new ObservableInt((int) baseQuestion.getValue());
    }

}
