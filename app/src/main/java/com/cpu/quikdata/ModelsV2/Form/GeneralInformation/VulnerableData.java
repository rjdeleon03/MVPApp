package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class VulnerableData extends RealmObject {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<VulnerableDataRow> rows;

    public VulnerableData() {
        rows = new RealmList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RealmList<VulnerableDataRow> getRows() {
        return rows;
    }

    public void setRows(RealmList<VulnerableDataRow> rows) {
        this.rows = rows;
    }
}
