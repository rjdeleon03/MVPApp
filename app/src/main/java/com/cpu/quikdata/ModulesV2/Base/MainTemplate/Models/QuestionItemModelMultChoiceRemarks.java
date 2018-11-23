package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class QuestionItemModelMultChoiceRemarks extends RealmObject implements IQuestionItemModel {

    @Required
    @PrimaryKey
    private String id;
    private String question;
    private RealmList<String> choices;
    private int selected;
    private String remarksQuestion;
    private String remarks;

    public QuestionItemModelMultChoiceRemarks() {}

    public QuestionItemModelMultChoiceRemarks(String id, String question, RealmList<String> choices, int selected, String remarksQuestion, String remarks) {
        this.id = id;
        this.question = question;
        this.choices = choices;
        this.selected = selected;
        this.remarksQuestion = remarksQuestion;
        this.remarks = remarks;
    }

    public QuestionItemModelMultChoiceRemarks(String question, RealmList<String> choices, int selected, String remarksQuestion, String remarks) {
        this.question = question;
        this.choices = choices;
        this.selected = selected;
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
