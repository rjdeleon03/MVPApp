package com.cpu.quikdata.ModelsV2.Form.Common;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRow;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelDate;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelTextOnly;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class AssistanceDataRow extends RealmObject implements IEnumDataRow<GenericEnumDataRow.AssistanceType> {

    @Required
    @PrimaryKey
    private String id;

    private String type = GenericEnumDataRow.AssistanceType.ASSISTANCE.toString();
    private RealmList<QuestionItemModelString> stringFields;
    private RealmList<QuestionItemModelDate> dateFields;
    private RealmList<QuestionItemModelSingleNumber> numberFields;
    private RealmList<QuestionItemModelTextOnly> textOnlyFields;

    public AssistanceDataRow() {
        setupFields();
    }

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public RealmList<QuestionItemModelString> getStringFields() {
        return stringFields;
    }

    public void setStringFields(RealmList<QuestionItemModelString> stringFields) {
        this.stringFields = stringFields;
    }

    public RealmList<QuestionItemModelDate> getDateFields() {
        return dateFields;
    }

    public void setDateFields(RealmList<QuestionItemModelDate> dateFields) {
        this.dateFields = dateFields;
    }

    public RealmList<QuestionItemModelSingleNumber> getNumberFields() {
        return numberFields;
    }

    public void setNumberFields(RealmList<QuestionItemModelSingleNumber> numberFields) {
        this.numberFields = numberFields;
    }

    public RealmList<QuestionItemModelTextOnly> getTextOnlyFields() {
        return textOnlyFields;
    }

    public void setTextOnlyFields(RealmList<QuestionItemModelTextOnly> textOnlyFields) {
        this.textOnlyFields = textOnlyFields;
    }

    @Override
    public GenericEnumDataRow.AssistanceType getActualType() {
        return GenericEnumDataRow.AssistanceType.ASSISTANCE;
    }

    @Override
    public void setupFields() {
        if (stringFields == null) {
            stringFields = new RealmList<>();
        }
        if (stringFields.isEmpty()) {
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "assistanceDonor", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "assistanceType", ""));
        }

        if (dateFields == null) {
            dateFields = new RealmList<>();
        }
        if (dateFields.isEmpty()) {
            dateFields.add(new QuestionItemModelDate(AppUtil.generateId(), "assistanceDateReceived"));
        }

        if (numberFields == null) {
            numberFields = new RealmList<>();
        }
        if (numberFields.isEmpty()) {
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "assistanceQuantity", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "men", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "women", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "boys", 0));
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "girls", 0));
        }

        if (textOnlyFields == null) {
            textOnlyFields = new RealmList<>();
        }
        if (textOnlyFields.isEmpty()) {
            textOnlyFields.add(new QuestionItemModelTextOnly(AppUtil.generateId(), "beneficiaries"));
        }
    }
}
