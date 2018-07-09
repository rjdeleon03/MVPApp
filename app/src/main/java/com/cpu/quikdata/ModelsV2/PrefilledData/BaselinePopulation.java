package com.cpu.quikdata.ModelsV2.PrefilledData;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class BaselinePopulation extends RealmObject {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<BaselinePopulationRow> rows;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RealmList<BaselinePopulationRow> getRows() {
        return rows;
    }

    public void setRows(RealmList<BaselinePopulationRow> rows) {
        this.rows = rows;
    }
}
