package com.cpu.quikdata.ModelsV2.Form.HealthInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRow;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class DiseasesDataRow extends RealmObject implements IEnumDataRow<GenericEnumDataRow.AgeGroup> {

    //TODO: Add label only row

    @Required
    @PrimaryKey
    private String id;

    private String ageGroup;

    private RealmList<QuestionItemModelGenderTuple> genderTupleFields;

    public DiseasesDataRow() {
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

    public RealmList<QuestionItemModelGenderTuple> getGenderTupleFields() {
        return genderTupleFields;
    }

    public void setGenderTupleFields(RealmList<QuestionItemModelGenderTuple> genderTupleFields) {
        this.genderTupleFields = genderTupleFields;
    }

    @Override
    public GenericEnumDataRow.AgeGroup getActualType() {
        return GenericEnumDataRow.AgeGroup.getValueOf(ageGroup);
    }

    @Override
    public void setupFields() {

        if (genderTupleFields == null) {
            genderTupleFields = new RealmList<>();
        }
        if (genderTupleFields.isEmpty()) {
            genderTupleFields = new RealmList<>();
            genderTupleFields.add(new QuestionItemModelGenderTuple(AppUtil.generateId(), "diarrhea", 0, 0));
            genderTupleFields.add(new QuestionItemModelGenderTuple(AppUtil.generateId(), "pneumonia", 0, 0));
            genderTupleFields.add(new QuestionItemModelGenderTuple(AppUtil.generateId(), "dengue", 0, 0));
            genderTupleFields.add(new QuestionItemModelGenderTuple(AppUtil.generateId(), "measles", 0, 0));
            genderTupleFields.add(new QuestionItemModelGenderTuple(AppUtil.generateId(), "others", 0, 0));
            genderTupleFields.add(new QuestionItemModelGenderTuple(AppUtil.generateId(), "checkup", 0, 0));
            genderTupleFields.add(new QuestionItemModelGenderTuple(AppUtil.generateId(), "hospitalization", 0, 0));
            genderTupleFields.add(new QuestionItemModelGenderTuple(AppUtil.generateId(), "medicines", 0, 0));
            genderTupleFields.add(new QuestionItemModelGenderTuple(AppUtil.generateId(), "others", 0, 0));
        }
    }

    @Override
    public void deleteData() {
        genderTupleFields.deleteAllFromRealm();
        deleteFromRealm();
    }
}
