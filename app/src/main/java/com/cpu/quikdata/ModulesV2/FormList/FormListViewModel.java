package com.cpu.quikdata.ModulesV2.FormList;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.Form;
import com.cpu.quikdata.ModulesV2.Base.ListData.TemplateListDataViewModel;

public class FormListViewModel extends TemplateListDataViewModel<IFormListActivity, Form> {

    /**
     * Constructor
     */
    public FormListViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    @Override
    public void setViewComponent(IFormListActivity viewComponent) {
        super.setViewComponent(viewComponent);
        if (mViewComponent.get() != null) {
            mFormRepository.getAllForms(mViewComponent.get().getRealmInstance(), this);
        }
    }

    /**
     * Sets up the adapter
     */
    @Override
    protected void setupAdapter() {
        mAdapter = new FormListAdapter(mItems, true, this);
    }

    /**
     * Handles navigation when add button is pressed
     */
    @Override
    public void navigateOnAddButtonPressed() {
        if (mViewComponent.get() != null) {
            mViewComponent.get().onAddButtonPressed();
        }
    }

    /**
     * Handles navigation when item's edit button is pressed
     * @param itemIndex
     */
    @Override
    public void navigateOnItemEditButtonPressed(int itemIndex) {
        if (mViewComponent.get() != null) {
            mViewComponent.get().onItemEditButtonPressed(mItems.get(itemIndex).getId());
        }
    }
}
