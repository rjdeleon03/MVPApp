package com.cpu.quikdata.ModelsV2.Form.EvacuationInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class EvacuationCopingDetails extends RealmObject implements IFieldHolder {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<QuestionItemModelString> stringFields;

    public EvacuationCopingDetails() {
        setupFields();
    }

    public String getId() {
        return id;
    }

    @Override
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
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "evacuationCoping", ""));
        }

    }
}
