package com.cpu.quikdata.ModelsV2.PrefilledData;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class BaselineHousesRow extends RealmObject implements IFieldHolder {

    @Required
    @PrimaryKey
    private String id;

    private String houseType;
    private QuestionItemModelSingleNumber count;

    private int number;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public QuestionItemModelSingleNumber getCount() {
        return count;
    }

    public void setCount(QuestionItemModelSingleNumber count) {
        this.count = count;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void setupFields() {
        Realm realm = getRealm();
        if (count == null) {
            count = realm.createObject(QuestionItemModelSingleNumber.class, AppUtil.generateId());
            count.setQuestion(houseType);
            count.setValue(0);
        }
    }

    @Override
    public void deleteData() {
        // This will not be deleted
    }
}
