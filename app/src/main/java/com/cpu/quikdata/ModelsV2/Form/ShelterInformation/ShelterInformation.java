package com.cpu.quikdata.ModelsV2.Form.ShelterInformation;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class ShelterInformation extends RealmObject {

    @Required
    @PrimaryKey
    private String id;

    private DamageData damageData;
    private ShelterCopingDetails shelterCopingDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DamageData getDamageData() {
        return damageData;
    }

    public void setDamageData(DamageData damageData) {
        this.damageData = damageData;
    }

    public ShelterCopingDetails getShelterCopingDetails() {
        return shelterCopingDetails;
    }

    public void setShelterCopingDetails(ShelterCopingDetails shelterCopingDetails) {
        this.shelterCopingDetails = shelterCopingDetails;
    }
}
