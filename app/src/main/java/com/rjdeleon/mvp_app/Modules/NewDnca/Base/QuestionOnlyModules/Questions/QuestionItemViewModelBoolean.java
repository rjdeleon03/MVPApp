package com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions;

import android.databinding.ObservableBoolean;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseQuestion;

public class QuestionItemViewModelBoolean extends QuestionItemViewModel {

    public final ObservableBoolean answer;
    public final String yesText;
    public final String noText;

    public QuestionItemViewModelBoolean(BaseQuestion baseQuestion, String yesText, String noText) {
        super(baseQuestion.getQuestion());
        this.yesText = yesText;
        this.noText = noText;
        answer = new ObservableBoolean((boolean) baseQuestion.getValue());
    }

    public QuestionItemViewModelBoolean(BaseQuestion baseQuestion) {
        this(baseQuestion, "Yes", "No");
    }
}
