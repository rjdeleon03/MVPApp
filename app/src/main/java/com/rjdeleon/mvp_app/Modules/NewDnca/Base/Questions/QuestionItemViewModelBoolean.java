package com.rjdeleon.mvp_app.Modules.NewDnca.Base.Questions;

import android.databinding.ObservableBoolean;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseQuestion;

public class QuestionItemViewModelBoolean extends QuestionItemViewModelBase {

    public final ObservableBoolean answer;

    public QuestionItemViewModelBoolean(BaseQuestion baseQuestion) {
        super(baseQuestion.getQuestion());
        answer = new ObservableBoolean((boolean) baseQuestion.getValue());
    }
}
