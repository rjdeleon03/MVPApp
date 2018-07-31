package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class FamilyDetails extends RealmObject implements IFieldHolder {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<QuestionItemModelSingleNumber> numberFields;

    public FamilyDetails() {
        setupFields();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RealmList<QuestionItemModelSingleNumber> getNumberFields() {
        return numberFields;
    }

    public void setNumberFields(RealmList<QuestionItemModelSingleNumber> numberFields) {
        this.numberFields = numberFields;
    }

    @Override
    public void setupFields() {
        if (numberFields == null) {
            numberFields = new RealmList<>();
        }
        if (numberFields.isEmpty()) {
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "affectedFamilies", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "affectedHouseholds", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "displacedFamilies", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "displacedHouseholds", 0));
        }
    }

    @Override
    public void deleteData() {
        numberFields.deleteAllFromRealm();
        deleteFromRealm();
    }
}
