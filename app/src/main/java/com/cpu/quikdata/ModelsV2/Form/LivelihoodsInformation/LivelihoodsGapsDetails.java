package com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelTextOnly;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class LivelihoodsGapsDetails extends RealmObject implements IFieldHolder {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<QuestionItemModelTextOnly> textOnlyFields;
    private RealmList<QuestionItemModelBooleanString> booleanStringFields;

    public LivelihoodsGapsDetails() {
        setupFields();
    }

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public RealmList<QuestionItemModelTextOnly> getTextOnlyFields() {
        return textOnlyFields;
    }

    public void setTextOnlyFields(RealmList<QuestionItemModelTextOnly> textOnlyFields) {
        this.textOnlyFields = textOnlyFields;
    }

    public RealmList<QuestionItemModelBooleanString> getBooleanStringFields() {
        return booleanStringFields;
    }

    public void setBooleanStringFields(RealmList<QuestionItemModelBooleanString> booleanStringFields) {
        this.booleanStringFields = booleanStringFields;
    }

    @Override
    public void setupFields() {

        if (textOnlyFields == null) {
            textOnlyFields = new RealmList<>();
        }
        if (textOnlyFields.isEmpty()) {
            textOnlyFields.add(new QuestionItemModelTextOnly(AppUtil.generateId(), "menWomenHaveAccess"));
        }
        if (booleanStringFields == null) {
            booleanStringFields = new RealmList<>();
        }
        if (booleanStringFields.isEmpty()) {
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "localMarket", true, "remarks", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "cashFoodForWork", true, "remarks", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "credit", true, "remarks", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "livelihoodMaterials", true, "remarks", ""));
        }
    }

    @Override
    public void deleteData() {
        textOnlyFields.deleteAllFromRealm();
        booleanStringFields.deleteAllFromRealm();
        deleteFromRealm();
    }
}
