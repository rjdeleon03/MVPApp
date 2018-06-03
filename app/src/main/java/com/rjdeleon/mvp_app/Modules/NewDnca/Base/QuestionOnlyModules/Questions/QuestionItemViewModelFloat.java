package com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions;

import android.databinding.ObservableFloat;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseQuestion;

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
