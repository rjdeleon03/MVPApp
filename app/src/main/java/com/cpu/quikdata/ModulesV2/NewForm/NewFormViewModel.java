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
        mFormRepository.getForm(this);
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
     * Handles navigation when form details button is pressed
     */
    public void navigateOnFormDetailsButtonPressed() {
        if (mActivity != null) {
            mActivity.get().onFormDetailsButtonPressed();
        }
    }

    /**
     * Handles navigation when general information button is pressed
     */
    public void navigateOnGenInfoButtonPressed() {
        if (mActivity != null) {
            mActivity.get().onGenInfoButtonPressed();
        }
    }
}
