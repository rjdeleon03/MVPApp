package com.cpu.quikdata.ModelsV2.Form;

import com.cpu.quikdata.ModelsV2.Form.FoodSecurityInformation.FoodSecurityInformation;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.GeneralInformation;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.HealthInformation;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.LivelihoodsInformation;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.ShelterInformation;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Form extends RealmObject {

    @Required
    @PrimaryKey
    private String id;

    @Required
    private String data;

    private FormDetails formDetails;
    private GeneralInformation generalInformation;
    private ShelterInformation shelterInformation;
    private FoodSecurityInformation foodSecurityInformation;
    private LivelihoodsInformation livelihoodsInformation;
    private HealthInformation healthInformation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public FormDetails getFormDetails() {
        return formDetails;
    }

    public void setFormDetails(FormDetails formDetails) {
        this.formDetails = formDetails;
    }

    public GeneralInformation getGeneralInformation() {
        return generalInformation;
    }

    public void setGeneralInformation(GeneralInformation generalInformation) {
        this.generalInformation = generalInformation;
    }

    public ShelterInformation getShelterInformation() {
        return shelterInformation;
    }

    public void setShelterInformation(ShelterInformation shelterInformation) {
        this.shelterInformation = shelterInformation;
    }

    public FoodSecurityInformation getFoodSecurityInformation() {
        return foodSecurityInformation;
    }

    public void setFoodSecurityInformation(FoodSecurityInformation foodSecurityInformation) {
        this.foodSecurityInformation = foodSecurityInformation;
    }

    public LivelihoodsInformation getLivelihoodsInformation() {
        return livelihoodsInformation;
    }

    public void setLivelihoodsInformation(LivelihoodsInformation livelihoodsInformation) {
        this.livelihoodsInformation = livelihoodsInformation;
    }

    public HealthInformation getHealthInformation() {
        return healthInformation;
    }

    public void setHealthInformation(HealthInformation healthInformation) {
        this.healthInformation = healthInformation;
    }
}
