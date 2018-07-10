package com.cpu.quikdata.ModulesV2.Base;

public class QuestionModel {

    private String question;
    private int value1;
    private int value2;

    public QuestionModel(String question, int value1, int value2) {
        this.question = question;
        this.value1 = value1;
        this.value2 = value2;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }
}
