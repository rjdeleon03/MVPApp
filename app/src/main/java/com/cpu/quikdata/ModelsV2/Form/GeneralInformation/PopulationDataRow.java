package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.IQuestionItemModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class PopulationDataRow extends RealmObject implements IEnumDataRow<GenericEnumDataRow.AgeGroup, PopulationDataRow>, IFieldHolder {

    @Required
    @PrimaryKey
    private String id;

    private String ageGroup;

    private RealmList<QuestionItemModelGenderTuple> genderTupleFields;

    public PopulationDataRow() {
        setupFields();
    }

    public String getId() {
        return id;
    }

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
        return GenericEnumDataRow.AgeGroup.valueOf(ageGroup);
    }

    @Override
    public void update(PopulationDataRow newRow) {
    }

    @Override
    public void setupFields() {

        if (genderTupleFields == null) {
            genderTupleFields = new RealmList<>();
        }
        if (genderTupleFields.isEmpty()) {
            genderTupleFields = new RealmList<>();
            genderTupleFields.add(new QuestionItemModelGenderTuple(AppUtil.generateId(), "affected", 0, 0));
            genderTupleFields.add(new QuestionItemModelGenderTuple(AppUtil.generateId(), "displaced", 0, 0));
        }
    }
}
