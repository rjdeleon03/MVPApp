package com.cpu.quikdata.ModulesV2.FormList;

import com.cpu.quikdata.ModulesV2.Base.ListData.TemplateListAdapter;
import com.cpu.quikdata.ModulesV2.FormList.Item.IFormListItemViewModel;

import io.realm.OrderedRealmCollection;

public interface IFormListDataManager<LI> {

    void onListDataRetrieved(OrderedRealmCollection<LI> forms);

    OrderedRealmCollection<LI> getForms();

    TemplateListAdapter getAdapter();

    int getItemsCount();

    void navigateOnItemSubmitButtonPressed(String itemId, IFormListItemViewModel callback);

    void navigateOnItemSubmitFinished(boolean success);

    void navigateOnItemEditButtonPressed(String itemId);

    void navigateOnItemDeleteButtonPressed(String itemId);
}
