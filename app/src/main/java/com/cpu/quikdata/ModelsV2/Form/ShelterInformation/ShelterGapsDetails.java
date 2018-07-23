package com.cpu.quikdata.ModelsV2.Form.ShelterInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class ShelterGapsDetails extends RealmObject implements IFieldHolder {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<QuestionItemModelString> stringFields;

    public ShelterGapsDetails() {
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

    @Override
    public void setupFields() {
        if (stringFields == null) {
            stringFields = new RealmList<>();
        }

        if (stringFields.isEmpty()) {
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "separateCubicles", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "culturallyAppropriate", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "shelterSizeAppropriate", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "basicAccess", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "hasAbleBodiedMembers", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "gbvReferral", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "gbvProtectionService", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "gbvProtectionFocalPoint", ""));
        }
    }
}
