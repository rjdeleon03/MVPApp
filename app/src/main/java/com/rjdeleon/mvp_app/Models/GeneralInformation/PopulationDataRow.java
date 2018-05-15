package com.rjdeleon.mvp_app.Models.GeneralInformation;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenderTuple;

public class PopulationDataRow extends GenericEnumDataRow {
    private GenderTuple total;
    private GenderTuple affected;
    private GenderTuple displaced;

    public PopulationDataRow(AgeGroup ageGroup, GenderTuple total, GenderTuple affected, GenderTuple displaced) {
        super(ageGroup);
        this.total = total;
        this.affected = affected;
        this.displaced = displaced;
    }

    public PopulationDataRow(AgeGroup ageGroup) {
        super(ageGroup);
        this.total = new GenderTuple();
        this.affected = new GenderTuple();
        this.displaced = new GenderTuple();
    }

    public GenderTuple getTotal() {
        return total;
    }

    public void setTotal(GenderTuple total) {
        this.total = total;
    }

    public GenderTuple getAffected() {
        return affected;
    }

    public void setAffected(GenderTuple affected) {
        this.affected = affected;
    }

    public GenderTuple getDisplaced() {
        return displaced;
    }

    public void setDisplaced(GenderTuple displaced) {
        this.displaced = displaced;
    }
}
