package com.cpu.quikdata.ModelsV2.Form.EvacuationInformation;

import com.cpu.quikdata.ModelsV2.Base.IEnumDataRowHolder;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class EvacuationInfoList extends RealmObject implements IEnumDataRowHolder<EvacuationItem> {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<EvacuationItem> rows;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public RealmList<EvacuationItem> getRows() {
        return rows;
    }

    @Override
    public void setRows(RealmList<EvacuationItem> rows) {
        this.rows = rows;
    }
}
