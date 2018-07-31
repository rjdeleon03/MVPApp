package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import com.cpu.quikdata.ModelsV2.Base.IEnumDataRowHolder;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class VulnerableData extends RealmObject implements IEnumDataRowHolder<VulnerableDataRow> {

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

    @Override
    public RealmList<VulnerableDataRow> getRows() {
        return rows;
    }

    @Override
    public void setRows(RealmList<VulnerableDataRow> rows) {
        this.rows = rows;
    }

    @Override
    public void deleteData() {
        if (rows != null && !rows.isEmpty()) rows.deleteAllFromRealm();
        deleteFromRealm();
    }
}
