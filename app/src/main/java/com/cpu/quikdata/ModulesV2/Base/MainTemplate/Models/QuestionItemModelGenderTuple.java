package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class QuestionItemModelGenderTuple extends RealmObject implements IQuestionItemModel {

    @Required
    @PrimaryKey
    private String id;
    private String question;
    private int male;
    private int female;

    public QuestionItemModelGenderTuple() {};

    public QuestionItemModelGenderTuple(String id, String question, int male, int female) {
        this.id = id;
        this.question = question;
        this.male = male;
        this.female = female;
    }

    public QuestionItemModelGenderTuple(String question, int male, int female) {
        this.question = question;
        this.male = male;
        this.female = female;
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

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }

    public int getFemale() {
        return female;
    }

    public void setFemale(int female) {
        this.female = female;
    }
}
