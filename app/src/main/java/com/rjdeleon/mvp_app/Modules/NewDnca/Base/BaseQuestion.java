package com.rjdeleon.mvp_app.Modules.NewDnca.Base;

import android.databinding.Observable;

public class BaseQuestion {

    private String question;
    private Observable value;

    public BaseQuestion(String question, Observable value) {
        this.question = question;
        this.value = value;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Observable getValue() {
        return value;
    }

    public void setValue(Observable value) {
        this.value = value;
    }
}
