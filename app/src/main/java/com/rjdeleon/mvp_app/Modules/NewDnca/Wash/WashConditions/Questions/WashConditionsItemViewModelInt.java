package com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions.Questions;

import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseQuestion;

public class WashConditionsItemViewModelInt extends WashConditionsItemViewModelBase {

    public final ObservableInt answer;

    public WashConditionsItemViewModelInt(BaseQuestion baseQuestion) {
        super(baseQuestion.getQuestion());
        answer = new ObservableInt((int) baseQuestion.getValue());
    }

}
