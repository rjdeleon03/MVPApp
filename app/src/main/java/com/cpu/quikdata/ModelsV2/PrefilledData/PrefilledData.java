package com.cpu.quikdata.ModelsV2.PrefilledData;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class PrefilledData extends RealmObject {

    private BaselinePopulation baselinePopulation;

    private BaselineFamilies baselineFamilies;

    private BaselineHouses baselineHouses;

    public BaselinePopulation getBaselinePopulation() {
        return baselinePopulation;
    }

    public void setBaselinePopulation(BaselinePopulation baselinePopulation) {
        this.baselinePopulation = baselinePopulation;
    }

    public BaselineFamilies getBaselineFamilies() {
        return baselineFamilies;
    }

    public void setBaselineFamilies(BaselineFamilies baselineFamilies) {
        this.baselineFamilies = baselineFamilies;
    }

    public BaselineHouses getBaselineHouses() {
        return baselineHouses;
    }

    public void setBaselineHouses(BaselineHouses baselineHouses) {
        this.baselineHouses = baselineHouses;
    }
}
