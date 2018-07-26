package com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRow;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class IncomeSourceDataRow extends RealmObject implements IEnumDataRow<GenericEnumDataRow.IncomeSourceType> {

    @Required
    @PrimaryKey
    private String id;

    private String incomeSourceType;

    private RealmList<QuestionItemModelString> stringFields;
    private RealmList<QuestionItemModelSingleNumber> numberFields;

    public IncomeSourceDataRow() {
        setupFields();
    }

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getIncomeSourceType() {
        return incomeSourceType;
    }

    public void setIncomeSourceType(String incomeSourceType) {
        this.incomeSourceType = incomeSourceType;
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
    public GenericEnumDataRow.IncomeSourceType getActualType() {
        return GenericEnumDataRow.IncomeSourceType.valueOf(incomeSourceType);
    }

    @Override
    public void setupFields() {

        if (stringFields == null) {
            stringFields = new RealmList<>();
        }
        if (stringFields.isEmpty()) {
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "incomeSource", ""));
        }

        if (numberFields == null) {
            numberFields = new RealmList<>();
        }
        if (numberFields.isEmpty()) {
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "dependentHouseholds", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "dependentMale", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "dependentFemale", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "dependentBoys", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "dependentGirls", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "averageIncome", 0));
        }
    }
}
