package com.cpu.quikdata.ModelsV2.Form.EvacuationInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRow;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class EvacuationPopulationDataRow extends RealmObject implements IEnumDataRow<GenericEnumDataRow.AgeGroup> {

    @Required
    @PrimaryKey
    private String id;

    private String ageGroup;

    private RealmList<QuestionItemModelSingleNumber> numberFields;

    public EvacuationPopulationDataRow() {
        setupFields();
    }

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public RealmList<QuestionItemModelSingleNumber> getNumberFields() {
        return numberFields;
    }

    public void setNumberFields(RealmList<QuestionItemModelSingleNumber> numberFields) {
        this.numberFields = numberFields;
    }

    @Override
    public GenericEnumDataRow.AgeGroup getActualType() {
        return GenericEnumDataRow.AgeGroup.getValueOf(ageGroup);
    }

    @Override
    public void setupFields() {

        if (numberFields == null) {
            numberFields = new RealmList<>();
        }
        if (numberFields.isEmpty()) {
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "male", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "female", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "lgbt", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "pregnant", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "lactating", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "disabled", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "sick", 0));
        }
    }

    @Override
    public void deleteData() {
        numberFields.deleteAllFromRealm();
        deleteFromRealm();
    }
}
