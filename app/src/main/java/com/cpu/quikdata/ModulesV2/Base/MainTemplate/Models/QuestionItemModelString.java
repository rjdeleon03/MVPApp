package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models;

import com.cpu.quikdata.AppConstants;

public class QuestionItemModelString extends QuestionItemModel {

    private String value;

    public QuestionItemModelString(String question, String value) {
        super(question);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public AppConstants.QuestionItemType getType() {
        return AppConstants.QuestionItemType.STRING;
    }
}
