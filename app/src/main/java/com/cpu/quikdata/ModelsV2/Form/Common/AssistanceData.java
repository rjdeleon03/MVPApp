package com.cpu.quikdata.ModelsV2.Form.Common;

import com.cpu.quikdata.ModelsV2.Base.IEnumDataRowHolder;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class AssistanceData extends RealmObject implements IEnumDataRowHolder<AssistanceDataRow> {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<AssistanceDataRow> rows;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public RealmList<AssistanceDataRow> getRows() {
        return rows;
    }

    @Override
    public void setRows(RealmList<AssistanceDataRow> rows) {
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
