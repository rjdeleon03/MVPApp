package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelDate;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class CalamityDetails extends RealmObject implements IFieldHolder {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<QuestionItemModelString> stringFields;
    private RealmList<QuestionItemModelDate> dateFields;

    public CalamityDetails() {
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
            dateFields.add(new QuestionItemModelDate(AppUtil.generateId(), "dateOccurred"));
        }

        if (stringFields == null) {
            stringFields = new RealmList<>();
        }
        if (stringFields.isEmpty()) {
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "calamityType", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "eventDesc", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "areaDesc", ""));
        }
    }

    @Override
    public void deleteData() {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                stringFields.deleteAllFromRealm();
                dateFields.deleteAllFromRealm();
                deleteFromRealm();
            }
        });
    }
}
