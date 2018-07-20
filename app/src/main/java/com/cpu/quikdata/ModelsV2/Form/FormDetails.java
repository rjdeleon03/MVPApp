package com.cpu.quikdata.ModelsV2.Form;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class FormDetails extends RealmObject implements IFieldHolder {

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

    public FormDetails() {
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
        stringFields.add(new QuestionItemModelString(AppUtil.generateId(),"orgName", ""));
        stringFields.add(new QuestionItemModelString(AppUtil.generateId(),"sitio", ""));
        stringFields.add(new QuestionItemModelString(AppUtil.generateId(),"barangay", ""));
        stringFields.add(new QuestionItemModelString(AppUtil.generateId(),"city", ""));
        stringFields.add(new QuestionItemModelString(AppUtil.generateId(),"province", ""));
        stringFields.add(new QuestionItemModelString(AppUtil.generateId(),"interviewer", ""));
        stringFields.add(new QuestionItemModelString(AppUtil.generateId(),"interviewerNo", ""));
        stringFields.add(new QuestionItemModelString(AppUtil.generateId(),"infoSources", ""));
    }
}
