package com.rjdeleon.mvp_app.Models.GeneralInformation;

import com.rjdeleon.mvp_app.Models.Generics.AgeGroupDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenderTuple;

public class DeathCauseDataRow extends AgeGroupDataRow {
    private GenderTuple measles;
    private GenderTuple diarrhea;
    private GenderTuple pneumonia;
    private GenderTuple dengue;
    private GenderTuple drowning;
    private GenderTuple heartAttack;
    private GenderTuple electrocution;
    private GenderTuple collapsedBuilding;
    private GenderTuple others;

    public DeathCauseDataRow(AgeGroup ageGroup, GenderTuple measles, GenderTuple diarrhea, GenderTuple pneumonia, GenderTuple dengue, GenderTuple drowning, GenderTuple heartAttack, GenderTuple electrocution, GenderTuple collapsedBuilding, GenderTuple others) {
        super(ageGroup);
        this.measles = measles;
        this.diarrhea = diarrhea;
        this.pneumonia = pneumonia;
        this.dengue = dengue;
        this.drowning = drowning;
        this.heartAttack = heartAttack;
        this.electrocution = electrocution;
        this.collapsedBuilding = collapsedBuilding;
        this.others = others;
    }

    public DeathCauseDataRow(AgeGroup ageGroup) {
        super(ageGroup);
        this.measles = new GenderTuple();
        this.diarrhea = new GenderTuple();
        this.pneumonia = new GenderTuple();
        this.dengue = new GenderTuple();
        this.drowning = new GenderTuple();
        this.heartAttack = new GenderTuple();
        this.electrocution = new GenderTuple();
        this.collapsedBuilding = new GenderTuple();
        this.others = new GenderTuple();
    }

    public GenderTuple getMeasles() {
        return measles;
    }

    public void setMeasles(GenderTuple measles) {
        this.measles = measles;
    }

    public GenderTuple getDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(GenderTuple diarrhea) {
        this.diarrhea = diarrhea;
    }

    public GenderTuple getPneumonia() {
        return pneumonia;
    }

    public void setPneumonia(GenderTuple pneumonia) {
        this.pneumonia = pneumonia;
    }

    public GenderTuple getDengue() {
        return dengue;
    }

    public void setDengue(GenderTuple dengue) {
        this.dengue = dengue;
    }

    public GenderTuple getDrowning() {
        return drowning;
    }

    public void setDrowning(GenderTuple drowning) {
        this.drowning = drowning;
    }

    public GenderTuple getHeartAttack() {
        return heartAttack;
    }

    public void setHeartAttack(GenderTuple heartAttack) {
        this.heartAttack = heartAttack;
    }

    public GenderTuple getElectrocution() {
        return electrocution;
    }

    public void setElectrocution(GenderTuple electrocution) {
        this.electrocution = electrocution;
    }

    public GenderTuple getCollapsedBuilding() {
        return collapsedBuilding;
    }

    public void setCollapsedBuilding(GenderTuple collapsedBuilding) {
        this.collapsedBuilding = collapsedBuilding;
    }

    public GenderTuple getOthers() {
        return others;
    }

    public void setOthers(GenderTuple others) {
        this.others = others;
    }
}
