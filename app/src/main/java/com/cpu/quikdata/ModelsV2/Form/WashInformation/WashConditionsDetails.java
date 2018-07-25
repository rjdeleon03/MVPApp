package com.cpu.quikdata.ModelsV2.Form.WashInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class WashConditionsDetails extends RealmObject implements IFieldHolder {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<String> choices = new RealmList<>("level1", "level2", "level3");
    private RealmList<QuestionItemModelMultChoice> multChoiceFields;
    private RealmList<QuestionItemModelString> stringFields;

    public WashConditionsDetails() {
        setupFields();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RealmList<QuestionItemModelString> getStringFields() {
        return stringFields;
    }

    public void setStringFields(RealmList<QuestionItemModelString> stringFields) {
        this.stringFields = stringFields;
    }

    public RealmList<QuestionItemModelMultChoice> getMultChoiceFields() {
        return multChoiceFields;
    }

    public void setMultChoiceFields(RealmList<QuestionItemModelMultChoice> multChoiceFields) {
        this.multChoiceFields = multChoiceFields;
    }

    @Override
    public void setupFields() {
        if (multChoiceFields == null) {
            multChoiceFields = new RealmList<>();
        }

        if (multChoiceFields.isEmpty()) {
            multChoiceFields.add(new QuestionItemModelMultChoice(AppUtil.generateId(), "drinkingFoodPrep", choices, 0));
            multChoiceFields.add(new QuestionItemModelMultChoice(AppUtil.generateId(), "bathingWashing", choices, 0));
        }

        if (stringFields == null) {
            stringFields = new RealmList<>();
        }

        if (stringFields.isEmpty()) {
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "displacedLocation", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "copingWhen", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "returnHomeWhen", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "ifCannotReturnHome", ""));
        }
    }
}
