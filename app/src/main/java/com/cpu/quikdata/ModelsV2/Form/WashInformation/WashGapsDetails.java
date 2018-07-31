package com.cpu.quikdata.ModelsV2.Form.WashInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class WashGapsDetails extends RealmObject implements IFieldHolder {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<QuestionItemModelString> stringFields;

    public WashGapsDetails() {
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
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "isAssistanceEnough", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "isAssistanceRelevant", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "isWaterSourceAccessible", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "werePeopleConsultedRelief", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "hasOrientationWasteMgmt", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "attitudeTowardsSexes", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "hasSupportMechanisms", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "doWomenMakeDecisions", ""));
        }
    }

    @Override
    public void deleteData() {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                stringFields.deleteAllFromRealm();
                deleteFromRealm();
            }
        });
    }
}
