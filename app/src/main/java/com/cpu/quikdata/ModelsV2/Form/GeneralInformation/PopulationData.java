package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class PopulationData extends RealmObject {

    @Required
    @PrimaryKey
    private String id;

    private List<PopulationDataRow> rows;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<PopulationDataRow> getRows() {
        return rows;
    }

    public void setRows(List<PopulationDataRow> rows) {
        this.rows = rows;
    }
}
