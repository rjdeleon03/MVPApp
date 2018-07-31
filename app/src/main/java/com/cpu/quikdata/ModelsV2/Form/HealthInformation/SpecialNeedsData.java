package com.cpu.quikdata.ModelsV2.Form.HealthInformation;

import com.cpu.quikdata.ModelsV2.Base.IEnumDataRowHolder;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class SpecialNeedsData extends RealmObject implements IEnumDataRowHolder<SpecialNeedsDataRow> {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<SpecialNeedsDataRow> rows;

    public SpecialNeedsData() {
        if (rows == null) rows = new RealmList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public RealmList<SpecialNeedsDataRow> getRows() {
        return rows;
    }

    @Override
    public void setRows(RealmList<SpecialNeedsDataRow> rows) {
        this.rows = rows;
    }

    @Override
    public void deleteData() {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (rows != null && !rows.isEmpty()) rows.deleteAllFromRealm();
                deleteFromRealm();
            }
        });
    }
}
