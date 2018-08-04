package com.cpu.quikdata.ModulesV2.NewForm;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.Form;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import java.lang.ref.WeakReference;

import javax.annotation.Nullable;

public class NewFormViewModel extends BaseViewModel<INewFormActivity> implements IBaseDataManager<Form> {

    private Form mForm;

    /**
     * Constructor
     * @param dncaFormRepository
     */
    public NewFormViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Gets the data
     * If ID is null, a new form is obtained
     * @param id
     */
    public void getData(String id) {
        if (mViewComponent != null && mViewComponent.get() != null) {
            if (id == null) {
                mFormRepository.getForm(mViewComponent.get().getRealmInstance(), this);
            } else {
                mFormRepository.getForm(mViewComponent.get().getRealmInstance(), this, id);
            }
        }
    }

    /**
     * Handles reception of form data
     * @param data
     */
    @Override
    public void onDataReceived(Form data) {
        mForm = data;
    }

    /**
     * Saves the form
     */
    private void saveForm() {
        if (mViewComponent != null && mViewComponent.get() != null) {
            mFormRepository.saveForm(mViewComponent.get().getRealmInstance());
        }
    }

    /**
     * Discards the form
     */
    private void discardForm() {
        if (mViewComponent != null && mViewComponent.get() != null) {
            mFormRepository.discardForm(mViewComponent.get().getRealmInstance());
        }
    }

    /**
     * Handles navigation when form details button is pressed
     */
    public void navigateOnFormDetailsButtonPressed() {
        if (mViewComponent != null) {
            mViewComponent.get().onFormDetailsButtonPressed();
        }
    }

    /**
     * Handles navigation when general information button is pressed
     */
    public void navigateOnGenInfoButtonPressed() {
        if (mViewComponent != null) {
            mViewComponent.get().onGenInfoButtonPressed();
        }
    }

    /**
     * Handles navigation when shelter information button is pressed
     */
    public void navigateOnShelterInfoButtonPressed() {
        if (mViewComponent != null) {
            mViewComponent.get().onShelterInfoButtonPressed();
        }
    }

    /**
     * Handles navigation when food security information button is pressed
     */
    public void navigateOnFoodSecurityInfoButtonPressed() {
        if (mViewComponent != null) {
            mViewComponent.get().onFoodSecurityInfoButtonPressed();
        }
    }

    /**
     * Handles navigation when livelihoods information button is pressed
     */
    public void navigateOnLivelihoodsInfoButtonPressed() {
        if (mViewComponent != null) {
            mViewComponent.get().onLivelihoodsInfoButtonPressed();
        }
    }

    /**
     * Handles navigation when health information button is pressed
     */
    public void navigateOnHealthInfoButtonPressed() {
        if (mViewComponent != null) {
            mViewComponent.get().onHealthInfoButtonPressed();
        }
    }

    /**
     * Handles navigation when wash information button is pressed
     */
    public void navigateOnWashInfoButtonPressed() {
        if (mViewComponent != null) {
            mViewComponent.get().onWashInfoButtonPressed();
        }
    }

    /**
     * Handles navigation when evacuation information button is pressed
     */
    public void navigateOnEvacuationInfoButtonPressed() {
        if (mViewComponent != null) {
            mViewComponent.get().onEvacuationInfoButtonPressed();
        }
    }

    /**
     * Handles navigation when case stories button is pressed
     */
    public void navigateOnCaseStoriesButtonPressed() {
        if (mViewComponent != null) {
            mViewComponent.get().onCaseStoriesButtonPressed();
        }
    }

    /**
     * Handles navigation when save button is pressed
     */
    public void navigateOnSaveButtonPressed() {
        saveForm();
        if (mViewComponent != null) {
            mViewComponent.get().onSaveButtonPressed();
        }
    }

    /**
     * Handles navigation when back button is pressed
     * Means that form will be discarded
     */
    public void onBackPressedWithoutSave() {
        discardForm();
    }
}
