package com.cpu.quikdata.ModulesV2.FormList;

import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;

import io.realm.Realm;

public interface IFormListActivity extends IBaseInterface {

    void onAddButtonPressed();

    Realm getRealmInstance();
}
