package com.cpu.quikdata.ModulesV2.NewForm;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.Form;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import java.lang.ref.WeakReference;

import javax.annotation.Nullable;

public class NewFormViewModel extends BaseViewModel implements IBaseDataManager<Form> {

    @Nullable
    WeakReference<INewFormActivity> mNewFormActivity;

    private DNCAFormRepository mFormRepository;
    private Form mForm;

    public NewFormViewModel(DNCAFormRepository dncaFormRepository) {
        mFormRepository = dncaFormRepository;
        mFormRepository.getForm(this);
    }

    @Override
    public void onDataReceived(Form data) {
        mForm = data;
    }

    public void setNewFormActivity(INewFormActivity newFormActivity) {
        mNewFormActivity = new WeakReference<>(newFormActivity);
    }

    public void navigateOnFormDetailsButtonPressed() {
        if (mNewFormActivity != null) {
            mNewFormActivity.get().onFormDetailsButtonPressed();
        }
    }

    public void navigateOnGenInfoButtonPressed() {
        if (mNewFormActivity != null) {
            mNewFormActivity.get().onGenInfoButtonPressed();
        }
    }
}
