package com.cpu.quikdata.ModelsV2.Form.HealthInformation;

import com.cpu.quikdata.ModelsV2.Base.IEnumDataRowHolder;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class PsychosocialData extends RealmObject implements IEnumDataRowHolder<PsychosocialDataRow> {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<PsychosocialDataRow> rows;

    public PsychosocialData() {
        if (rows == null) rows = new RealmList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public RealmList<PsychosocialDataRow> getRows() {
        return rows;
    }

    @Override
    public void setRows(RealmList<PsychosocialDataRow> rows) {
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
