package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class QuestionItemModelBooleanGroup extends RealmObject implements IQuestionItemModel {

    @Required
    @PrimaryKey
    private String id;
    private String question;
    private RealmList<QuestionItemModelBoolean> booleanFields;

    public QuestionItemModelBooleanGroup() {}

    public QuestionItemModelBooleanGroup(String id, String question, RealmList<QuestionItemModelBoolean> booleanFields) {
        this.id = id;
        this.question = question;
        this.booleanFields = booleanFields;
    }

    public QuestionItemModelBooleanGroup(String question, RealmList<QuestionItemModelBoolean> booleanFields) {
        this.question = question;
        this.booleanFields = booleanFields;
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

    public RealmList<QuestionItemModelBoolean> getBooleanFields() {
        return booleanFields;
    }

    public void setBooleanFields(RealmList<QuestionItemModelBoolean> booleanFields) {
        this.booleanFields = booleanFields;
    }
}
