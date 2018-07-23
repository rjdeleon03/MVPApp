package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import com.cpu.quikdata.ModelsV2.Base.IEnumDataRowHolder;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class PopulationData extends RealmObject implements IEnumDataRowHolder<PopulationDataRow> {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<PopulationDataRow> rows;

    public PopulationData() {
        if (rows == null) rows = new RealmList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public RealmList<PopulationDataRow> getRows() {
        return rows;
    }

    @Override
    public void setRows(RealmList<PopulationDataRow> rows) {
        this.rows = rows;
    }
}
