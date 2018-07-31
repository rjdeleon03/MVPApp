package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class VulnerableDataRow extends RealmObject implements IEnumDataRow<GenericEnumDataRow.AgeGroup> {

    @Required
    @PrimaryKey
    private String id;

    private String ageGroup;

    private RealmList<QuestionItemModelSingleNumber> numberFields;
    private RealmList<QuestionItemModelGenderTuple> genderTupleFields;
    private RealmList<QuestionItemModelString> stringFields;

    public VulnerableDataRow() {
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

    public RealmList<QuestionItemModelGenderTuple> getGenderTupleFields() {
        return genderTupleFields;
    }

    public void setGenderTupleFields(RealmList<QuestionItemModelGenderTuple> genderTupleFields) {
        this.genderTupleFields = genderTupleFields;
    }

    public RealmList<QuestionItemModelString> getStringFields() {
        return stringFields;
    }

    public void setStringFields(RealmList<QuestionItemModelString> stringFields) {
        this.stringFields = stringFields;
    }

    @Override
    public GenericEnumDataRow.AgeGroup getActualType() {
        return GenericEnumDataRow.AgeGroup.valueOf(ageGroup);
    }

    @Override
    public void setupFields() {

        if (numberFields == null) {
            numberFields = new RealmList<>();
        }
        if (numberFields.isEmpty()) {
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "pregnant", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "lactating", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "lgbt", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "femaleHeadedHouseholds", 0));
        }

        if (genderTupleFields == null) {
            genderTupleFields = new RealmList<>();
        }
        if (genderTupleFields.isEmpty()) {
            genderTupleFields.add(new QuestionItemModelGenderTuple(AppUtil.generateId(), "childHeadedHouseholds", 0, 0));
            genderTupleFields.add(new QuestionItemModelGenderTuple(AppUtil.generateId(), "indigenous", 0, 0));
            genderTupleFields.add(new QuestionItemModelGenderTuple(AppUtil.generateId(), "disabled", 0, 0));
        }

        if (stringFields == null) {
            stringFields = new RealmList<>();
        }
        if (stringFields.isEmpty()) {
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "vulnerableRemarks", ""));
        }
    }

    @Override
    public void deleteData() {
        numberFields.deleteAllFromRealm();
        genderTupleFields.deleteAllFromRealm();
        stringFields.deleteAllFromRealm();
        deleteFromRealm();
    }
}
