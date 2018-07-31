package com.cpu.quikdata.ModelsV2.Form.EvacuationInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBooleanString;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class EvacuationProtectionDetails extends RealmObject implements IFieldHolder {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<QuestionItemModelBooleanString> booleanStringFields;

    public EvacuationProtectionDetails() {
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

    @Override
    public void setupFields() {

        if (booleanStringFields == null) {
            booleanStringFields = new RealmList<>();
        }
        if (booleanStringFields.isEmpty()) {
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "unacommpaniedChildren", false, "unaccompaniedChildrenCount", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "toiletBathLocks", false, "remarks", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "segregatedToilets", false, "remarks", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "properLighting", false, "remarks", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "securityOfficers", false, "remarks", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "sleepingPartitions", false, "remarks", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "childFriendlySpace", false, "remarks", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "pregnantSafeSpace", false, "remarks", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "disabledSafeSpace", false, "remarks", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "religiousSpace", false, "remarks", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "gbvReferral", false, "remarks", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "gbvProtectionServices", false, "remarks", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "gbvProtectionFocalPoint", false, "remarks", ""));
        }

    }
}
