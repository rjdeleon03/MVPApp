package com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions.Questions;

import android.databinding.ObservableBoolean;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseQuestion;

public class WashConditionsItemViewModelBoolean extends WashConditionsItemViewModelBase {

    public final ObservableBoolean answer;

    public WashConditionsItemViewModelBoolean(BaseQuestion baseQuestion) {
        super(baseQuestion.getQuestion());
        answer = new ObservableBoolean((boolean) baseQuestion.getValue());
    }
}
