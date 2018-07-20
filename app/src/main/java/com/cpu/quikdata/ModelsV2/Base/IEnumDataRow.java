package com.cpu.quikdata.ModelsV2.Base;

import io.realm.RealmModel;

public interface IEnumDataRow<T> extends RealmModel, IFieldHolder {

    T getActualType();
}
