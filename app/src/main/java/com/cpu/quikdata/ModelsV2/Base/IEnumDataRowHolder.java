package com.cpu.quikdata.ModelsV2.Base;

import io.realm.RealmList;
import io.realm.RealmModel;

public interface IEnumDataRowHolder<R> extends RealmModel {

    RealmList<R> getRows();

    void setRows(RealmList<R> rows);
}