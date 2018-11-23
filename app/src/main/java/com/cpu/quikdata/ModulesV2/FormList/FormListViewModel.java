package com.cpu.quikdata.ModulesV2.FormList;

import android.databinding.Bindable;
import android.widget.Toast;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.Form;
import com.cpu.quikdata.ModulesV2.Base.ListData.TemplateListDataViewModel;
import com.cpu.quikdata.ModulesV2.FormList.Item.IFormListItemViewModel;

import com.cpu.quikdata.BR;

import io.realm.Realm;

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
    }

    /**
     * Prepares necessary data when parent activity has been created
     */
    public void onActivityCreated() {
        if (mViewComponent != null && mViewComponent.get() != null) {

            // Initialize prefilled data
            Realm realm = mViewComponent.get().getRealmInstance();
            mFormRepository.initializePrefilledData(realm);

            // Retrieve all forms
            // TODO: Load forms async to avoid slow startup
            mFormRepository.getAllForms(realm, this);
        }
    }

    /**
     * Sets up the adapter
     */
    @Override
    protected void setupAdapter() {
        mAdapter = new FormListAdapter(this);
    }

    /**
     * Retrieves flag to determine if add button should be enabled
     * @return
     */
    @Bindable
    @Override
    public boolean getAddButtonEnabled() {
        return mItems.size() < 10;
    }

    /**
     * Handles navigation when add button is pressed
     */
    @Override
    public void navigateOnAddButtonPressed() {
        if (mViewComponent.get() != null) {

            if (getAddButtonEnabled()) {
                mViewComponent.get().onAddButtonPressed();
            } else {
                mViewComponent.get().displayToastMessage("A maximum of 10 forms can be saved at a time. Delete a saved form in order to add a new form.", Toast.LENGTH_LONG);
            }
        }
    }

    /**
     * Handles navigation when item's submit button is pressed
     * @param itemId
     * @param callback
     */
    @Override
    public void navigateOnItemSubmitButtonPressed(String itemId, IFormListItemViewModel callback) {
        for(Form formItem : mItems) {
            if (formItem.getId().equals(itemId)) {
                mFormRepository.submitForm(mViewComponent.get().getRealmInstance(), formItem, callback);
                break;
            }
        }
        if (mViewComponent.get() != null) {
            mViewComponent.get().onItemSubmitButtonPressed(itemId);
        }
    }

    /**
     * Handles navigation when item's submission is finished
     * @param success
     */
    @Override
    public void navigateOnItemSubmitFinished(boolean success) {
        if (mViewComponent != null && mViewComponent.get() != null) {
            mViewComponent.get().onItemSubmitFinished(success);
        }
    }

    /**
     * Handles navigation when item's edit button is pressed
     * @param itemId
     */
    @Override
    public void navigateOnItemEditButtonPressed(String itemId) {
        if (mViewComponent != null && mViewComponent.get() != null) {
            mViewComponent.get().onItemEditButtonPressed(itemId);
        }
    }

    /**
     * Handles navigation when items delete button is pressed
     * @param itemId
     * @param confirmDeletion
     */
    @Override
    public void navigateOnItemDeleteButtonPressed(String itemId, boolean confirmDeletion) {
        if (confirmDeletion) {
            if (mViewComponent != null && mViewComponent.get() != null) {
                mViewComponent.get().onItemDeleteButtonPressed(itemId);
            }
        } else {
            deletedItemWithId(itemId);
        }
    }

    /**
     * Deletes the item with the specified ID
     * @param itemId
     */
    public void deletedItemWithId(String itemId) {
        for(Form formItem : mItems) {
            if (formItem.getId().equals(itemId)) {
                mFormRepository.deleteForm(mViewComponent.get().getRealmInstance(), formItem);
                break;
            }
        }
        notifyPropertyChanged(BR.addButtonEnabled);
    }

}
