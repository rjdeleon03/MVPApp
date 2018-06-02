package com.rjdeleon.mvp_app.Modules.NewDnca.Base;

import android.databinding.Observable;

public class BaseQuestion {

    private String question;
    private Object value;
    private String remarks;

    public BaseQuestion(String question, Object value, String remarks) {
        this.question = question;
        this.value = value;
        this.remarks = remarks;
    }

    public BaseQuestion(String question, Object value) {
        this(question, value, null);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
