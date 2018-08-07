package com.cpu.quikdata.ModelsV2.Form.ShelterInformation;

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

public class ShelterNeedsDataRow extends RealmObject implements IEnumDataRow<GenericEnumDataRow.NeedsType> {

    @Required
    @PrimaryKey
    private String id;

    private String needsType;
    private RealmList<QuestionItemModelString> stringFields;
    private RealmList<QuestionItemModelSingleNumber> numberFields;

    public ShelterNeedsDataRow() {
        setupFields();
    }

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getNeedsType() {
        return needsType;
    }

    public void setNeedsType(String needsType) {
        this.needsType = needsType;
    }

    public RealmList<QuestionItemModelString> getStringFields() {
        return stringFields;
    }

    public void setStringFields(RealmList<QuestionItemModelString> stringFields) {
        this.stringFields = stringFields;
    }

    public RealmList<QuestionItemModelSingleNumber> getNumberFields() {
        return numberFields;
    }

    public void setNumberFields(RealmList<QuestionItemModelSingleNumber> numberFields) {
        this.numberFields = numberFields;
    }

    @Override
    public GenericEnumDataRow.NeedsType getActualType() {
        return GenericEnumDataRow.NeedsType.valueOf(needsType);
    }

    @Override
    public void setupFields() {
        if (stringFields == null) {
            stringFields = new RealmList<>();
        }
        if (stringFields.isEmpty()) {
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "specificItems", ""));
        }

        if (numberFields == null) {
            numberFields = new RealmList<>();
        }
        if (numberFields.isEmpty()) {
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "familyCount", 0));
        }
    }

    @Override
    public void deleteData() {
        stringFields.deleteAllFromRealm();
        numberFields.deleteAllFromRealm();
        deleteFromRealm();
    }
}
