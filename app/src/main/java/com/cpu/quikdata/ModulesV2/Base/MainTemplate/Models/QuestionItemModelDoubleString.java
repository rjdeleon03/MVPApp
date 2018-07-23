package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class QuestionItemModelDoubleString extends RealmObject implements IQuestionItemModel {

    @Required
    @PrimaryKey
    private String id;
    private String question;
    private String subQuestion1;
    private String value1;
    private String subQuestion2;
    private String value2;

    public QuestionItemModelDoubleString() {}

    public QuestionItemModelDoubleString(String id, String question, String subQuestion1, String value1, String subQuestion2, String value2) {
        this.id = id;
        this.question = question;
        this.subQuestion1 = subQuestion1;
        this.value1 = value1;
        this.subQuestion2 = subQuestion2;
        this.value2 = value2;
    }

    public QuestionItemModelDoubleString(String question, String subQuestion1, String value1, String subQuestion2, String value2) {
        this.question = question;
        this.question = question;
        this.subQuestion1 = subQuestion1;
        this.value1 = value1;
        this.subQuestion2 = subQuestion2;
        this.value2 = value2;
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

    public String getSubQuestion1() {
        return subQuestion1;
    }

    public void setSubQuestion1(String subQuestion1) {
        this.subQuestion1 = subQuestion1;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getSubQuestion2() {
        return subQuestion2;
    }

    public void setSubQuestion2(String subQuestion2) {
        this.subQuestion2 = subQuestion2;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }
}
