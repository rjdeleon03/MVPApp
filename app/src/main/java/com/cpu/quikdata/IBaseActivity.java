package com.cpu.quikdata;

import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;

import io.realm.Realm;

public interface IBaseActivity extends IBaseInterface {

    Realm getRealmInstance();

    void displayToastMessage(String text, int toastLength);
}
