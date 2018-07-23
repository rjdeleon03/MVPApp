package com.cpu.quikdata.ModelsV2.Form.FoodSecurityInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelDoubleString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class ImpactDetails extends RealmObject implements IFieldHolder {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<QuestionItemModelBooleanString> booleanStringFields;
    private RealmList<QuestionItemModelDoubleString> doubleStringFields;
    private RealmList<QuestionItemModelString> stringFields;

    public ImpactDetails() {
        setupFields();
    }

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public RealmList<QuestionItemModelBooleanString> getBooleanStringFields() {
        return booleanStringFields;
    }

    public void setBooleanStringFields(RealmList<QuestionItemModelBooleanString> booleanStringFields) {
        this.booleanStringFields = booleanStringFields;
    }

    public RealmList<QuestionItemModelDoubleString> getDoubleStringFields() {
        return doubleStringFields;
    }

    public void setDoubleStringFields(RealmList<QuestionItemModelDoubleString> doubleStringFields) {
        this.doubleStringFields = doubleStringFields;
    }

    public RealmList<QuestionItemModelString> getStringFields() {
        return stringFields;
    }

    public void setStringFields(RealmList<QuestionItemModelString> stringFields) {
        this.stringFields = stringFields;
    }

    @Override
    public void setupFields() {
        if (booleanStringFields == null) {
            booleanStringFields = new RealmList<>();
        }
        if (booleanStringFields.isEmpty()) {
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "foodAvailabilityProblem", true, "remarks", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "foodAccessLack", true, "remarks", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "foodAccessContraints", true, "remarks", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "otherSources", true, "remarks", ""));
        }

        if (doubleStringFields == null) {
            doubleStringFields = new RealmList<>();
        }
        if (doubleStringFields.isEmpty()) {
            doubleStringFields.add(new QuestionItemModelDoubleString(AppUtil.generateId(), "eatingTimes", "beforeEmergency", "", "afterEmergency", ""));
            doubleStringFields.add(new QuestionItemModelDoubleString(AppUtil.generateId(), "meetFoodNeeds", "beforeEmergency", "", "afterEmergency", ""));
        }

        if (stringFields == null) {
            stringFields = new RealmList<>();
        }
        if (stringFields.isEmpty()) {
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "foodProductionChanged", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "nextFoodRation", ""));
        }
    }
}
