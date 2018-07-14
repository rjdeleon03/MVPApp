package com.cpu.quikdata.ModulesV2.NewForm;

import com.cpu.quikdata.Models.DNCAFormRepository;

import java.lang.ref.WeakReference;

import javax.annotation.Nullable;

public class NewFormViewModel {

    @Nullable
    WeakReference<INewFormActivity> mNewFormActivity;

    private DNCAFormRepository mFormRepository;

    public NewFormViewModel(DNCAFormRepository dncaFormRepository) {
        mFormRepository = dncaFormRepository;
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
