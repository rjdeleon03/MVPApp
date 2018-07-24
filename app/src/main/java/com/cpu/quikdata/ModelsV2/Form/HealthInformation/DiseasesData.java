package com.cpu.quikdata.ModelsV2.Form.HealthInformation;

import com.cpu.quikdata.ModelsV2.Base.IEnumDataRowHolder;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class DiseasesData extends RealmObject implements IEnumDataRowHolder<DiseasesDataRow> {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<DiseasesDataRow> rows;

    public DiseasesData() {
        if (rows == null) rows = new RealmList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public RealmList<DiseasesDataRow> getRows() {
        return rows;
    }

    @Override
    public void setRows(RealmList<DiseasesDataRow> rows) {
        this.rows = rows;
    }
}
