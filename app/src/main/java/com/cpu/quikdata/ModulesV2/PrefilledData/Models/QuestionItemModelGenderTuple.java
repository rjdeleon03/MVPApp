package com.cpu.quikdata.ModulesV2.PrefilledData.Models;

import com.cpu.quikdata.AppConstants;

public class QuestionItemModelGenderTuple extends QuestionItemModel {

    private int male;
    private int female;

    public QuestionItemModelGenderTuple(String question, int male, int female) {
        super(question);
        this.male = male;
        this.female = female;
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

    @Override
    public AppConstants.QuestionItemType getType() {
        return AppConstants.QuestionItemType.GENDER_TUPLE;
    }
}
