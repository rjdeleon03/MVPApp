package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class PopulationData extends RealmObject {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<PopulationDataRow> rows;

    public PopulationData() {
        rows = new RealmList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RealmList<PopulationDataRow> getRows() {
        return rows;
    }

    public void setRows(RealmList<PopulationDataRow> rows) {
        this.rows = rows;
    }
}
