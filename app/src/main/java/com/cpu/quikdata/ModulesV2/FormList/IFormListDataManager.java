package com.cpu.quikdata.ModulesV2.FormList;

import com.cpu.quikdata.ModelsV2.Form.Form;

import io.realm.RealmResults;

public interface IFormListDataManager {

    void onFormListDataRetrieved(RealmResults<Form> forms);

    RealmResults<Form> getForms();

    FormListAdapter getAdapter();

    int getItemsCount();
}
