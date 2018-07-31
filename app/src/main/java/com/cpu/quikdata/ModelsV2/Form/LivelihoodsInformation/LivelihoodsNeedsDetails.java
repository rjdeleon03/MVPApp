package com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class LivelihoodsNeedsDetails extends RealmObject implements IFieldHolder {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<QuestionItemModelString> stringFields;

    public LivelihoodsNeedsDetails() {
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
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "assistanceFillIncomeGap", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "assistanceReturnToNormal", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "livelihoodAssistanceFamilies", ""));
        }
    }

    @Override
    public void deleteData() {
        stringFields.deleteAllFromRealm();
        deleteFromRealm();
    }
}
