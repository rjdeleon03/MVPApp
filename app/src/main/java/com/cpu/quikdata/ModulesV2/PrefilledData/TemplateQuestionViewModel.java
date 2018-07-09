package com.cpu.quikdata.ModulesV2.PrefilledData;

import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

public class TemplateQuestionViewModel {

    @Nullable
    private WeakReference<IPrefilledDataActivity> mIPrefilledDataActivity;


    /**
     * Constructor
     */
    public TemplateQuestionViewModel() {

    }

    /**
     * Sets the form list activity interface
     * @param iPrefilledDataActivity
     */
    public void setActivity(IPrefilledDataActivity iPrefilledDataActivity) {
        mIPrefilledDataActivity = new WeakReference<>(iPrefilledDataActivity);
    }
}
