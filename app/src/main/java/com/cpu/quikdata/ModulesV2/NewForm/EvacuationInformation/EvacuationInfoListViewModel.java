package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationInformation;
import com.cpu.quikdata.ModulesV2.Base.ListData.TemplateListDataViewModel;
import com.cpu.quikdata.ModulesV2.FormList.IFormListActivity;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;

import io.realm.Realm;

public class EvacuationInfoListViewModel extends TemplateListDataViewModel<INewFormActivity, EvacuationInformation> {



    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public EvacuationInfoListViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        dncaFormRepository.getEvacuationInformation(this);
    }

    /**
     * Sets up the adapter
     */
    @Override
    protected void setupAdapter() {
        mAdapter = new EvacuationInfoListAdapter(this);
    }

    /**
     * Handles the navigation when add button is pressed
     */
    @Override
    public void navigateOnAddButtonPressed() {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                mItems.add(realm.createObject(EvacuationInformation.class, AppUtil.generateId()));
                refreshData();
            }
        });
    }
}
