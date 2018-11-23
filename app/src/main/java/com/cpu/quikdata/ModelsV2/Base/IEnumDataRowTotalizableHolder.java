package com.cpu.quikdata.ModelsV2.Base;

import io.realm.Realm;
import io.realm.RealmModel;

public interface IEnumDataRowTotalizableHolder extends RealmModel {

    void addTotalRow();
}
