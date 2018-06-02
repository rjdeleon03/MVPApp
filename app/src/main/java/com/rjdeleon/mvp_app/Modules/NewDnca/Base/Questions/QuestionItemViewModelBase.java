package com.rjdeleon.mvp_app.Modules.NewDnca.Base.Questions;

public abstract class QuestionItemViewModelBase {
    public final String question;

    protected QuestionItemViewModelBase(String question) {
        this.question = question;
    }
}
