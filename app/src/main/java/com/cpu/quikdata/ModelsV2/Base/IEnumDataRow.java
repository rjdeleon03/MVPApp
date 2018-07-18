package com.cpu.quikdata.ModelsV2.Base;

import io.realm.RealmModel;

public interface IEnumDataRow<T, R> extends RealmModel {

    T getActualType();

    void update(R newRow);
}
