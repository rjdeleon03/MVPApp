package com.cpu.quikdata.ModelsV2.Form.EvacuationInformation;

import com.cpu.quikdata.ModelsV2.Base.IEnumDataRowHolder;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class EvacuationInfoList extends RealmObject implements IEnumDataRowHolder<EvacuationItem> {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<EvacuationItem> rows;

    public EvacuationInfoList() {
        if (rows == null) rows = new RealmList<>();
    }

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
