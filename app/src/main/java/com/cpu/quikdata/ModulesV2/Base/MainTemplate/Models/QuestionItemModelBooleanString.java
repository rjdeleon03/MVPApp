package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class QuestionItemModelBooleanString extends RealmObject implements IQuestionItemModel {

    @Required
    @PrimaryKey
    private String id;
    private String question;
    private boolean value;
    private String remarksQuestion;
    private String remarks;

    public QuestionItemModelBooleanString() {}

    public QuestionItemModelBooleanString(String id, String question, boolean value, String remarksQuestion, String remarks) {
        this.id = id;
        this.question = question;
        this.value = value;
        this.remarksQuestion = remarksQuestion;
        this.remarks = remarks;
    }

    public QuestionItemModelBooleanString(String question, boolean value, String remarksQuestion, String remarks) {
        this.question = question;
        this.value = value;
        this.remarksQuestion = remarksQuestion;
        this.remarks = remarks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public String getRemarksQuestion() {
        return remarksQuestion;
    }

    public void setRemarksQuestion(String remarksQuestion) {
        this.remarksQuestion = remarksQuestion;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
