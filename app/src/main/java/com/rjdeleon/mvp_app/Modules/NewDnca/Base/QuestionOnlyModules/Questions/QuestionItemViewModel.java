package com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions;

public abstract class QuestionItemViewModel {
    public final String question;

    protected QuestionItemViewModel(String question) {
        this.question = question;
    }
}
