package com.cpu.quikdata.ModulesV2.FormList;

import com.cpu.quikdata.IBaseActivity;
import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;

import io.realm.Realm;

public interface IFormListActivity extends IBaseActivity {

    void onAddButtonPressed();

    void onItemSubmitButtonPressed(String id);

    void onItemSubmitFinished(boolean success);

    void onItemEditButtonPressed(String id);

    void onItemDeleteButtonPressed(String id);

    Realm getRealmInstance();
}
