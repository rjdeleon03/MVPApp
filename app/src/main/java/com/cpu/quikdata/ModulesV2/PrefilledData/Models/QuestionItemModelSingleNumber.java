package com.cpu.quikdata.ModulesV2.PrefilledData.Models;

public class QuestionItemModelSingleNumber extends QuestionItemModel {

    private int value;

    public QuestionItemModelSingleNumber(String question, int value) {
        super(question);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
