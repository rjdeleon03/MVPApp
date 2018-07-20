package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRow;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class DeathCauseDataRow extends RealmObject implements IEnumDataRow<GenericEnumDataRow.AgeGroup, DeathCauseDataRow> {

    @Required
    @PrimaryKey
    private String id;

    private String ageGroup;
    private int measlesMale;
    private int measlesFemale;
    private int diarrheaMale;
    private int diarrheaFemale;
    private int pneumoniaMale;
    private int pneumoniaFemale;
    private int dengueMale;
    private int dengueFemale;
    private int drowningMale;
    private int drowningFemale;
    private int heartAttackMale;
    private int heartAttackFemale;
    private int electrocutionMale;
    private int electrocutionFemale;
    private int collapsedMale;
    private int collapsedFemale;
    private int othersMale;
    private int othersFemale;

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

    public int getMeaslesMale() {
        return measlesMale;
    }

    public void setMeaslesMale(int measlesMale) {
        this.measlesMale = measlesMale;
    }

    public int getMeaslesFemale() {
        return measlesFemale;
    }

    public void setMeaslesFemale(int measlesFemale) {
        this.measlesFemale = measlesFemale;
    }

    public int getDiarrheaMale() {
        return diarrheaMale;
    }

    public void setDiarrheaMale(int diarrheaMale) {
        this.diarrheaMale = diarrheaMale;
    }

    public int getDiarrheaFemale() {
        return diarrheaFemale;
    }

    public void setDiarrheaFemale(int diarrheaFemale) {
        this.diarrheaFemale = diarrheaFemale;
    }

    public int getPneumoniaMale() {
        return pneumoniaMale;
    }

    public void setPneumoniaMale(int pneumoniaMale) {
        this.pneumoniaMale = pneumoniaMale;
    }

    public int getPneumoniaFemale() {
        return pneumoniaFemale;
    }

    public void setPneumoniaFemale(int pneumoniaFemale) {
        this.pneumoniaFemale = pneumoniaFemale;
    }

    public int getDengueMale() {
        return dengueMale;
    }

    public void setDengueMale(int dengueMale) {
        this.dengueMale = dengueMale;
    }

    public int getDengueFemale() {
        return dengueFemale;
    }

    public void setDengueFemale(int dengueFemale) {
        this.dengueFemale = dengueFemale;
    }

    public int getDrowningMale() {
        return drowningMale;
    }

    public void setDrowningMale(int drowningMale) {
        this.drowningMale = drowningMale;
    }

    public int getDrowningFemale() {
        return drowningFemale;
    }

    public void setDrowningFemale(int drowningFemale) {
        this.drowningFemale = drowningFemale;
    }

    public int getHeartAttackMale() {
        return heartAttackMale;
    }

    public void setHeartAttackMale(int heartAttackMale) {
        this.heartAttackMale = heartAttackMale;
    }

    public int getHeartAttackFemale() {
        return heartAttackFemale;
    }

    public void setHeartAttackFemale(int heartAttackFemale) {
        this.heartAttackFemale = heartAttackFemale;
    }

    public int getElectrocutionMale() {
        return electrocutionMale;
    }

    public void setElectrocutionMale(int electrocutionMale) {
        this.electrocutionMale = electrocutionMale;
    }

    public int getElectrocutionFemale() {
        return electrocutionFemale;
    }

    public void setElectrocutionFemale(int electrocutionFemale) {
        this.electrocutionFemale = electrocutionFemale;
    }

    public int getCollapsedMale() {
        return collapsedMale;
    }

    public void setCollapsedMale(int collapsedMale) {
        this.collapsedMale = collapsedMale;
    }

    public int getCollapsedFemale() {
        return collapsedFemale;
    }

    public void setCollapsedFemale(int collapsedFemale) {
        this.collapsedFemale = collapsedFemale;
    }

    public int getOthersMale() {
        return othersMale;
    }

    public void setOthersMale(int othersMale) {
        this.othersMale = othersMale;
    }

    public int getOthersFemale() {
        return othersFemale;
    }

    public void setOthersFemale(int othersFemale) {
        this.othersFemale = othersFemale;
    }

    @Override
    public GenericEnumDataRow.AgeGroup getActualType() {
        return GenericEnumDataRow.AgeGroup.valueOf(ageGroup);
    }

    @Override
    public void update(DeathCauseDataRow newRow) {
        measlesMale = newRow.getMeaslesMale();
        measlesFemale = newRow.getMeaslesFemale();
        diarrheaMale = newRow.getDiarrheaMale();
        diarrheaFemale = newRow.getDiarrheaFemale();
        pneumoniaMale = newRow.getPneumoniaMale();
        pneumoniaFemale = newRow.getPneumoniaFemale();
        dengueMale = newRow.getDengueMale();
        dengueFemale = newRow.getDengueFemale();
        drowningMale = newRow.getDrowningMale();
        drowningFemale = newRow.getDrowningFemale();
        heartAttackMale = newRow.getHeartAttackMale();
        heartAttackFemale = newRow.getHeartAttackFemale();
        electrocutionMale = newRow.getElectrocutionMale();
        electrocutionFemale = newRow.getElectrocutionFemale();
        collapsedMale = newRow.getCollapsedMale();
        collapsedFemale = newRow.getCollapsedFemale();
        othersMale = newRow.getOthersMale();
        othersFemale = newRow.getOthersFemale();
    }
}
