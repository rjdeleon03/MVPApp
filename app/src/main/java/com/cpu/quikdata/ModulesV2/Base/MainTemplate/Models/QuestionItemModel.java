package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models;

import com.cpu.quikdata.AppConstants;

public abstract class QuestionItemModel {

    protected String question;

    public QuestionItemModel(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
