package com.cpu.quikdata.ModulesV2.FormList;

import com.cpu.quikdata.ModulesV2.Base.ListData.TemplateListAdapter;

import io.realm.OrderedRealmCollection;

public interface IFormListDataManager<LI> {

    void onListDataRetrieved(OrderedRealmCollection<LI> forms);

    OrderedRealmCollection<LI> getForms();

    TemplateListAdapter getAdapter();

    int getItemsCount();

    void navigateOnItemEditButtonPressed(int itemIndex);
}
