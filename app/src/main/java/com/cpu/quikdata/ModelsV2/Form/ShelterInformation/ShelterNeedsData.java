package com.cpu.quikdata.ModelsV2.Form.ShelterInformation;

import com.cpu.quikdata.ModelsV2.Base.IEnumDataRowHolder;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class ShelterNeedsData extends RealmObject implements IEnumDataRowHolder<ShelterNeedsDataRow> {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<ShelterNeedsDataRow> rows;

    public ShelterNeedsData() {
        if (rows == null) rows = new RealmList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public RealmList<ShelterNeedsDataRow> getRows() {
        return rows;
    }

    @Override
    public void setRows(RealmList<ShelterNeedsDataRow> rows) {
        this.rows = rows;
    }

    @Override
    public void deleteData() {
        if (rows != null && !rows.isEmpty()) rows.deleteAllFromRealm();
        deleteFromRealm();
    }
}
