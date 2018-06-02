package com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions.Questions;

import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseQuestion;

public class WashConditionsItemViewModelString extends WashConditionsItemViewModelBase {

    public final ObservableField<String> answer;

    public WashConditionsItemViewModelString(BaseQuestion baseQuestion) {
        super(baseQuestion.getQuestion());
        answer = new ObservableField<>((String) baseQuestion.getValue());
    }

}
