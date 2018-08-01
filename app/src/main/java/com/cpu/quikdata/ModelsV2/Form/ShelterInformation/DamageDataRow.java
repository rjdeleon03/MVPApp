package com.cpu.quikdata.ModelsV2.Form.ShelterInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRow;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelTextOnly;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class DamageDataRow extends RealmObject implements IEnumDataRow<GenericEnumDataRow.HouseType> {

    @Required
    @PrimaryKey
    private String id;

    private String houseType;

    private RealmList<QuestionItemModelSingleNumber> numberFields;

    public DamageDataRow() {
        setupFields();
    }

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public RealmList<QuestionItemModelSingleNumber> getNumberFields() {
        return numberFields;
    }

    public void setNumberFields(RealmList<QuestionItemModelSingleNumber> numberFields) {
        this.numberFields = numberFields;
    }

    @Override
    public GenericEnumDataRow.HouseType getActualType() {
        return GenericEnumDataRow.HouseType.getValueOf(houseType);
    }

    @Override
    public void setupFields() {

        if (numberFields == null) {
            numberFields = new RealmList<>();
        }
        if (numberFields.isEmpty()) {
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "ownedHouse", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "rentedHouse", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "sharedHouse", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "ownedLand", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "rentedLand", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "tenantedLand", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "informalSettlerFams", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "partialDamageHouses", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "fullDamageHouses", 0));
        }
    }

    @Override
    public void deleteData() {
        numberFields.deleteAllFromRealm();
        deleteFromRealm();
    }
}
