package com.cpu.quikdata.Models.GeneralInformation;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Generics.GenderTuple;

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
        this(ageGroup, new GenderTuple(), new GenderTuple(), new GenderTuple());
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
