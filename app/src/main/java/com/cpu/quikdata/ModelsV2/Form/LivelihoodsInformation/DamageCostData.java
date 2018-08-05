package com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation;

import com.cpu.quikdata.ModelsV2.Base.IEnumDataRowHolder;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class DamageCostData extends RealmObject implements IEnumDataRowHolder<DamageCostDataRow> {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<DamageCostDataRow> rows;

    public DamageCostData() {
        if (rows == null) rows = new RealmList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public RealmList<DamageCostDataRow> getRows() {
        return rows;
    }

    @Override
    public void setRows(RealmList<DamageCostDataRow> rows) {
        this.rows = rows;
    }

    @Override
    public void deleteData() {
        if (rows != null && !rows.isEmpty()) {
            for(int i = 0; i < rows.size(); i++) {
                if (rows.get(i) != null) rows.get(i).deleteData();
            }
        }
        deleteFromRealm();
    }
}
