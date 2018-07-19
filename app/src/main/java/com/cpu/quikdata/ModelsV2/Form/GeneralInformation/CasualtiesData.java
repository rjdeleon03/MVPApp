package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import com.cpu.quikdata.ModelsV2.Base.IEnumDataRowHolder;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class CasualtiesData extends RealmObject implements IEnumDataRowHolder<CasualtiesDataRow> {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<CasualtiesDataRow> rows;

    public CasualtiesData() {
        rows = new RealmList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public RealmList<CasualtiesDataRow> getRows() {
        return rows;
    }

    @Override
    public void setRows(RealmList<CasualtiesDataRow> rows) {
        this.rows = rows;
    }
}
