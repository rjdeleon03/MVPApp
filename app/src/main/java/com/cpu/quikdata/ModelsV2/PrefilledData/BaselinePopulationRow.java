package com.cpu.quikdata.ModelsV2.PrefilledData;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class BaselinePopulationRow extends RealmObject implements IFieldHolder {

    @Required
    @PrimaryKey
    private String id;

    private String ageGroup;
    private QuestionItemModelGenderTuple count;

    private int male = 0;

    private int female = 0;

    public BaselinePopulationRow() {
        setupFields();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public QuestionItemModelGenderTuple getCount() {
        return count;
    }

    public void setCount(QuestionItemModelGenderTuple count) {
        this.count = count;
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
    public void setupFields() {
        if (count == null) {
            count = new QuestionItemModelGenderTuple(AppUtil.generateId(), "genderTupleCount", 0, 0);
        }
    }

    @Override
    public void deleteData() {
        // This will not be deleted
    }
}
