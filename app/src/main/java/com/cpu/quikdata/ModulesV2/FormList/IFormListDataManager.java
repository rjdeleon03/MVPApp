package com.cpu.quikdata.ModulesV2.FormList;

import com.cpu.quikdata.ModelsV2.Form.Form;

import io.realm.RealmResults;

public interface IFormListDataManager<LI> {

    void onFormListDataRetrieved(RealmResults<LI> forms);

    RealmResults<LI> getForms();

    FormListAdapter getAdapter();

    int getItemsCount();
}
