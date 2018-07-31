package com.cpu.quikdata.ModelsV2.Form.HealthInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRow;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class SpecialNeedsDataRow extends RealmObject implements IEnumDataRow<GenericEnumDataRow.SpecialNeedsType> {

    @Required
    @PrimaryKey
    private String id;

    private String specialNeedsType;

    private RealmList<QuestionItemModelSingleNumber> numberFields;
    private RealmList<QuestionItemModelString> stringFields;

    public SpecialNeedsDataRow() {
        setupFields();
    }

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getSpecialNeedsType() {
        return specialNeedsType;
    }

    public void setSpecialNeedsType(String specialNeedsType) {
        this.specialNeedsType = specialNeedsType;
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
    public GenericEnumDataRow.SpecialNeedsType getActualType() {
        return GenericEnumDataRow.SpecialNeedsType.valueOf(specialNeedsType);
    }

    @Override
    public void setupFields() {

        if (numberFields == null) {
            numberFields = new RealmList<>();
        }
        if (numberFields.isEmpty()) {
            numberFields = new RealmList<>();
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "number", 0));
        }

        if (stringFields == null) {
            stringFields = new RealmList<>();
        }
        if (stringFields.isEmpty()) {
            stringFields = new RealmList<>();
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "healthMedicalNeeds", ""));
        }
    }

    @Override
    public void deleteData() {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                stringFields.deleteAllFromRealm();
                numberFields.deleteAllFromRealm();
                deleteFromRealm();
            }
        });
    }
}
