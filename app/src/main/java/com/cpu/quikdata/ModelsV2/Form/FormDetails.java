package com.cpu.quikdata.ModelsV2.Form;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelDate;
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

    private RealmList<QuestionItemModelDate> dateFields;
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

    public RealmList<QuestionItemModelDate> getDateFields() {
        return dateFields;
    }

    public void setDateFields(RealmList<QuestionItemModelDate> dateFields) {
        this.dateFields = dateFields;
    }

    @Override
    public void setupFields() {
        if (dateFields == null) {
            dateFields = new RealmList<>();
        }
        if (dateFields.isEmpty()) {
            dateFields.add(new QuestionItemModelDate(AppUtil.generateId(), "assessmentDate"));
        }

        if (stringFields == null) {
            stringFields = new RealmList<>();
        }
        if (stringFields.isEmpty()) {
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "orgName", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "sitio", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "barangay", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "city", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "province", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "interviewer", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "interviewerNo", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "infoSources", ""));
        }
    }

    @Override
    public void deleteData() {
        stringFields.deleteAllFromRealm();
        dateFields.deleteAllFromRealm();
        deleteFromRealm();
    }
}
