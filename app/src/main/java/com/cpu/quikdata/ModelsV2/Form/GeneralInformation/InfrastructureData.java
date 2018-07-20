package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import com.cpu.quikdata.ModelsV2.Base.IEnumDataRowHolder;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class InfrastructureData extends RealmObject implements IEnumDataRowHolder<InfrastructureDataRow> {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<InfrastructureDataRow> rows;

    public InfrastructureData() {
        rows = new RealmList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public RealmList<InfrastructureDataRow> getRows() {
        return rows;
    }

    @Override
    public void setRows(RealmList<InfrastructureDataRow> rows) {
        this.rows = rows;
    }
}
