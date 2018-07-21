package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class QuestionItemModelString extends RealmObject implements IQuestionItemModel {

    @Required
    @PrimaryKey
    private String id;
    private String question;
    private String value;

    public QuestionItemModelString() {};

    public QuestionItemModelString(String id, String question, String value) {
        this.id = id;
        this.question = question;
        this.value = value;
    }

    public QuestionItemModelString(String question, String value) {
        this.question = question;
        this.value = value;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
