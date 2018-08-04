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
     * Handles navigation when item's submit button is pressed
     * @param itemId
     */
    @Override
    public void navigateOnItemSubmitButtonPressed(String itemId) {
        for(Form formItem : mItems) {
            if (formItem.getId().equals(itemId)) {
                mFormRepository.submitForm(mViewComponent.get().getRealmInstance(), formItem);
                break;
            }
        }
        if (mViewComponent.get() != null) {
            mViewComponent.get().onItemSubmitButtonPressed(itemId);
        }
    }

    /**
     * Handles navigation when item's edit button is pressed
     * @param itemId
     */
    @Override
    public void navigateOnItemEditButtonPressed(String itemId) {
        if (mViewComponent.get() != null) {
            mViewComponent.get().onItemEditButtonPressed(itemId);
        }
    }

    /**
     * Handles navigation when items delete button is pressed
     * @param itemId
     */
    @Override
    public void navigateOnItemDeleteButtonPressed(String itemId) {
//        if (mViewComponent.get() != null) {
//            mViewComponent.get().onItemDeleteButtonPressed(mItems.get(itemIndex).getId());
//        }
        for(Form formItem : mItems) {
            if (formItem.getId().equals(itemId)) {
                mFormRepository.deleteForm(mViewComponent.get().getRealmInstance(), formItem);
                break;
            }
        }
    }


}
