package com.cpu.quikdata.ModulesV2.PrefilledData.Models;

import com.cpu.quikdata.AppConstants;

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

    @Override
    public AppConstants.QuestionItemType getType() {
        return AppConstants.QuestionItemType.SINGLE_NUMBER;
    }
}
