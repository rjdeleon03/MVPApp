package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class QuestionItemModelBoolean extends RealmObject implements IQuestionItemModel {

    @Required
    @PrimaryKey
    private String id;
    private String question;
    private boolean value;

    public QuestionItemModelBoolean() {};

    public QuestionItemModelBoolean(String id, String question, boolean value) {
        this.id = id;
        this.question = question;
        this.value = value;
    }

    public QuestionItemModelBoolean(String question, boolean value) {
        this.id = id;
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

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
