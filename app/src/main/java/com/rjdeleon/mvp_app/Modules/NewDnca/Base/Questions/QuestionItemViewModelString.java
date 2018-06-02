package com.rjdeleon.mvp_app.Modules.NewDnca.Base.Questions;

import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseQuestion;

public class QuestionItemViewModelString extends QuestionItemViewModelBase {

    public final ObservableField<String> answer;

    public QuestionItemViewModelString(BaseQuestion baseQuestion) {
        super(baseQuestion.getQuestion());
        answer = new ObservableField<>((String) baseQuestion.getValue());
    }

}
