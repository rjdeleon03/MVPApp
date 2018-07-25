package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class QuestionItemModelMultChoice extends RealmObject implements IQuestionItemModel {

    @Required
    @PrimaryKey
    private String id;
    private String question;
    private RealmList<String> choices;
    private int selected;

    public QuestionItemModelMultChoice() {}

    public QuestionItemModelMultChoice(String id, String question, RealmList<String> choices, int selected) {
        this.id = id;
        this.question = question;
        this.choices = choices;
        this.selected = selected;
    }

    public QuestionItemModelMultChoice(String question, RealmList<String> choices, int selected) {
        this.question = question;
        this.choices = choices;
        this.selected = selected;
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

    public RealmList<String> getChoices() {
        return choices;
    }

    public void setChoices(RealmList<String> choices) {
        this.choices = choices;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }
}
