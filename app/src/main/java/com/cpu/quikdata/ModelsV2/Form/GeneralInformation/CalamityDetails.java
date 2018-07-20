package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class CalamityDetails extends RealmObject implements IFieldHolder {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<QuestionItemModelString> stringFields;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CalamityDetails() {
        setupFields();
    }

    public RealmList<QuestionItemModelString> getStringFields() {
        return stringFields;
    }

    public void setStringFields(RealmList<QuestionItemModelString> stringFields) {
        this.stringFields = stringFields;
    }

    @Override
    public void setupFields() {
        if (stringFields != null && !stringFields.isEmpty()) return;
        stringFields = new RealmList<>();
        stringFields.add(new QuestionItemModelString(AppUtil.generateId(),"calamityType", ""));
        stringFields.add(new QuestionItemModelString(AppUtil.generateId(),"eventDesc", ""));
        stringFields.add(new QuestionItemModelString(AppUtil.generateId(),"areaDesc", ""));
    }
}
