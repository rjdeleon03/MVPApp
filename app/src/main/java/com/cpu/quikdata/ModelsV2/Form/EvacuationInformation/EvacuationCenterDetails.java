package com.cpu.quikdata.ModelsV2.Form.EvacuationInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBoolean;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelDate;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class EvacuationCenterDetails extends RealmObject implements IFieldHolder {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<QuestionItemModelString> stringFields;
    private RealmList<QuestionItemModelMultChoice> multChoiceFields;
    private RealmList<QuestionItemModelBoolean> booleanFields;
    private RealmList<QuestionItemModelDate> dateFields;

    private RealmList<String> displacedChoices = new RealmList<>("displaced", "nonDisplaced");
    private RealmList<String> shelterChoices =
            new RealmList<>("plannedEvacuationCenter", "livingWithHost", "apartmentRent", "damagedHouse", "informalCamp", "makeshiftHouse", "squatting", "others");
    private RealmList<String> plannedEvacuationChoices = new RealmList<>("evacuationCenterBldg", "multipurposeHall", "church", "school", "gym");

    public EvacuationCenterDetails() {
        setupFields();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RealmList<String> getDisplacedChoices() {
        return displacedChoices;
    }

    public RealmList<String> getShelterChoices() {
        return shelterChoices;
    }

    public RealmList<String> getPlannedEvacuationChoices() {
        return plannedEvacuationChoices;
    }

    public RealmList<QuestionItemModelString> getStringFields() {
        return stringFields;
    }

    public void setStringFields(RealmList<QuestionItemModelString> stringFields) {
        this.stringFields = stringFields;
    }

    public RealmList<QuestionItemModelMultChoice> getMultChoiceFields() {
        return multChoiceFields;
    }

    public void setMultChoiceFields(RealmList<QuestionItemModelMultChoice> multChoiceFields) {
        this.multChoiceFields = multChoiceFields;
    }

    public RealmList<QuestionItemModelBoolean> getBooleanFields() {
        return booleanFields;
    }

    public void setBooleanFields(RealmList<QuestionItemModelBoolean> booleanFields) {
        this.booleanFields = booleanFields;
    }

    public RealmList<QuestionItemModelDate> getDateFields() {
        return dateFields;
    }

    public void setDateFields(RealmList<QuestionItemModelDate> dateFields) {
        this.dateFields = dateFields;
    }

    @Override
    public void setupFields() {

        if (stringFields == null) {
            stringFields = new RealmList<>();
        }
        if (stringFields.isEmpty()) {
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "evacuationCenterName", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "location", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "distanceFromCommunity", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "shelterSize", ""));
            stringFields.add(new QuestionItemModelString(AppUtil.generateId(), "evacuationFamiliesCount", ""));
        }

        if (multChoiceFields == null) {
            multChoiceFields = new RealmList<>();
        }
        if (multChoiceFields.isEmpty()) {
            multChoiceFields.add(new QuestionItemModelMultChoice(AppUtil.generateId(), "haveMoved", displacedChoices, 0));
            multChoiceFields.add(new QuestionItemModelMultChoice(AppUtil.generateId(), "shelterType", shelterChoices, 0));
            multChoiceFields.add(new QuestionItemModelMultChoice(AppUtil.generateId(), "plannedEvacuationType", plannedEvacuationChoices, 0));
        }

        if (booleanFields == null) {
            booleanFields = new RealmList<>();
        }
        if (booleanFields.isEmpty()) {
            booleanFields.add(new QuestionItemModelBoolean(AppUtil.generateId(), "isLguDesignated", false));
        }

        if (dateFields == null) {
            dateFields = new RealmList<>();
        }
        if (dateFields.isEmpty()) {
            dateFields.add(new QuestionItemModelDate(AppUtil.generateId(), "evacuationDate"));
        }
    }

    @Override
    public void deleteData() {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                stringFields.deleteAllFromRealm();
                multChoiceFields.deleteAllFromRealm();
                booleanFields.deleteAllFromRealm();
                dateFields.deleteAllFromRealm();
                deleteFromRealm();
            }
        });
    }
}