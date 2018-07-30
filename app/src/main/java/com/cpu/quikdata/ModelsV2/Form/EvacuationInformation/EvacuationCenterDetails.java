package com.cpu.quikdata.ModelsV2.Form.EvacuationInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class EvacuationCenterDetails extends RealmObject implements IFieldHolder {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<QuestionItemModelString> stringFields;
    private RealmList<QuestionItemModelMultChoice> multChoiceFields;

    private RealmList<String> displacedChoices = new RealmList<>("displaced", "nonDisplaced");

    public EvacuationCenterDetails() {
        setupFields();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RealmList<String> getDisplacedChoices() {
        return displacedChoices;
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
            multChoiceFields.add(new QuestionItemModelMultChoice(AppUtil.generateId(), "haveMoved", displacedChoices, 0));
        }

        if (stringFields == null) {
            stringFields = new RealmList<>();
        }
        if (stringFields.isEmpty()) {
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "evacuationCenterName", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "location", ""));
        }
    }
}