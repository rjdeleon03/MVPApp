package com.cpu.quikdata.ModelsV2.Form.WashInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelMultChoiceRemarks;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelTextOnly;
import com.cpu.quikdata.Utils.TextUtils;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class WashConditionsDetails extends RealmObject implements IFieldHolder {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<String> choices = new RealmList<>(
            TextUtils.getTextFromMapping("level1"),
            TextUtils.getTextFromMapping("level2"),
            TextUtils.getTextFromMapping("level3"));
    private RealmList<QuestionItemModelMultChoiceRemarks> multChoiceRemarksFields;
    private RealmList<QuestionItemModelBooleanString> booleanStringFields;
    private RealmList<QuestionItemModelSingleNumber> numberFields;
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

    public RealmList<QuestionItemModelMultChoiceRemarks> getMultChoiceRemarksFields() {
        return multChoiceRemarksFields;
    }

    public void setMultChoiceRemarksFields(RealmList<QuestionItemModelMultChoiceRemarks> multChoiceRemarksFields) {
        this.multChoiceRemarksFields = multChoiceRemarksFields;
    }

    public RealmList<QuestionItemModelBooleanString> getBooleanStringFields() {
        return booleanStringFields;
    }

    public void setBooleanStringFields(RealmList<QuestionItemModelBooleanString> booleanStringFields) {
        this.booleanStringFields = booleanStringFields;
    }

    public RealmList<QuestionItemModelSingleNumber> getNumberFields() {
        return numberFields;
    }

    public void setNumberFields(RealmList<QuestionItemModelSingleNumber> numberFields) {
        this.numberFields = numberFields;
    }

    public RealmList<QuestionItemModelString> getStringFields() {
        return stringFields;
    }

    public void setStringFields(RealmList<QuestionItemModelString> stringFields) {
        this.stringFields = stringFields;
    }

    @Override
    public void setupFields() {

        if (multChoiceRemarksFields == null) {
            multChoiceRemarksFields = new RealmList<>();
        }
        if (multChoiceRemarksFields.isEmpty()) {
            multChoiceRemarksFields.add(new QuestionItemModelMultChoiceRemarks(AppUtil.generateId(), "drinkingFoodPrep", choices, 0, "remarks", ""));
            multChoiceRemarksFields.add(new QuestionItemModelMultChoiceRemarks(AppUtil.generateId(), "bathingWashing", choices, 0, "remarks", ""));
        }

        if (booleanStringFields == null) {
            booleanStringFields = new RealmList<>();
        }
        if (booleanStringFields.isEmpty()) {
            booleanStringFields.add(new QuestionItemModelBooleanString(
                    AppUtil.generateId(), "isWaterPotable", true, "whereToGetCleanWater", ""));
        }

        if (numberFields == null) {
            numberFields = new RealmList<>();
        }
        if (numberFields.isEmpty()) {
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "waterPoints", 0));
        }

        if (stringFields == null) {
            stringFields = new RealmList<>();
        }
        if (stringFields.isEmpty()) {
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "timeFetchingWater", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "ownsWaterSource", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "payWaterContainer", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "payWaterTranspo", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "timesNoWater", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "handWashingFacilities", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "wasteDisposalFacility", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "isWasteSegregated", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "menstruationManagement", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "napkinsDisposal", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "diapersDisposal", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "defecationPractices", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "toiletFacilities", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "toiletConditions", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "defecationPracticeThreat", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "existingFacilitiesMaintained", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "securityProtectionIssues", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "areToiletsSegregated", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "areToiletsAccessible", ""));
        }
    }

    @Override
    public void deleteData() {
        numberFields.deleteAllFromRealm();
        stringFields.deleteAllFromRealm();
        multChoiceRemarksFields.deleteAllFromRealm();
        booleanStringFields.deleteAllFromRealm();
        deleteFromRealm();
    }
}
