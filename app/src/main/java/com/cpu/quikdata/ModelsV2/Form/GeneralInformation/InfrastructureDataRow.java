package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRow;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBoolean;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class InfrastructureDataRow extends RealmObject implements IEnumDataRow<GenericEnumDataRow.InfraType> {

    @Required
    @PrimaryKey
    private String id;

    private String infraType;

    private RealmList<QuestionItemModelSingleNumber> numberFields;
    private RealmList<QuestionItemModelBoolean> boolFields;
    private RealmList<QuestionItemModelString> stringFields;

    public InfrastructureDataRow() {
        setupFields();
    }

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getInfraType() {
        return infraType;
    }

    public void setInfraType(String infraType) {
        this.infraType = infraType;
    }

    public RealmList<QuestionItemModelSingleNumber> getNumberFields() {
        return numberFields;
    }

    public void setNumberFields(RealmList<QuestionItemModelSingleNumber> numberFields) {
        this.numberFields = numberFields;
    }

    public RealmList<QuestionItemModelBoolean> getBoolFields() {
        return boolFields;
    }

    public void setBoolFields(RealmList<QuestionItemModelBoolean> boolFields) {
        this.boolFields = boolFields;
    }

    public RealmList<QuestionItemModelString> getStringFields() {
        return stringFields;
    }

    public void setStringFields(RealmList<QuestionItemModelString> stringFields) {
        this.stringFields = stringFields;
    }

    @Override
    public GenericEnumDataRow.InfraType getActualType() {
        return GenericEnumDataRow.InfraType.getValueOf(infraType);
    }

    @Override
    public void setupFields() {

        if (numberFields == null) {
            numberFields = new RealmList<>();
        }
        if (numberFields.isEmpty()) {
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "infraCount", 0));
        }

        if (boolFields == null) {
            boolFields = new RealmList<>();
        }
        if (boolFields.isEmpty()) {
            boolFields.add(new QuestionItemModelBoolean(AppUtil.generateId(), "isFunctional", true));
        }

        if (stringFields == null) {
            stringFields = new RealmList<>();
        }
        if (stringFields.isEmpty()) {
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "infraRemarks", ""));
        }
    }

    @Override
    public void deleteData() {
        numberFields.deleteAllFromRealm();
        boolFields.deleteAllFromRealm();
        stringFields.deleteAllFromRealm();
        deleteFromRealm();
    }
}
