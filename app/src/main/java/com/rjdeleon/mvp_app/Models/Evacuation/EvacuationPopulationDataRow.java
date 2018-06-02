package com.rjdeleon.mvp_app.Models.Evacuation;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnum;
import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;

public class EvacuationPopulationDataRow extends GenericEnumDataRow {

    private int male;
    private int female;
    private int lgbt;
    private int pregnant;
    private int lactating;
    private int disabled;
    private int sick;

    public EvacuationPopulationDataRow(GenericEnum type, int male, int female, int lgbt, int pregnant, int lactating, int disabled, int sick) {
        super(type);
        this.male = male;
        this.female = female;
        this.lgbt = lgbt;
        this.pregnant = pregnant;
        this.lactating = lactating;
        this.disabled = disabled;
        this.sick = sick;
    }

    public EvacuationPopulationDataRow(AgeGroup ageGroup) {
        this(ageGroup, 0, 0, 0, 0, 0, 0, 0);
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }

    public int getFemale() {
        return female;
    }

    public void setFemale(int female) {
        this.female = female;
    }

    public int getLgbt() {
        return lgbt;
    }

    public void setLgbt(int lgbt) {
        this.lgbt = lgbt;
    }

    public int getPregnant() {
        return pregnant;
    }

    public void setPregnant(int pregnant) {
        this.pregnant = pregnant;
    }

    public int getLactating() {
        return lactating;
    }

    public void setLactating(int lactating) {
        this.lactating = lactating;
    }

    public int getDisabled() {
        return disabled;
    }

    public void setDisabled(int disabled) {
        this.disabled = disabled;
    }

    public int getSick() {
        return sick;
    }

    public void setSick(int sick) {
        this.sick = sick;
    }
}
