package com.cpu.quikdata.Models.GeneralInformation;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Generics.GenderTuple;

public class CasualtiesDataRow extends GenericEnumDataRow {
    private GenderTuple dead;
    private GenderTuple missing;
    private GenderTuple injured;

    public CasualtiesDataRow(AgeGroup ageGroup, GenderTuple dead, GenderTuple missing, GenderTuple injured) {
        super(ageGroup);
        this.dead = dead;
        this.missing = missing;
        this.injured = injured;
    }

    public CasualtiesDataRow(AgeGroup ageGroup) {
        super(ageGroup);
        this.dead = new GenderTuple();
        this.missing = new GenderTuple();
        this.injured = new GenderTuple();
    }

    public GenderTuple getDead() {
        return dead;
    }

    public void setDead(GenderTuple dead) {
        this.dead = dead;
    }

    public GenderTuple getMissing() {
        return missing;
    }

    public void setMissing(GenderTuple missing) {
        this.missing = missing;
    }

    public GenderTuple getInjured() {
        return injured;
    }

    public void setInjured(GenderTuple injured) {
        this.injured = injured;
    }
}
