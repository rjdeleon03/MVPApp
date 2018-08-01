package com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRow;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBoolean;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBooleanGroup;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class DamageCostDataRow extends RealmObject implements IEnumDataRow<GenericEnumDataRow.LivelihoodsType> {

    @Required
    @PrimaryKey
    private String id;

    private String livelihoodsType;

    private QuestionItemModelBooleanGroup booleanGroup;
    private RealmList<QuestionItemModelString> stringFields;
    private RealmList<QuestionItemModelSingleNumber> numberFields;

    public DamageCostDataRow() {
        setupFields();
    }

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getLivelihoodsType() {
        return livelihoodsType;
    }

    public void setLivelihoodsType(String livelihoodsType) {
        this.livelihoodsType = livelihoodsType;
        setupBasedOnType();
    }

    public QuestionItemModelBooleanGroup getBooleanGroup() {
        return booleanGroup;
    }

    public void setBooleanGroup(QuestionItemModelBooleanGroup booleanGroup) {
        this.booleanGroup = booleanGroup;
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
    public GenericEnumDataRow.LivelihoodsType getActualType() {
        return GenericEnumDataRow.LivelihoodsType.getValueOf(livelihoodsType);
    }

    @Override
    public void setupFields() {

        if (livelihoodsType != null) setupBasedOnType();

        if (numberFields == null) {
            numberFields = new RealmList<>();
        }
        if (numberFields.isEmpty()) {
            numberFields.add(new QuestionItemModelSingleNumber(AppUtil.generateId(), "estimatedDamageCost", 0));
        }

        if (stringFields == null) {
            stringFields = new RealmList<>();
        }
        if (stringFields.isEmpty()) {
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "remarks", ""));
        }
    }

    private void setupBasedOnType() {

        if (booleanGroup == null) {
            booleanGroup = new QuestionItemModelBooleanGroup(AppUtil.generateId(), "livelihoodTypes");
        }
        RealmList<QuestionItemModelBoolean> booleanFields = null;
        if (booleanGroup.getBooleanFields() == null) {
            booleanFields = new RealmList<>();
            booleanGroup.setBooleanFields(booleanFields);
        }
        if (booleanFields != null && booleanFields.isEmpty()) {

            switch (getActualType()) {
                case FARMING:
                    booleanFields.add(new QuestionItemModelBoolean(AppUtil.generateId(), "rice", false));
                    booleanFields.add(new QuestionItemModelBoolean(AppUtil.generateId(), "corn", false));
                    booleanFields.add(new QuestionItemModelBoolean(AppUtil.generateId(), "vegetable", false));
                    booleanFields.add(new QuestionItemModelBoolean(AppUtil.generateId(), "fruits", false));
                    booleanFields.add(new QuestionItemModelBoolean(AppUtil.generateId(), "livestock", false));
                    booleanFields.add(new QuestionItemModelBoolean(AppUtil.generateId(), "others", false));
                    break;

                case FISHING:
                    booleanFields.add(new QuestionItemModelBoolean(AppUtil.generateId(), "boat", false));
                    booleanFields.add(new QuestionItemModelBoolean(AppUtil.generateId(), "fishingEquipment", false));
                    booleanFields.add(new QuestionItemModelBoolean(AppUtil.generateId(), "aquacultures", false));
                    booleanFields.add(new QuestionItemModelBoolean(AppUtil.generateId(), "others", false));
                    break;

                case TRANSPORTATION:
                    booleanFields.add(new QuestionItemModelBoolean(AppUtil.generateId(), "jeepney", false));
                    booleanFields.add(new QuestionItemModelBoolean(AppUtil.generateId(), "tricycle", false));
                    booleanFields.add(new QuestionItemModelBoolean(AppUtil.generateId(), "van", false));
                    booleanFields.add(new QuestionItemModelBoolean(AppUtil.generateId(), "others", false));
                    break;

                case ENTREPRENEURSHIP:
                    booleanFields.add(new QuestionItemModelBoolean(AppUtil.generateId(), "vendor", false));
                    booleanFields.add(new QuestionItemModelBoolean(AppUtil.generateId(), "sariSariStore", false));
                    booleanFields.add(new QuestionItemModelBoolean(AppUtil.generateId(), "others", false));
                    break;

                case WORKERS:
                    booleanFields.add(new QuestionItemModelBoolean(AppUtil.generateId(), "employees", false));
                    booleanFields.add(new QuestionItemModelBoolean(AppUtil.generateId(), "laborers", false));
                    break;
            }
        }
    }

    @Override
    public void deleteData() {
        booleanGroup.getBooleanFields().deleteAllFromRealm();
        booleanGroup.deleteFromRealm();
        stringFields.deleteAllFromRealm();
        numberFields.deleteAllFromRealm();
        deleteFromRealm();
    }
}
