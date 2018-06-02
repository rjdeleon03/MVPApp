package com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions.Questions;

public abstract class WashConditionsItemViewModelBase {
    public final String question;

    protected WashConditionsItemViewModelBase(String question) {
        this.question = question;
    }
}
