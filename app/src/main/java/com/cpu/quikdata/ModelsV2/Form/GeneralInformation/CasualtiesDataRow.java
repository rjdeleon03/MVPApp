package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class CasualtiesDataRow extends RealmObject implements IEnumDataRow<GenericEnumDataRow.AgeGroup> {

    @Required
    @PrimaryKey
    private String id;

    private String ageGroup;

    private RealmList<QuestionItemModelGenderTuple> genderTupleFields;

    public CasualtiesDataRow() {
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
        return GenericEnumDataRow.AgeGroup.valueOf(ageGroup);
    }

    @Override
    public void setupFields() {

        if (genderTupleFields == null) {
            genderTupleFields = new RealmList<>();
        }
        if (genderTupleFields.isEmpty()) {
            genderTupleFields.add(new QuestionItemModelGenderTuple(AppUtil.generateId(), "dead", 0, 0));
            genderTupleFields.add(new QuestionItemModelGenderTuple(AppUtil.generateId(), "missing", 0, 0));
            genderTupleFields.add(new QuestionItemModelGenderTuple(AppUtil.generateId(), "injured", 0, 0));
        }
    }

    @Override
    public void deleteData() {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                genderTupleFields.deleteAllFromRealm();
                deleteFromRealm();
            }
        });
    }
}
